package Controller;

import Model.DAO.QueriesDAO;
import Model.Desafios;
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

public class busca02Controller implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    TableView tableView;
    @FXML
    static TableView tableViewStatic;
    @FXML
    TableColumn nomeJogador;
    @FXML
    TableColumn nomeMonstro;
    @FXML
    TableColumn habilidade;

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
        nomeJogador.setCellValueFactory(new PropertyValueFactory<>("jogador"));
        nomeMonstro.setCellValueFactory(new PropertyValueFactory<>("monstro"));
        habilidade.setCellValueFactory(new PropertyValueFactory<>("habilidade"));

        ObservableList<Desafios> desafios = FXCollections.observableArrayList(QueriesDAO.Desafios());
        tableView.setItems(desafios);
    }

    public static void refreshTable() {
        tableViewStatic.getItems().clear();
        ObservableList<Desafios> desafios = FXCollections.observableArrayList(QueriesDAO.Desafios());
        if (desafios.size() > 0) {
            tableViewStatic.setItems(desafios);
        }
    }

}
