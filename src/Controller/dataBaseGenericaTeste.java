package Controller;

import Model.DAO.ItemDAO;
import Model.DAO.MagiaDAO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sample.main;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class dataBaseGenericaTeste extends TelaResultadoController implements Initializable, controlledScreen {

    //Screen controller
    private screensController myController;

    //configure the table
    @FXML private TableView<ArrayList<Object>> tableView;
    @FXML private TextField barraPesquisa;
    @FXML private ComboBox<String> comboBox01;
    @FXML private ComboBox<String> comboBox02;

    private dataResultTableColumn dataColumn;
    private dataResultTableRow dataRow;
    private String pesquisa, categoria, atributo;
    ArrayList<Object> object;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InsertChoiceBox();
        tableView.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                object = tableView.getSelectionModel().getSelectedItem();
                if (mouseEvent.getClickCount() == 2){ //Checking double click
                    goToTelaResultado();

                    if(categoria.equals("Magia")){
                        magicInfo();
                    }
                    if(categoria.equals("Item")){
                        itemInfo();
                    }
                }
        }});
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
    private void Pesquisar(ActionEvent event) {
        tableView.getColumns().clear();
        pesquisa = barraPesquisa.getText();
        categoria = comboBox01.getValue();
        atributo = comboBox02.getValue();

        if (categoria.equals("Magia")) {
            try {
                dataColumn = MagiaDAO.getAllColumnData();

                for (int i = 0; i < dataColumn.getNumColumns(); ++i) {
                    TableColumn<ArrayList<Object>, Object> column = new TableColumn<>(dataColumn.getColumnName(i));
                    int columnIndex = i;
                    column.setCellValueFactory(arrayListObjectCellDataFeatures ->
                            new SimpleObjectProperty<>(arrayListObjectCellDataFeatures.getValue().get(columnIndex)));
                    column.setPrefWidth(100);
                    tableView.getColumns().add(column);
                }

                dataRow = MagiaDAO.getAllRowData(pesquisa, categoria, atributo);
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }
        if(categoria.equals("Item")){
            try {
                dataColumn = ItemDAO.getAllColumnData();

                for (int i = 0; i < dataColumn.getNumColumns(); ++i) {
                    TableColumn<ArrayList<Object>, Object> column = new TableColumn<>(dataColumn.getColumnName(i));
                    int columnIndex = i;
                    column.setCellValueFactory(arrayListObjectCellDataFeatures ->
                            new SimpleObjectProperty<>(arrayListObjectCellDataFeatures.getValue().get(columnIndex)));
                    column.setPrefWidth(100);
                    tableView.getColumns().add(column);
                }
                dataRow = ItemDAO.getAllRowData(pesquisa, categoria, atributo);
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }

    }

    @FXML
    private void comboAction(ActionEvent event) {
        comboBox02.getItems().clear();

        if(comboBox01.getValue() == "Magia"){
            comboBox02.getItems().addAll("nomeMagia", "nivel", "tipo", "descricao"); //SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'some_table';

        }else if(comboBox01.getValue().equals("Item")){
            comboBox02.getItems().addAll("nomeItem");

        }else if(comboBox01.getValue().equals("Pericia")){

        }else if(comboBox01.getValue().equals("Talento")){

        }else if(comboBox01.getValue().equals("Antecedente")){

        }else {
            comboBox01.getValue();
        }

    }
    public void InsertChoiceBox(){
        comboBox01.getItems().addAll("Magia", "Item", "Pericia", "Talento", "Antecedente", "Deus");
        // SELECT table_name FROM information_schema.tables WHERE table_type='BASE TABLE' AND table_schema='public';
    }


    public void magicInfo(){

        staticLabelTitle.setText(String.valueOf(object.get(0)));
        ObservableList list = staticTextFlowPane.getChildren();
        list.clear();

        for(int i = 1; i < object.size(); ++i){

            Text subtitle = new Text( tableView.getColumns().get(i).getText()+ "\n");
            subtitle.setFont(Font.font("Sylfaen", 30));
            subtitle.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle);

            Text text = new Text(String.valueOf(object.get(i)) + "\n");
            text.setFont(Font.font("Sylfaen", 24));
            text.setFill(Color.rgb(63, 4, 4));
            list.add(text);
        }

        javafx.scene.image.ImageView view = new ImageView("View\\Resources\\imageMagic.jpg");
        staticImageView.setImage(view.getImage());
    }

    public void itemInfo(){

        staticLabelTitle.setText(String.valueOf(object.get(0)));
        ObservableList list = staticTextFlowPane.getChildren();
        list.clear();

        for(int i = 1; i < object.size(); ++i){

            Text subtitle = new Text( tableView.getColumns().get(i).getText()+ "\n");
            subtitle.setFont(Font.font("Sylfaen", 30));
            subtitle.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle);

            Text text = new Text(String.valueOf(object.get(i)) + "\n");
            text.setFont(Font.font("Sylfaen", 24));
            text.setFill(Color.rgb(63, 4, 4));
            list.add(text);
        }

        javafx.scene.image.ImageView view = new ImageView("View\\Resources\\staff.jpg");
        staticImageView.setImage(view.getImage());

    }

}
