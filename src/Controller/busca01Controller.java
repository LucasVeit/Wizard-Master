package Controller;

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
    TableColumn nomeLider;
    @FXML
    TableColumn populacao;

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

    private void initTable(){
        nomeLider.setCellValueFactory(new PropertyValueFactory<>("nomeLider"));
        populacao.setCellValueFactory(new PropertyValueFactory<>("populacao"));

        //ObservableList<Busca01> busca01 = FXCollections.observableArrayList(DAO.List()));
        //tableView.setItems(busca01);
    }
}
