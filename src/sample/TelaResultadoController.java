package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaResultadoController implements Initializable, controlledScreen{

    @FXML
    private TextArea comment;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void setScreenParent(screensController screenPage) {}
}
