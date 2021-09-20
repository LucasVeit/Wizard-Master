package Controller;

import Model.Campanha;
import Model.DAO.CampanhaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class carregarCampanhaController implements Initializable, controlledScreen {

    screensController myController;

    @FXML
    Button carregar;
    @FXML
    private Button atualizar;
    @FXML
    TextField nome;
    @FXML
    private TextArea descricao;
    @FXML
    private TableView<Campanha> tableView;
    @FXML
    private TableColumn<Campanha, String> columnNome;
    @FXML
    private TableColumn<Campanha, String> columnDescricao;
    private Campanha campanhaAntiga;
    private Campanha campanhaAtual;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reloadCampanha();
        initTable();
        nome.setEditable(false);
        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                campanhaAntiga = tableView.getSelectionModel().getSelectedItem();
                if (mouseEvent.getClickCount() == 2){

                    carregar.setDisable(false);
                    atualizar.setDisable(false);

                    nome.setText(campanhaAntiga.getNome());
                    descricao.setText(campanhaAntiga.getDescricao());

                    ObservableList<Campanha> campanhas = FXCollections.observableArrayList(CampanhaDAO.Listar());

                    if(campanhas.size() > 0){
                        tableView.setItems(campanhas);
                    }
                }
            }});
    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToTelaInicio(ActionEvent event){
        myController.setScreen(main.screen1ID);
    }

    @FXML
    private void goToCampanha(ActionEvent event){
        campanhaAtual = new Campanha(nome.getText(), descricao.getText());
        CampanhaAtualController.setCampanhaAtual(campanhaAtual);
        myController.setScreen(main.screen3ID);
    }

    public void initTable(){
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        refreshTable();
    }

    void reloadCampanha(){
        carregar.setDisable(true);
        atualizar.setDisable(true);
    }

    public void refreshTable(){
        tableView.getItems().clear();
        ObservableList<Campanha> campanha = FXCollections.observableArrayList(CampanhaDAO.Listar());
        if(campanha.size() > 0){
            tableView.setItems(campanha);
        }
    }


    @FXML
    private void atualizar(ActionEvent event){

        campanhaAtual = new Campanha(nome.getText(), descricao.getText());
        CampanhaDAO.Atualizar(campanhaAtual);

        refreshTable();
    }

}
