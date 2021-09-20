package Controller;

import Model.Campanha;
import Model.DAO.CampanhaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class novaCampanhaController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    TextField nome;
    @FXML
    private TextArea descricao;
    @FXML
    private Button criar;

    private Campanha campanha;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToCampanha(ActionEvent event){
        campanha = new Campanha(nome.getText(), descricao.getText());
        CampanhaDAO.Inserir(campanha);
        CampanhaAtualController.setCampanhaAtual(campanha);
        myController.setScreen(main.screen3ID);
    }

    @FXML
    private void goToTelaInicio(ActionEvent event){
        myController.setScreen(main.screen1ID);
    }
}
