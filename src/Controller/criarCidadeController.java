package Controller;

import Model.Cidade;
import Model.DAO.CidadeDAO;
import Model.DAO.LiderDAO;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class criarCidadeController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    private TableView<Cidade> tableView;
    @FXML
    private static TableView<Cidade> tableViewStatic;
    @FXML
    private TableView<String> tableViewLider;
    @FXML
    TableColumn<String, String> columnLider;
    @FXML
    TableColumn<Cidade, SimpleIntegerProperty> column1;
    @FXML
    TableColumn<Cidade, SimpleStringProperty> column2;
    @FXML
    TableColumn<Cidade, SimpleStringProperty>  column3;
    @FXML
    TableColumn<Cidade, SimpleStringProperty>  column4;
    @FXML
    TableColumn<Cidade, SimpleIntegerProperty>  column5;
    @FXML
    TableColumn<Cidade, SimpleStringProperty>  column6;
    @FXML
    TableColumn<Cidade, SimpleStringProperty>  column7;
    @FXML
    TableColumn<Cidade, SimpleStringProperty>  column8;
    @FXML
    TableColumn<Cidade, SimpleStringProperty>  column9;
    @FXML
    private TextField nomeCidade;
    @FXML
    private TextField comercio;
    @FXML
    private TextField clima;
    @FXML
    private TextField vegetacao;
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
    private Cidade cidadeAtual;
    private Cidade cidadeAntiga;
    String lider;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewStatic = tableView;
        reloadCidade();
        initTable();
        initComboBox();

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cidadeAntiga = tableView.getSelectionModel().getSelectedItem();
                if (mouseEvent.getClickCount() == 2){

                    adicionar.setDisable(true);
                    remover.setDisable(false);
                    atualizar.setDisable(false);
                    adicionarLider.setDisable(false);
                    removerLider.setDisable(false);

                    nomeCidade.setText(cidadeAntiga.getNomeCidade());
                    comercio.setText(cidadeAntiga.getComercio());
                    clima.setText(cidadeAntiga.getClima());
                    vegetacao.setText(cidadeAntiga.getVegetacao());
                    populacao.setText(String.valueOf(cidadeAntiga.getPopulacao()));
                    formaGoverno.setText(cidadeAntiga.getFormaGoverno());
                    descricao.setText(cidadeAntiga.getDescricao());

                    ObservableList<Cidade> cidade = FXCollections.observableArrayList(CidadeDAO.Listar());

                    if(cidade.size() > 0){
                        tableView.setItems(cidade);
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
        column2.setCellValueFactory(new PropertyValueFactory<>("nomeCidade"));
        column3.setCellValueFactory(new PropertyValueFactory<>("nomeCampanha"));
        column4.setCellValueFactory(new PropertyValueFactory<>("comercio"));
        column5.setCellValueFactory(new PropertyValueFactory<>("clima"));
        column6.setCellValueFactory(new PropertyValueFactory<>("vegetacao"));
        column7.setCellValueFactory(new PropertyValueFactory<>("populacao"));
        column8.setCellValueFactory(new PropertyValueFactory<>("formaGoverno"));
        column9.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        columnLider.setCellValueFactory(stringStringCellDataFeatures -> new ReadOnlyStringWrapper(stringStringCellDataFeatures.getValue()));
        refreshTable();
    }

    public static void refreshTable(){
        tableViewStatic.getItems().clear();
        ObservableList<Cidade> cidade = FXCollections.observableArrayList(CidadeDAO.Listar());
        if(cidade.size() > 0){
            tableViewStatic.setItems(cidade);
        }
    }

    private void refreshLider(){
        ArrayList<String> lideres = CidadeDAO.ListarLiderCidade(cidadeAntiga);
        tableViewLider.getItems().clear();
        if(lideres.size() > 0){
            tableViewLider.getItems().clear();
            for(int i = 0; i < lideres.size(); i++){
                tableViewLider.getItems().add(lideres.get(i));
            }
        }
    }


    @FXML
    private void adicionar(ActionEvent event){

        cidadeAtual = new Cidade(0, nomeCidade.getText(),  CampanhaAtualController.getCampanhaAtual().getNome(), comercio.getText(), clima.getText(), vegetacao.getText(), Integer.parseInt(populacao.getText()), formaGoverno.getText(), descricao.getText());
        CidadeDAO.Inserir(cidadeAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }

    @FXML
    private void atualizar(ActionEvent event){

        cidadeAtual = new Cidade(cidadeAntiga.getCodigo(), nomeCidade.getText(), cidadeAntiga.getNomeCampanha(), comercio.getText(), clima.getText(), vegetacao.getText(), Integer.parseInt(populacao.getText()), formaGoverno.getText(), descricao.getText());

        CidadeDAO.Atualizar(cidadeAtual);
        refreshTable();
        reloadCidade();
        clearLabels();
        tableViewLider.getItems().clear();
    }

    @FXML
    private void remover(ActionEvent event){

        CidadeDAO.Remover(cidadeAntiga);
        refreshTable();
        reloadCidade();
        clearLabels();
        tableViewLider.getItems().clear();

    }

    void reloadCidade(){
        remover.setDisable(true);
        atualizar.setDisable(true);
        adicionar.setDisable(false);
        adicionarLider.setDisable(true);
        removerLider.setDisable(true);
    }

    private void clearLabels(){
        nomeCidade.clear();
        comercio.clear();
        clima.clear();
        vegetacao.clear();
        populacao.clear();
        formaGoverno.clear();
        descricao.clear();
    }
    @FXML
    private void limpar(ActionEvent event){

        clearLabels();
        reloadCidade();
        refreshTable();
        tableViewLider.getItems().clear();
    }

    @FXML
    private void adicionarLider(ActionEvent event){
        CidadeDAO.InserirLider(cidadeAntiga, comboBox.getValue());
        refreshLider();
    }

    @FXML
    private void removerLider(ActionEvent event){
        CidadeDAO.RemoverLider(cidadeAntiga, lider);
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
