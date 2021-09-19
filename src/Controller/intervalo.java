package Controller;

import Model.DAO.MagiaDAO;
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
    TableColumn nivelGrupo;
    @FXML
    TextField barraPesquisa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        tableView.getColumns().clear();
        String pesquisa = barraPesquisa.getText();

        //ObservableList<intervalo> nivel = FXCollections.observableArrayList(DAO.Search(pesquisa));
        //tableView.setItems(nivel);
    }

    private void initTable(){
        nivelGrupo.setCellValueFactory(new PropertyValueFactory<>("nivelGrupo"));

        //ObservableList<intervalo> nivel = FXCollections.observableArrayList(DAO.List()));
        //tableView.setItems(nivel);
    }

}
