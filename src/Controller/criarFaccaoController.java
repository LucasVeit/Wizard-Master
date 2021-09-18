package Controller;

import Model.ConnectPostgre;
import Model.DAO.New.FaccaoDAO;
import Model.DAO.New.LiderDAO;
import Model.Faccao;
import Model.Lider;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.main;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class criarFaccaoController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    private TableView<Faccao> tableView;
    @FXML
    private TableView<String> tableViewLider;
    @FXML
    TableColumn<String, String> columnLider;
    @FXML
    TableColumn<Faccao, SimpleIntegerProperty> column1;
    @FXML
    TableColumn<Faccao, SimpleStringProperty>  column2;
    @FXML
    TableColumn<Faccao, SimpleStringProperty>  column3;
    @FXML
    TableColumn<Faccao, SimpleIntegerProperty>  column4;
    @FXML
    TableColumn<Faccao, SimpleStringProperty>  column5;
    @FXML
    TableColumn<Faccao, SimpleStringProperty>  column6;

    @FXML
    private TextField nomeFaccao;
    @FXML
    private TextField populacao;
    @FXML
    private TextField formaGoverno;
    @FXML
    private TextField descricao;
    @FXML
    private Button adicionar;
    @FXML
    private Button remover;
    @FXML
    private Button atualizar;
    @FXML
    private Button limpar;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Button adicionarLider;
    @FXML
    private Button removerLider;

    private Faccao faccaoAtual;
    private Faccao faccaoAntiga;
    String lider;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reloadFaccao();
        initTable();
        initComboBox();

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                faccaoAntiga = tableView.getSelectionModel().getSelectedItem();
                if (mouseEvent.getClickCount() == 2){

                    adicionar.setDisable(true);
                    remover.setDisable(false);
                    atualizar.setDisable(false);
                    adicionarLider.setDisable(false);
                    removerLider.setDisable(false);

                    nomeFaccao.setText(faccaoAntiga.getNomeFaccao());
                    populacao.setText(String.valueOf(faccaoAntiga.getPopulacao()));
                    formaGoverno.setText(faccaoAntiga.getFormaGoverno());
                    descricao.setText(faccaoAntiga.getDescricao());


                    ObservableList<Faccao> faccao = FXCollections.observableArrayList(FaccaoDAO.Listar());

                    if(faccao.size() > 0){
                        tableView.setItems(faccao);
                    }


                    refreshLider();
                    initComboBox();
                }
            }});

        tableViewLider.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                lider = tableViewLider.getSelectionModel().getSelectedItem();
            }
        });

        populacao.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    populacao.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToNovaCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }{}


    public void initTable(){

        column1.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nomeFaccao"));
        column3.setCellValueFactory(new PropertyValueFactory<>("nomeCampanha"));
        column4.setCellValueFactory(new PropertyValueFactory<>("populacao"));
        column5.setCellValueFactory(new PropertyValueFactory<>("formaGoverno"));
        column6.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        columnLider.setCellValueFactory(stringStringCellDataFeatures -> new ReadOnlyStringWrapper(stringStringCellDataFeatures.getValue()));
        refreshTable();
    }

    private void refreshTable(){
        tableView.getItems().clear();
        ObservableList<Faccao> faccao = FXCollections.observableArrayList(FaccaoDAO.Listar());
        if(faccao.size() > 0){
            tableView.setItems(faccao);
        }
    }


    @FXML
    private void adicionar(ActionEvent event){

        faccaoAtual = new Faccao(0, nomeFaccao.getText(), "Lorin", Integer.parseInt(populacao.getText()), formaGoverno.getText(), descricao.getText());
        FaccaoDAO.Inserir(faccaoAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }

    @FXML
    private void atualizar(ActionEvent event){

        faccaoAtual = new Faccao(faccaoAntiga.getCodigo(), nomeFaccao.getText(), faccaoAntiga.getNomeCampanha(), Integer.parseInt(populacao.getText()), formaGoverno.getText(), descricao.getText());

        FaccaoDAO.Atualizar(faccaoAtual);
        refreshTable();
        reloadFaccao();
        clearLabels();
        tableViewLider.getItems().clear();
    }

    @FXML
    private void remover(ActionEvent event){

        FaccaoDAO.Remover(faccaoAntiga);
        refreshTable();
        reloadFaccao();
        clearLabels();
        tableViewLider.getItems().clear();

    }

    void reloadFaccao(){
        remover.setDisable(true);
        atualizar.setDisable(true);
        adicionar.setDisable(false);
        adicionarLider.setDisable(true);
        removerLider.setDisable(true);
    }

    private void clearLabels(){
        nomeFaccao.clear();
        populacao.clear();
        formaGoverno.clear();
        descricao.clear();
    }

    private void refreshLider(){
        ArrayList<String> lideres = FaccaoDAO.ListarLiderFaccao(faccaoAntiga);
        tableViewLider.getItems().clear();
        if(lideres.size() > 0){
            tableViewLider.getItems().clear();
            for(int i = 0; i < lideres.size(); i++){
                tableViewLider.getItems().add(lideres.get(i));

            }
        }
    }
    @FXML
    private void limpar(ActionEvent event){

        clearLabels();
        reloadFaccao();
        tableViewLider.getItems().clear();

    }

    @FXML
    private void adicionarLider(ActionEvent event){
        FaccaoDAO.InserirLider(faccaoAntiga, comboBox.getValue());
        refreshLider();
    }

    @FXML
    private void removerLider(ActionEvent event){
        FaccaoDAO.RemoverLider(faccaoAntiga, lider);
        refreshLider();
    }

    public void initComboBox(){
        comboBox.getItems().clear();
        ArrayList<Lider> lider = LiderDAO.Listar();
        for(int i = 0; i < lider.size(); ++i){
            comboBox.getItems().add(lider.get(i).getNomeLider());
        }
    }
}
