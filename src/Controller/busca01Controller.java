package Controller;

import Model.Cidade;
import Model.DAO.New.CidadeDAO;
import Model.DAO.QueriesDAO;
import Model.ListaLideres;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class busca01Controller implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    TableView tableView;
    @FXML
    static TableView tableViewStatic;
    @FXML
    TableColumn nomeLider;
    @FXML
    TableColumn populacao;

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
        nomeLider.setCellValueFactory(new PropertyValueFactory<>("nome"));
        populacao.setCellValueFactory(new PropertyValueFactory<>("populacao"));

        ObservableList<ListaLideres> busca01 = FXCollections.observableArrayList(QueriesDAO.Lideres());
        tableView.setItems(busca01);
    }

    public static void refreshTable(){
        tableViewStatic.getItems().clear();
        ObservableList<ListaLideres> busca01 = FXCollections.observableArrayList(QueriesDAO.Lideres());
        if(busca01.size() > 0){
            tableViewStatic.setItems(busca01);
        }
    }

}
