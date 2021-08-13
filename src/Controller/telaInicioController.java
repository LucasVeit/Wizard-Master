package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.controlledScreen;
import Controller.screensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.main;

public class telaInicioController implements  Initializable, controlledScreen {

    screensController myController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToDatabaseGenerica(ActionEvent event){
        myController.setScreen(main.screen2ID);
    }

    @FXML
    private void goToNovaCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }
}
