package Controller;

import Model.Cidade;
import Model.DAO.New.CidadeDAO;
import Model.DAO.New.LiderDAO;
import Model.Lider;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
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

public class criarLiderController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    private TableView<Lider> tableView;
    @FXML
    TableColumn<Lider, SimpleStringProperty> column1;
    @FXML
    TableColumn<Lider, SimpleStringProperty>  column2;
    @FXML
    TableColumn<Lider, SimpleStringProperty>  column3;
    @FXML
    TableColumn<Lider, SimpleStringProperty>  column4;

    @FXML
    private TextField nomeLider;
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

    private Lider liderAtual;
    private Lider liderAntigo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reloadLider();

        initTable();

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                liderAntigo = tableView.getSelectionModel().getSelectedItem();
                if (mouseEvent.getClickCount() == 2){

                    adicionar.setDisable(true);
                    remover.setDisable(false);
                    atualizar.setDisable(false);

                    nomeLider.setText(liderAntigo.getNomeLider());
                    descricao.setText(liderAntigo.getDescricao());

                    ObservableList<Lider> lider = FXCollections.observableArrayList(LiderDAO.Listar());

                    if(lider.size() > 0){
                        tableView.setItems(lider);
                    }
                }
            }});
    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToNovaCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }{}



    public void initTable(){

        column1.setCellValueFactory(new PropertyValueFactory<>("codigoLider"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nomeLider"));
        column3.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        column4.setCellValueFactory(new PropertyValueFactory<>("nomeCampanha"));
        refreshTable();
    }

    private void refreshTable(){
        tableView.getItems().clear();
        ObservableList<Lider> lider = FXCollections.observableArrayList(LiderDAO.Listar());
        if(lider.size() > 0){
            tableView.setItems(lider);
        }
    }

    void reloadLider(){
        remover.setDisable(true);
        atualizar.setDisable(true);
        adicionar.setDisable(false);
    }


    @FXML
    private void adicionar(ActionEvent event){

        liderAtual = new Lider(0, nomeLider.getText(), descricao.getText(), "Lorin");
        LiderDAO.Inserir(liderAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }

    @FXML
    private void atualizar(ActionEvent event){

        liderAtual = new Lider(liderAntigo.getCodigoLider(), nomeLider.getText(), descricao.getText() , "Lorin");

        LiderDAO.Atualizar(liderAtual);
        refreshTable();
        reloadLider();
        clearLabels();
    }

    @FXML
    private void remover(ActionEvent event){

        LiderDAO.Remover(liderAntigo);
        refreshTable();
        reloadLider();
        clearLabels();

    }

    private void clearLabels(){
        nomeLider.clear();
        descricao.clear();
    }

    @FXML
    private void limpar(ActionEvent event){

        clearLabels();
        reloadLider();
    }


}
