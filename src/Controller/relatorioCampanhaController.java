package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class relatorioCampanhaController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    TableView tableView;
    @FXML
    TableColumn nomeCampanha;
    @FXML
    TableColumn descricao;
    @FXML
    TableColumn numeroCidades;
    @FXML
    TableColumn cidadeMaiorPopulacao;
    @FXML
    TableColumn mediaPopulacaoCidades;
    @FXML
    TableColumn numeroLideres;
    @FXML
    TextField barraPesquisa;

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

    @FXML
    private void Pesquisar(ActionEvent event){
        tableView.getColumns().clear();
        String pesquisa = barraPesquisa.getText();

        //ObservableList<relatorioCampanha> nomeCampanha = FXCollections.observableArrayList(DAO.Search(pesquisa));
        //tableView.setItems(nomeCampanha);
    }

    private void initTable(){
        nomeCampanha.setCellValueFactory(new PropertyValueFactory<>("campanha"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        numeroCidades.setCellValueFactory(new PropertyValueFactory<>("numeroCidades"));
        cidadeMaiorPopulacao.setCellValueFactory(new PropertyValueFactory<>("cidadeMaiorPopulacao"));
        mediaPopulacaoCidades.setCellValueFactory(new PropertyValueFactory<>("mediaPopulacaoCidade"));
        numeroLideres.setCellValueFactory(new PropertyValueFactory<>("numeroLideres"));

        //ObservableList<relatorioCampanha> nomeCampanha = FXCollections.observableArrayList(DAO.List()));
        //tableView.setItems(nomeCampanha);
    }
}
