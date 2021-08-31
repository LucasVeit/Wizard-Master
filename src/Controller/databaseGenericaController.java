package Controller;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.ConnectPostgre;
import Model.DAO.MagiaDAO;
import Model.Magia;
import Model.TempMonstro;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.main;

import javax.swing.text.TabableView;

public class databaseGenericaController extends TelaResultadoController implements Initializable, controlledScreen {

    //Screen controller
    private screensController myController;
    //private ConnectPostgre connection;
    //private ResultSet resultSet;
    //private PreparedStatement pst;

    //configure the table
    @FXML private TableView<Magia> tableView;
    @FXML private TableColumn<Magia, SimpleStringProperty> tableColumn1;
    @FXML private TableColumn<Magia, SimpleStringProperty> tableColumn2;
    @FXML private TableColumn<Magia, SimpleStringProperty> tableColumn3;
    @FXML private TableColumn<Magia, SimpleStringProperty> tableColumn4;
    @FXML private TableColumn<Magia, SimpleStringProperty> tableColumn5;
    @FXML private TableColumn<Magia, SimpleStringProperty> tableColumn6;
    @FXML private TableColumn<Magia, SimpleStringProperty> tableColumn7;
    @FXML private TableColumn<Magia, SimpleStringProperty> tableColumn8;
    @FXML private TextField barraPesquisa;
    @FXML
    ComboBox<String> comboBox01;
    @FXML
    ComboBox<String> comboBox02;
    String pesquisa, categoria, atributo, title, subtitle, text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set up te columns in the table
        InsertChoiceBox();
        tableView.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                Magia magia = tableView.getSelectionModel().getSelectedItem();
                if (mouseEvent.getClickCount() == 2) //Checking double click
                {
                    title = magia.getNomeMagia();
                    subtitle = tableColumn4.getText();
                    text = magia.getDescricao();
                    goToTelaResultado();
                    staticLabelTitle.setText(title);
                    staticLabelSubtitle.setText(subtitle);
                    staticLabelText.setText(text);
                }
            }
        });
    }

    @Override
    public void setScreenParent(screensController screenPage) {myController = screenPage;}

    @FXML
    private void goToTelaInicio(ActionEvent event){
        myController.setScreen(main.screen1ID);
    }

    private void goToTelaResultado(){
        myController.setScreen(main.screen4ID);
    }

    @FXML
    private void Pesquisar(ActionEvent event){
        tableView.getColumns().clear();
        pesquisa = barraPesquisa.getText();
        //System.out.println(pesquisa);
        categoria = comboBox01.getValue();
        //System.out.println(categoria);
        atributo = comboBox02.getValue();
        //System.out.println(atributo);

        if(categoria == "Magia"){ // nao precisa fazer isso toda vez se cada tablecolumn for ser fixo uma tablecolumn de magia
            tableColumn1 = new TableColumn<>("Nome Magia");
            tableColumn2 = new TableColumn<>("Tipo");
            tableColumn3 = new TableColumn<>("Nível");
            tableColumn4 = new TableColumn<>("Descrição");
            tableColumn5 = new TableColumn<>("Duração");
            tableColumn6 = new TableColumn<>("Componentes");
            tableColumn7 = new TableColumn<>("Alcance");
            tableColumn8 = new TableColumn<>("Tempo Conjuração");
            tableColumn1.setCellValueFactory(new PropertyValueFactory<>("nomeMagia"));
            tableColumn2.setCellValueFactory(new PropertyValueFactory<>("tipo"));
            tableColumn3.setCellValueFactory(new PropertyValueFactory<>("nivel"));
            tableColumn4.setCellValueFactory(new PropertyValueFactory<>("descricao"));
            tableColumn5.setCellValueFactory(new PropertyValueFactory<>("duracao"));
            tableColumn6.setCellValueFactory(new PropertyValueFactory<>("componentes"));
            tableColumn7.setCellValueFactory(new PropertyValueFactory<>("alcance"));
            tableColumn8.setCellValueFactory(new PropertyValueFactory<>("tempoConjuracao"));
            tableColumn1.setPrefWidth(100);
            tableColumn2.setPrefWidth(100);
            tableColumn2.setPrefWidth(100);
            tableColumn3.setPrefWidth(100);
            tableColumn4.setPrefWidth(100);
            tableColumn5.setPrefWidth(100);
            tableColumn6.setPrefWidth(100);
            tableColumn7.setPrefWidth(100);
            tableColumn8.setPrefWidth(100);
            tableView.getColumns().addAll(tableColumn1, tableColumn2, tableColumn3, tableColumn4,
                    tableColumn5, tableColumn6, tableColumn7, tableColumn8);

            ObservableList<Magia> magias = FXCollections.observableArrayList(MagiaDAO.SearchByText(pesquisa, categoria, atributo));
            tableView.setItems(magias);
        }
    }

    @FXML
    private void comboAction(ActionEvent event) {
        comboBox02.getItems().clear();

        System.out.println(comboBox01.getValue());
        if(comboBox01.getValue() == "Magia"){
            comboBox02.getItems().addAll("nomeMagia", "nivel", "tipo", "descricao"); //SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'some_table';
        }else if(comboBox01.getValue() == "Item"){

        }else if(comboBox01.getValue() == "Pericia"){

        }else if(comboBox01.getValue() == "Talento"){

        }else if(comboBox01.getValue() == "Antecedente"){

        }else if(comboBox01.getValue() == "Deus"){

        }

    }
    public void InsertChoiceBox(){
        comboBox01.getItems().addAll("Magia", "Item", "Pericia", "Talento", "Antecedente", "Deus");
        // SELECT table_name FROM information_schema.tables WHERE table_type='BASE TABLE' AND table_schema='public';
    }
}
