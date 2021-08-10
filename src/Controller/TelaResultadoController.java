package Controller;

import Controller.controlledScreen;
import Controller.screensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaResultadoController implements Initializable, controlledScreen {

    screensController myController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @Override
    public void setScreenParent(screensController screenPage) {myController = screenPage;}

    @FXML
    private void goToDataBaseGenerica(ActionEvent event){
        myController.setScreen(main.screen2ID);
    }
}
