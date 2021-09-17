package Controller;

import Model.Lider;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.main;
import java.net.URL;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToNovaCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }{}
}
