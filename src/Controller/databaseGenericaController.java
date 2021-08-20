package Controller;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Model.ConnectPostgre;
import Model.TempMonstro;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.main;

public class databaseGenericaController implements Initializable, controlledScreen {

    //Screen controller
    private screensController myController;
    //private ConnectPostgre connection;
    //private ResultSet resultSet;
    //private PreparedStatement pst;

    //configure the table
    @FXML private TableView<TempMonstro> tableView;
    @FXML private TableColumn<TempMonstro, SimpleStringProperty> tableColumn;
   // private ObservableList<ObservableList> data;
   // @FXML private TextField barraPesquisa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set up te columns in the table
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("nomeMonstro"));

        //load data
        tableView.setItems(getMonstro());

        //pesquisaMonstro();
    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToTelaInicio(ActionEvent event){
        myController.setScreen(main.screen1ID);
    }

    @FXML
    private void goToTelaResultado(ActionEvent event){
        myController.setScreen(main.screen4ID);
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
