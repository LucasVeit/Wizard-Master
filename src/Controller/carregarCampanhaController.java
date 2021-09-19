package Controller;

import Model.Campanha;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.main;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class carregarCampanhaController implements Initializable, controlledScreen {

    screensController myController;

    @FXML
    private Button carregar;
    @FXML
    private Button tualizar;
    @FXML
    private Button excluir;
    @FXML
    TextField Nome;
    @FXML
    private TextArea descricao;
    @FXML
    private TableView<Campanha> tableView;
    @FXML
    private TableColumn<Campanha, String> columnNome;
    @FXML
    private TableColumn<Campanha, String> columnDescricao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToTelaInicio(ActionEvent event){
        myController.setScreen(main.screen1ID);
    }

    @FXML
    private void goToCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }

    public void initTable(){

    }

}
