package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class relatorioCampanhaController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    TableView tableView;
    @FXML
    TableColumn nomeCampanha;
    @FXML
    TableColumn descricao;
    @FXML
    TableColumn numeroCidades;
    @FXML
    TableColumn cidadeMaiorPopulacao;
    @FXML
    TableColumn mediaPopulacaoCidades;
    @FXML
    TableColumn numeroLideres;
    @FXML
    Button pesquisar;
    @FXML
    TextField barraPesquisa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }
}
