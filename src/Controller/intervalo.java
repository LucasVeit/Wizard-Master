package Controller;

import Model.DAO.MagiaDAO;
import Model.DAO.QueriesDAO;
import Model.Desafios;
import Model.Intervalo;
import Model.Magia;
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

public class intervalo implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    TableView tableView;
    @FXML
    static TableView tableViewStatic;
    @FXML
    TableColumn nivelGrupo;
    @FXML
    TableColumn nomeMonstro;
    @FXML
    TextField barraPesquisa;

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

    @FXML
    private void Pesquisar(ActionEvent event){
        tableView.getItems().clear();
        int pesquisa = Integer.valueOf(barraPesquisa.getText());

        ObservableList<Intervalo> nivel = FXCollections.observableArrayList(QueriesDAO.Intervalo(pesquisa));
        tableView.setItems(nivel);
    }

    private void initTable(){
        nomeMonstro.setCellValueFactory(new PropertyValueFactory<>("nome"));
        nivelGrupo.setCellValueFactory(new PropertyValueFactory<>("nivel"));

        ObservableList<Intervalo> nivel = FXCollections.observableArrayList(QueriesDAO.Intervalo(10));
        tableView.setItems(nivel);
    }

    public static void refreshTable() {
        tableViewStatic.getItems().clear();
        ObservableList<Intervalo> nivel = FXCollections.observableArrayList(QueriesDAO.Intervalo(10));
        if (nivel.size() > 0) {
            tableViewStatic.setItems(nivel);
        }
    }

}
