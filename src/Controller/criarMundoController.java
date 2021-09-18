package Controller;

import Model.DAO.New.LiderDAO;
import Model.DAO.New.MundoDAO;
import Model.DAO.PlanoDAO;
import Model.Lider;
import Model.Mundo;
import Model.Plano;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.main;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class criarMundoController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    private TableView<Mundo> tableView;
    @FXML
    TableColumn<Mundo, SimpleStringProperty> column1;
    @FXML
    TableColumn<Mundo, SimpleStringProperty> column2;
    @FXML
    private TextField corCortina;
    @FXML
    private TextField corPoco;
    @FXML
    private TextField descricao;
    @FXML
    private Button adicionar;
    @FXML
    private Button remover;
    @FXML
    private Button limpar;
    @FXML
    private ComboBox<String> comboBox;
    private Plano plano;
    private Mundo mundo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reloadMundo();
        initTable();
        initComboBox();

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2){
                    plano = PlanoDAO.GetPlano(comboBox.getValue());
                    mundo = tableView.getSelectionModel().getSelectedItem();

                    adicionar.setDisable(true);
                    remover.setDisable(false);
                    comboBox.setDisable(true);

                    comboBox.setValue(mundo.getNomePlano());

                    corCortina.setText(plano.getCorCortina());
                    corPoco.setText(plano.getCorPoco());
                    descricao.setText(plano.getDescricao());

                    ObservableList<Mundo> mundo = FXCollections.observableArrayList(MundoDAO.Listar());

                    if(mundo.size() > 0){
                        tableView.setItems(mundo);
                    }
                }
            }});

        comboBox.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                plano = PlanoDAO.GetPlano(comboBox.getValue());

                corCortina.setText(plano.getCorCortina());
                corPoco.setText(plano.getCorPoco());
                descricao.setText(plano.getDescricao());
            }});
    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToNovaCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }{}

    void reloadMundo(){
        remover.setDisable(true);
        adicionar.setDisable(false);
        comboBox.setDisable(false);
    }

    public void initTable(){
        column1.setCellValueFactory(new PropertyValueFactory<>("nomeCampanha"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nomePlano"));
        column1.setPrefWidth(200);
        column2.setPrefWidth(200);
        refreshTable();
    }

    private void refreshTable(){
        tableView.getItems().clear();
        ObservableList<Mundo> mundo = FXCollections.observableArrayList(MundoDAO.Listar());
        if(mundo.size() > 0){
            tableView.setItems(mundo);
        }
    }


    @FXML
    private void adicionar(ActionEvent event){

        Mundo mundoAtual = new Mundo("Lorin", comboBox.getValue());
        MundoDAO.Inserir(mundoAtual);
        //adicionar no banco de dados

        refreshTable();
        reloadMundo();
        clearLabels();
    }

    @FXML
    private void remover(ActionEvent event){

        MundoDAO.Remover(mundo);
        refreshTable();
        reloadMundo();
        clearLabels();
    }

    private void clearLabels(){
        corCortina.clear();
        corPoco.clear();
        descricao.clear();
    }

    @FXML
    private void limpar(ActionEvent event){
        clearLabels();
        reloadMundo();
    }

    public void initComboBox(){
        comboBox.getItems().clear();
        ArrayList<Plano> plano = PlanoDAO.Listar();
        for(int i = 0; i < plano.size(); ++i){
            comboBox.getItems().add(plano.get(i).getNomePlano());
        }
    }
}
