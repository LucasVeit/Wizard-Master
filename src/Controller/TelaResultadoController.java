package Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import sample.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class TelaResultadoController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    static Label title;
    @FXML
    static Label subtitle;
    @FXML
    static Label text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @Override
    public void setScreenParent(screensController screenPage) {myController = screenPage;}

    @FXML
    private void goToDataBaseGenerica(ActionEvent event){
        myController.setScreen(main.screen2ID);
    }

    public static void insertText(String Title, String Subtitle, String Text){
        title.setText(Title);
        subtitle.setText(Subtitle);
        text.setText(Text);
    }

}
