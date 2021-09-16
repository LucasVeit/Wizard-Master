package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class novaCampanhaController implements Initializable, controlledScreen {

    screensController myController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToTelaInicio(ActionEvent event){
        myController.setScreen(main.screen1ID);
    }

    @FXML
    private void goToTelaCriarCidade(ActionEvent event){
        myController.setScreen(main.screen5ID);
    }

    @FXML
    private void goToTelaCriarFaccao(ActionEvent event){
        myController.setScreen(main.screen6ID);
    }

    @FXML
    private void goToTelaCriarLider(ActionEvent event){
        myController.setScreen(main.screen7ID);
    }

    @FXML
    private void goToTelaCriarMundo(ActionEvent event){
        myController.setScreen(main.screen8ID);
    }

    @FXML
    private void goToTelaCriarPanteao(ActionEvent event){
        myController.setScreen(main.screen9ID);
    }

    @FXML
    private void goToTelaCriarPersonagem(ActionEvent event){
        myController.setScreen(main.screen10ID);
    }

}
