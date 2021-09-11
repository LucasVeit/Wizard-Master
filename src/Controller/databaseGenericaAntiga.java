package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import Model.DAO.MagiaDAO;
import Model.Magia;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sample.main;

public class databaseGenericaAntiga extends TelaResultadoController implements Initializable, controlledScreen {

    //Screen controller
    private screensController myController;

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
    @FXML private ComboBox<String> comboBox01;
    @FXML private ComboBox<String> comboBox02;
    private String pesquisa, categoria, atributo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        InsertChoiceBox();
        tableView.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Magia magia = tableView.getSelectionModel().getSelectedItem();
                if (mouseEvent.getClickCount() == 2) //Checking double click
                {
                    goToTelaResultado();

                    staticLabelTitle.setText(magia.getNomeMagia());

                    Text subtitle01 = new Text(tableColumn4.getText() + "\n");
                    subtitle01.setFont(Font.font("Sylfaen", 30));
                    subtitle01.setFill(Color.rgb(63, 4, 4));

                    Text description01 = new Text(magia.getDescricao());
                    description01.setFont(Font.font("Sylfaen", 24));
                    description01.setFill(Color.rgb(63, 4, 4));

                    Text subtitle02 = new Text("\n" + tableColumn2.getText() + ": ");
                    subtitle02.setFont(Font.font("Sylfaen", 30));
                    subtitle02.setFill(Color.rgb(63, 4, 4));

                    Text description02 = new Text(magia.getTipo());
                    description02.setFont(Font.font("Sylfaen", 24));
                    description02.setFill(Color.rgb(63, 4, 4));

                    Text subtitle03 = new Text("\n" + tableColumn3.getText() + ": ");
                    subtitle03.setFont(Font.font("Sylfaen", 30));
                    subtitle03.setFill(Color.rgb(63, 4, 4));

                    Text description03 = new Text(String.valueOf(magia.getNivel()));
                    description03.setFont(Font.font("Sylfaen", 24));
                    description03.setFill(Color.rgb(63, 4, 4));

                    Text subtitle04 = new Text("\n" + tableColumn5.getText() + ": ");
                    subtitle04.setFont(Font.font("Sylfaen", 30));
                    subtitle04.setFill(Color.rgb(63, 4, 4));

                    Text description04 = new Text(magia.getDuracao());
                    description04.setFont(Font.font("Sylfaen", 24));
                    description04.setFill(Color.rgb(63, 4, 4));

                    Text subtitle05 = new Text("\n" + tableColumn6.getText() + ": ");
                    subtitle05.setFont(Font.font("Sylfaen", 30));
                    subtitle05.setFill(Color.rgb(63, 4, 4));

                    Text description05 = new Text(magia.getComponentes());
                    description05.setFont(Font.font("Sylfaen", 24));
                    description05.setFill(Color.rgb(63, 4, 4));

                    Text subtitle06 = new Text("\n" + tableColumn7.getText() + ": ");
                    subtitle06.setFont(Font.font("Sylfaen", 30));
                    subtitle06.setFill(Color.rgb(63, 4, 4));

                    Text description06 = new Text(magia.getAlcance());
                    description06.setFont(Font.font("Sylfaen", 24));
                    description06.setFill(Color.rgb(63, 4, 4));

                    Text subtitle07 = new Text("\n" + tableColumn8.getText() + ": ");
                    subtitle07.setFont(Font.font("Sylfaen", 30));
                    subtitle07.setFill(Color.rgb(63, 4, 4));

                    Text description07 = new Text(magia.getTempoConjuracao());
                    description07.setFont(Font.font("Sylfaen", 24));
                    description07.setFill(Color.rgb(63, 4, 4));


                    ObservableList list = staticTextFlowPane.getChildren();
                    list.clear();
                    list.addAll(subtitle01, description01, subtitle02, description02, subtitle03, description03, subtitle04, description04, subtitle05, description05, subtitle06, description06, subtitle07, description07);

                    javafx.scene.image.ImageView view = new ImageView("View\\Resources\\imageMagic.jpg");
                    staticImageView.setImage(view.getImage());
                }
            }
        });
    }
    /*
        Tipo generico pra tabela
        criação das colunas conforme o tanto de atributos dessa tabela
        instanciação dessas colunas como o nome certo das tabelas
        instaciação dessas colunas com o nome dos atributos no model
        adicionar essas colunas na tabela
     */

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
        categoria = comboBox01.getValue();
        atributo = comboBox02.getValue();

        if(categoria == "Magia"){

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

            ObservableList<Magia> magics = FXCollections.observableArrayList(MagiaDAO.Search(pesquisa, categoria, atributo));
            tableView.setItems(magics);
        }
    }

    @FXML
    private void comboAction(ActionEvent event) {
        comboBox02.getItems().clear();

        if(comboBox01.getValue() == "Magia"){
            comboBox02.getItems().addAll("nomeMagia", "nivel", "tipo", "descricao"); //SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'some_table';

        }else if(comboBox01.getValue().equals("Item")){

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
}
