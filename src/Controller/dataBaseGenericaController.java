package Controller;

import Model.DAO.ItemDAO;
import Model.DAO.MagiaDAO;
import Model.DAO.MonstroDAO;
import Model.Item.ArmaduraEscudo;
import Model.Item.Item;
import Model.Item.ItemMagico;
import javafx.beans.property.*;
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

public class dataBaseGenericaController extends TelaResultadoController implements Initializable, controlledScreen {

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
                    else if(categoria.equals("Item")){
                        itemInfo();
                    }else if(categoria.equals("Monstro")){
                        monstroInfo();
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
    private void Search(ActionEvent event) {
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
        if(categoria.equals("Monstro")){
            try {
                dataColumn = MonstroDAO.getAllColumnData();

                for (int i = 0; i < dataColumn.getNumColumns(); ++i) {
                    TableColumn<ArrayList<Object>, Object> column = new TableColumn<>(dataColumn.getColumnName(i));
                    int columnIndex = i;
                    column.setCellValueFactory(arrayListObjectCellDataFeatures ->
                            new SimpleObjectProperty<>(arrayListObjectCellDataFeatures.getValue().get(columnIndex)));
                    column.setPrefWidth(100);
                    tableView.getColumns().add(column);
                }
                dataRow = MonstroDAO.getAllRowData(pesquisa, categoria, atributo);
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

        }else if(comboBox01.getValue().equals("Monstro")){
            comboBox02.getItems().addAll("NomeMonstro", "descricao", "classeArmadura", "pontosVidaBase", "tendencia", "nivel", "pontosExperiencia", "formaCorporal", "tamanho", "deslocamentoBase");

        }else if(comboBox01.getValue().equals("Pericia")){
            comboBox02.getItems().addAll("nomePericia", "descricao", "habilidadeImpacta");
        }else if(comboBox01.getValue().equals("Talento")){
            comboBox02.getItems().addAll("nomeTalento", "preRequisito", "descricao");
        }else if(comboBox01.getValue().equals("Raca")){

        }else if(comboBox01.getValue().equals("Classe")){

        }else {
            comboBox01.getValue();
        }

    }

    public void InsertChoiceBox(){
        comboBox01.getItems().addAll("Magia", "Item", "Monstro", "Pericia", "Talento", "Antecedente", "Deus");
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

        /*

        SimpleStringProperty nomeItem = new SimpleStringProperty(String.valueOf(object.get(0)));
        SimpleStringProperty descricao = new SimpleStringProperty(String.valueOf(object.get(1)));
        SimpleStringProperty categoria = new SimpleStringProperty(String.valueOf(object.get(2)));
        SimpleIntegerProperty custo = new SimpleIntegerProperty(Integer.valueOf(object.get(3)));
        SimpleStringProperty moeda = new SimpleStringProperty(String.valueOf(object.get(4)));
        SimpleFloatProperty peso = new SimpleFloatProperty(Float.valueOf(object.get(5)));

        Item item = new Item(nomeItem, descricao, categoria, custo, moeda, peso);
        ItemMagico itemMagico;
        ArmaduraEscudo armaduraEscudo;

        if(item.getCategoria().equals("Item Mágico")){
            itemMagico = ItemDAO.getItemMagico(item);

            Text subtitle01 = new Text( "Tipo" + "\n");
            subtitle01.setFont(Font.font("Sylfaen", 30));
            subtitle01.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle01);

            Text text01 = new Text(itemMagico.getTipo() + "\n");
            text01.setFont(Font.font("Sylfaen", 24));
            text01.setFill(Color.rgb(63, 4, 4));
            list.add(text01);

            Text subtitle02 = new Text( "Raridade" + "\n");
            subtitle02.setFont(Font.font("Sylfaen", 30));
            subtitle02.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle02);

            Text text02 = new Text(itemMagico.getRaridade() + "\n");
            text02.setFont(Font.font("Sylfaen", 24));
            text02.setFill(Color.rgb(63, 4, 4));
            list.add(text02);

            Text subtitle03 = new Text( "Requisito" + "\n");
            subtitle03.setFont(Font.font("Sylfaen", 30));
            subtitle03.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle03);

            Text text04 = new Text(itemMagico.getRequisito() + "\n");
            text04.setFont(Font.font("Sylfaen", 24));
            text04.setFill(Color.rgb(63, 4, 4));
            list.add(text04);
        }

        if(item.getCategoria().equals("ArmaduraEscudo")){
            armaduraEscudo = ItemDAO.getArmaduraEscudo(item);

            Text subtitle01 = new Text( "Classe Armadura" + "\n");
            subtitle01.setFont(Font.font("Sylfaen", 30));
            subtitle01.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle01);

            Text text01 = new Text(armaduraEscudo.getClasseArmadura() + "\n");
            text01.setFont(Font.font("Sylfaen", 24));
            text01.setFill(Color.rgb(63, 4, 4));
            list.add(text01);

            Text subtitle02 = new Text( "Possui modificar de destreza?" + "\n");
            subtitle02.setFont(Font.font("Sylfaen", 30));
            subtitle02.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle02);

            if(armaduraEscudo.isModificadorDes()){
                Text text02 = new Text("Sim"+ "\n");
                text02.setFont(Font.font("Sylfaen", 24));
                text02.setFill(Color.rgb(63, 4, 4));
                list.add(text02);
            }else{
                Text text02 = new Text("Não"+ "\n");
                text02.setFont(Font.font("Sylfaen", 24));
                text02.setFill(Color.rgb(63, 4, 4));
                list.add(text02);
            }

            Text subtitle03 = new Text( "Modificador máximo de destreza" + "\n");
            subtitle03.setFont(Font.font("Sylfaen", 30));
            subtitle03.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle03);

            Text text03 = new Text(armaduraEscudo.getMaxModificador() + "\n");
            text03.setFont(Font.font("Sylfaen", 24));
            text03.setFill(Color.rgb(63, 4, 4));
            list.add(text03);

            Text subtitle04 = new Text( "Força necessária" + "\n");
            subtitle04.setFont(Font.font("Sylfaen", 30));
            subtitle04.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle03);

            Text text04 = new Text(armaduraEscudo.getForcaNecessaria() + "\n");
            text04.setFont(Font.font("Sylfaen", 24));
            text04.setFill(Color.rgb(63, 4, 4));
            list.add(text03);

            Text subtitle05 = new Text( "Tipo" + "\n");
            subtitle05.setFont(Font.font("Sylfaen", 30));
            subtitle05.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle03);

            Text text05 = new Text(armaduraEscudo.getTipo() + "\n");
            text05.setFont(Font.font("Sylfaen", 24));
            text05.setFill(Color.rgb(63, 4, 4));
            list.add(text03);

            Text subtitle06 = new Text( "Possui desvantagem para furtividade?" + "\n");
            subtitle06.setFont(Font.font("Sylfaen", 30));
            subtitle06.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle03);

            if(armaduraEscudo.isFurtividade()){
                Text text06 = new Text("Sim" + "\n");
                text06.setFont(Font.font("Sylfaen", 24));
                text06.setFill(Color.rgb(63, 4, 4));
                list.add(text03);
            }else{
                Text text06 = new Text("Não" + "\n");
                text06.setFont(Font.font("Sylfaen", 24));
                text06.setFill(Color.rgb(63, 4, 4));
                list.add(text03);
            }

            Text subtitle07 = new Text( "Tempo para equipar" + "\n");
            subtitle07.setFont(Font.font("Sylfaen", 30));
            subtitle07.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle03);

            Text text07 = new Text(armaduraEscudo.getPeriodoEquipar() + " " + armaduraEscudo.getMedidaPeriodo() + "\n");
            text07.setFont(Font.font("Sylfaen", 24));
            text07.setFill(Color.rgb(63, 4, 4));
            list.add(text03);

            Text subtitle08 = new Text( "Tempo para desequipar" + "\n");
            subtitle08.setFont(Font.font("Sylfaen", 30));
            subtitle08.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle03);

            Text text08 = new Text(armaduraEscudo.getPeriodoDesequipar() + " " + armaduraEscudo.getMedidaPeriodo() + "\n");
            text08.setFont(Font.font("Sylfaen", 24));
            text08.setFill(Color.rgb(63, 4, 4));
            list.add(text03);

        }

         */

    }

    public void monstroInfo(){

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

    public void classeInfo(){
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

    public void deusInfo(){
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
