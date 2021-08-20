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
    private Label tittle;
    @FXML
    Label subtittle;
    @FXML
    Label text;
    InputStream stream = null;
    @FXML
    Image image;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        insertText();
        //insertImage();
    }

    @Override
    public void setScreenParent(screensController screenPage) {myController = screenPage;}

    @FXML
    private void goToDataBaseGenerica(ActionEvent event){
        myController.setScreen(main.screen2ID);
    }

    private void insertText(){
        tittle.setText("TÍTULO");
        subtittle.setText("Descrição");
        text.setText("Os pequeninos halflings sobrevivem em um mundo cheio\n" +
                "de criaturas maiores ao evitar serem notados, ou evitando\n" +
                "o combate direto. Com uns 90 centímetros de altura, eles\n" +
                "parecem inofensivos e assim conseguiram sobreviver por\n" +
                "séculos às sombras dos impérios e à margem de guerras e\n" +
                "conflitos políticos. Eles normalmente são robustos,\n" +
                "pesando entre 20 kg e 22,5 kg.");
    }

    private void insertImage(){
        try {
            stream = new FileInputStream("Resources//Imagem.png");
            image = new Image(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
