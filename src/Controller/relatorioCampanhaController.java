package Controller;

import Model.DAO.QueriesDAO;
import Model.Desafios;
import Model.Relatorio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class relatorioCampanhaController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    TableView tableView;
    @FXML
    static TableView tableViewStatic;
    @FXML
    TableColumn nomeCampanha;
    @FXML
    TableColumn descricao;
    @FXML
    TableColumn numeroCidades;
    @FXML
    TableColumn cidadeMenorPopulacao;
    @FXML
    TableColumn cidadeMaiorPopulacao;
    @FXML
    TableColumn mediaPopulacaoCidades;
    @FXML
    TableColumn numeroLideres;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewStatic = tableView;
        initTable();
    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }


    private void initTable(){
        nomeCampanha.setCellValueFactory(new PropertyValueFactory<>("nomeCampanha"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        numeroCidades.setCellValueFactory(new PropertyValueFactory<>("cidades"));
        cidadeMenorPopulacao.setCellValueFactory(new PropertyValueFactory<>("cidadeMenorPopulacao"));
        cidadeMaiorPopulacao.setCellValueFactory(new PropertyValueFactory<>("CidadeMaiorPopulacao"));
        mediaPopulacaoCidades.setCellValueFactory(new PropertyValueFactory<>("mediaPopulacao"));
        numeroLideres.setCellValueFactory(new PropertyValueFactory<>("numeroLideres"));

        ObservableList<Relatorio> nomeCampanha = FXCollections.observableArrayList(QueriesDAO.Relatorio());
        tableView.setItems(nomeCampanha);
    }

    public static void refreshTable() {
        tableViewStatic.getItems().clear();
        ObservableList<Relatorio> nomeCampanha = FXCollections.observableArrayList(QueriesDAO.Relatorio());
        if (nomeCampanha.size() > 0) {
            tableViewStatic.setItems(nomeCampanha);
        }
    }

}
