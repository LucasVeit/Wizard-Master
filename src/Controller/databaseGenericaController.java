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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.main;

import javax.swing.text.TabableView;

public class databaseGenericaController implements Initializable, controlledScreen {

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
   // private ObservableList<ObservableList> data;
    @FXML private TextField barraPesquisa;
    @FXML
    ComboBox<String> comboBox01;
    @FXML
    ComboBox<String> comboBox02;
    String pesquisa, categoria, atributo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set up te columns in the table
        InsertChoiceBox();
        /*
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("nomeMagia"));
        tableDescricao = new TableColumn<>("Descrição");
        tableDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableDescricao.setPrefWidth(100);
        tableView.getColumns().add(tableDescricao);

        //load data
        tableView.setItems(getMagia());

         */

        //pesquisaMonstro();

    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToTelaInicio(ActionEvent event){
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

    // This method will return an ObservableList of People objects
    public ObservableList<TempMonstro> getMonstro(){

        ObservableList<TempMonstro> monstro = FXCollections.observableArrayList();
        monstro.add(new TempMonstro("The Demogorgon"));
        monstro.add(new TempMonstro("Aarakocra"));
        monstro.add(new TempMonstro("Abjurer"));
        monstro.add(new TempMonstro("Aboleth"));
        monstro.add(new TempMonstro("Acererak"));
        monstro.add(new TempMonstro("Adult Green Dragon"));

        return monstro;
    }

//    @FXML
//    public void clickItem(MouseEvent event)
//    {
//        if (event.getClickCount() == 2) //Checking double click
//        {
//            System.out.println(TableView.getSelectionModel().getSelectedItem().getBeer());
//            System.out.println(TableView.getSelectionModel().getSelectedItem().getBrewery());
//            System.out.println(TableView.getSelectionModel().getSelectedItem().getCountry());
//        }
//    }

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

    /*
    public void UpdateTable(){
        //atualizar tabela na pesquisa
    }

     */

    //CONNECTION DATABASE
    /*
    public void buildData(){
        data = FXCollections.observableArrayList();
        try{
            connection = DBConnect.connect();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * from Monstro";
            resultSet = connection.createStatement().executeQuery(SQL);

            for(int i=0 ; i < resultSet.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn column = new TableColumn(resultSet.getMetaData().getColumnName(i+1));
                column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(column);
                System.out.println("Column ["+i+"] ");
            }

            while(resultSet.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<= resultSet.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(resultSet.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

                //FINALLY ADDED TO TableView
                tableView.setItems(data);
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Erro ao carregar os dados!");
            }
    }

     */

     /*
    @FXML
    void pesquisaMonstro () {

        dataList.addAll(modelMonstro01, modelMonstro02, modelMonstro03, modelMonstro04, modelMonstro05, modelMonstro06); // database
        tableView.setItems(dataList);

        //wrap the ObervableList in a FilteredList (initially display all data)
        FilteredList<TempMonstro> filteredData = new FilteredList<>(dataList, b -> true);
        //set the filter Predicate whenever the filter changes
        barraPesquisa.textProperty().addListener((observable, oldvalue, newValue) -> filteredData.setPredicate(monstro -> {
            //if filter text is empty, display all persons
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            //compare first name and last name of every person with filter text
            String lowerCaseFilter = newValue.toLowerCase();

            if (monstro.getNomeMonstro().toLowerCase().contains(lowerCaseFilter)) {
                return true; //filter matches
            } else {
                return false;
            }
        }));
        //wrap the FilteredList in a SortedList
        SortedList<TempMonstro> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedData);
    }
    */
}
