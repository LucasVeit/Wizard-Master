package Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.TextFlow;
import sample.main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;

public class TelaResultadoController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    private Label title;
    public static Label staticLabelTitle;
    @FXML
    private TextFlow textFlowPane;
    public static TextFlow staticTextFlowPane;
    @FXML
    private javafx.scene.image.ImageView image;
    public static javafx.scene.image.ImageView staticImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staticLabelTitle = title;
        staticTextFlowPane = textFlowPane;
        staticImageView = image;
    }

    @Override
    public void setScreenParent(screensController screenPage) {myController = screenPage;}

    @FXML
    private void goToDataBaseGenerica(ActionEvent event){
        myController.setScreen(main.screen2ID);
    }

}
