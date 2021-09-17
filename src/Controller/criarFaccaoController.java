package Controller;

import Model.Faccao;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.main;
import java.net.URL;
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
    TableColumn<Faccao, SimpleStringProperty> column1;
    @FXML
    TableColumn<Faccao, SimpleStringProperty>  column2;
    @FXML
    TableColumn<Faccao, SimpleStringProperty>  column3;
    @FXML
    TableColumn<Faccao, SimpleStringProperty>  column4;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToNovaCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }{}

}
