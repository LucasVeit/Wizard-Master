package Controller;

import Model.*;
import Model.DAO.New.CidadeDAO;
import Model.DAO.New.LiderDAO;
import Model.DAO.New.PanteaoDAO;
import Model.DAO.DeusDAO;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
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

public class criarPanteaoController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    private TableView<Panteao> tableView;
    @FXML
    private static TableView<Panteao> tableViewStatic;
    @FXML
    TableColumn<Panteao, SimpleStringProperty> column1;
    @FXML
    TableColumn<Panteao, SimpleIntegerProperty> column2;
    @FXML
    private TextField nomeDeus;
    @FXML
    private TextField mitologia;
    @FXML
    private TextField dominio;
    @FXML
    private TextField tendencia;
    @FXML
    private TextField simbolo;
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
    private Deus deus;
    private Panteao panteao;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewStatic = tableView;
        reloadPanteao();
        initTable();
        initComboBox();

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2){
                    panteao = tableView.getSelectionModel().getSelectedItem();
                    deus = DeusDAO.GetDeusID(panteao.getCodigoDeus());

                    adicionar.setDisable(true);
                    remover.setDisable(false);
                    comboBox.setDisable(true);

                    nomeDeus.setText(deus.getNomeDeus());
                    mitologia.setText(deus.getMitologia());
                    dominio.setText(deus.getDominio());
                    tendencia.setText(deus.getTendencia());
                    simbolo.setText(deus.getSimbolo());
                    descricao.setText(deus.getDescricao());

                    ObservableList<Panteao> panteao = FXCollections.observableArrayList(PanteaoDAO.Listar());

                    if(panteao.size() > 0){
                        tableView.setItems(panteao);
                    }
                }
            }});

        comboBox.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                deus = DeusDAO.GetDeus(comboBox.getValue());


                nomeDeus.setText(deus.getNomeDeus());
                mitologia.setText(deus.getMitologia());
                dominio.setText(deus.getDominio());
                tendencia.setText(deus.getTendencia());
                simbolo.setText(deus.getSimbolo());
                descricao.setText(deus.getDescricao());
            }});
    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToNovaCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }{}

    void reloadPanteao(){
        remover.setDisable(true);
        adicionar.setDisable(false);
        comboBox.setDisable(false);
    }

    public void initTable(){
        column1.setCellValueFactory(new PropertyValueFactory<>("nomeCampanha"));
        column2.setCellValueFactory(new PropertyValueFactory<>("codigoDeus"));
        column1.setPrefWidth(200);
        column2.setPrefWidth(200);
        refreshTable();
    }

    public static void refreshTable(){
        tableViewStatic.getItems().clear();
        ObservableList<Panteao> panteao = FXCollections.observableArrayList(PanteaoDAO.Listar());
        if(panteao.size() > 0){
            tableViewStatic.setItems(panteao);
        }
    }


    @FXML
    private void adicionar(ActionEvent event){

        Panteao panteaoAtual = new Panteao( CampanhaAtualController.getCampanhaAtual().getNome(), DeusDAO.GetDeus(comboBox.getValue()).getCodigoDeus());
        PanteaoDAO.Inserir(panteaoAtual);
        //adicionar no banco de dados

        refreshTable();
        reloadPanteao();
        clearLabels();
    }

    @FXML
    private void remover(ActionEvent event){

        PanteaoDAO.Remover(panteao);
        refreshTable();
        reloadPanteao();
        clearLabels();
    }

    private void clearLabels(){
        nomeDeus.clear();
        mitologia.clear();
        dominio.clear();
        tendencia.clear();
        simbolo.clear();
        descricao.clear();
    }

    @FXML
    private void limpar(ActionEvent event){
        clearLabels();
        reloadPanteao();
        refreshTable();
    }

    public void initComboBox(){
        comboBox.getItems().clear();
        ArrayList<Deus> deus = DeusDAO.Listar();
        for(int i = 0; i < deus.size(); ++i){
            comboBox.getItems().add(deus.get(i).getNomeDeus());
        }
    }
}
