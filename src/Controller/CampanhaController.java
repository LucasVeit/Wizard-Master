package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class CampanhaController implements Initializable, controlledScreen {

    screensController myController;

    @FXML
    Button criarPersonagem;
    @FXML
    Button criarMundo;
    @FXML
    Button criarCidade;
    @FXML
    Button criarPanteao;
    @FXML
    Button criarFaccao;
    @FXML
    Button criarLider;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToTelaInicio(ActionEvent event){
        myController.setScreen(main.screen1ID);
    }

    @FXML
    private void goToTelaCriarCidade(ActionEvent event){
        myController.setScreen(main.screen5ID);
        criarCidadeController.refreshTable();
    }

    @FXML
    private void goToTelaCriarFaccao(ActionEvent event){
        myController.setScreen(main.screen6ID);
        criarFaccaoController.refreshTable();
    }

    @FXML
    private void goToTelaCriarLider(ActionEvent event){
        myController.setScreen(main.screen7ID);
        criarLiderController.refreshTable();
    }

    @FXML
    private void goToTelaCriarMundo(ActionEvent event){
        myController.setScreen(main.screen8ID);
        criarMundoController.refreshTable();
    }

    @FXML
    private void goToTelaCriarPanteao(ActionEvent event){
        myController.setScreen(main.screen9ID);
        criarPanteaoController.refreshTable();
    }

    @FXML
    private void goToTelaCriarPersonagem(ActionEvent event){
        myController.setScreen(main.screen10ID);
        criarPersonagemController.refreshTable();
    }

    @FXML
    private void goToTelaIntervalo(ActionEvent event){
        myController.setScreen(main.screen13ID);
        intervalo.refreshTable();
    }

    @FXML
    private void goToTelaRelatorioCampanha(ActionEvent event){
        myController.setScreen(main.screen14ID);
        relatorioCampanhaController.refreshTable();
    }

    @FXML
    private void goToBusca01(ActionEvent event){
        myController.setScreen(main.screen15ID);
        busca01Controller.refreshTable();
    }

    @FXML
    private void goToBusca02(ActionEvent event){
        myController.setScreen(main.screen16ID);
        busca02Controller.refreshTable();
    }

}
