package Controller;

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
    javafx.scene.control.Button carregar;
    @FXML
    javafx.scene.control.Button atualizar;
    @FXML
    javafx.scene.control.Button excluir;
    @FXML
    TextField Nome;
    @FXML
    javafx.scene.control.TextArea descricao;
    @FXML
    TableView tableView;
    @FXML
    TableColumn columnNome;
    @FXML
    TableColumn columnDescricao;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

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
}
