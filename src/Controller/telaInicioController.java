package Controller;

import java.net.URL;
import java.util.ResourceBundle;
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
        myController.setScreen(main.screen11ID);
    }

    @FXML
    private void goToCarregarCampanha(ActionEvent event){
        myController.setScreen(main.screen12ID);
    }
}
