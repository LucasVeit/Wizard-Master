package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class busca02Controller implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    TableView tableView;
    @FXML
    TableColumn nomeJogador;
    @FXML
    TableColumn nomeMonstro;
    @FXML
    TableColumn habilidade;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }

    private void initTable(){
        nomeJogador.setCellValueFactory(new PropertyValueFactory<>("nomeJogador"));
        nomeMonstro.setCellValueFactory(new PropertyValueFactory<>("nomeMonstro"));
        habilidade.setCellValueFactory(new PropertyValueFactory<>("habilidade"));

        //ObservableList<Busca02> busca02 = FXCollections.observableArrayList(DAO.List()));
        //tableView.setItems(busca02);
    }
}
