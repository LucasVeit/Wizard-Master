package Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import sample.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javax.swing.*;

public class TelaResultadoController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    private Label title;
    @FXML
    private Label subtitle;
    @FXML
    private Label text;

    public static Label staticLabelTitle;
    public static Label staticLabelSubtitle;
    public static Label staticLabelText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staticLabelTitle = title;
        staticLabelSubtitle = subtitle;
        staticLabelText = text;
    }

    @Override
    public void setScreenParent(screensController screenPage) {myController = screenPage;}

    @FXML
    private void goToDataBaseGenerica(ActionEvent event){
        myController.setScreen(main.screen2ID);
    }


}
