package Controller;

import Model.BonusTalento;
import Model.DAO.*;
import Model.Item.*;
import Model.Monstro.CaracteristicaMonstro;
import Model.Raca;
import Model.Regra;
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

import javax.sound.midi.Soundbank;
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

                    if(categoria.equals("Classe")){
                        classeInfo();
                    }
                    else if(categoria.equals("Deus")){
                        deusInfo();
                    }
                    else if(categoria.equals("Item")){
                        itemInfo();
                    }
                    else if(categoria.equals("Magia")){
                        genericInfo("View\\Resources\\magic.png");
                    }
                    else if(categoria.equals("Monstro")){
                        monstroInfo();
                    }
                    else if(categoria.equals("Pericia")){
                        genericInfo("View\\Resources\\pericia.png");
                    }
                    else if(categoria.equals("Plano")){
                        planoInfo();
                    }
                    else if(categoria.equals("SubRaca")){
                        subRacaInfo();
                    }else if(categoria.equals("Talento")){
                        talentoInfo();
                    }else{
                        System.out.println("Não selecionado");
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

        if(categoria.equals("Classe")){
            try {
                dataColumn = ClasseDAO.getAllColumnData();

                for (int i = 0; i < dataColumn.getNumColumns(); ++i) {
                    TableColumn<ArrayList<Object>, Object> column = new TableColumn<>(dataColumn.getColumnName(i));
                    int columnIndex = i;
                    column.setCellValueFactory(arrayListObjectCellDataFeatures ->
                            new SimpleObjectProperty<>(arrayListObjectCellDataFeatures.getValue().get(columnIndex)));
                    column.setPrefWidth(100);
                    tableView.getColumns().add(column);
                }
                if(atributo == "nomeClasse" || atributo == "descricao" || atributo == "habilidadePrimaria" || atributo == "habilidadeSecundaria" || atributo == "testeResistenciaPrimario" || atributo == "testeResistenciaSecundario" || atributo == "modificadorVida")
                    dataRow = ClasseDAO.getAllRowData(pesquisa, categoria, atributo, "String");
                else
                    dataRow = ClasseDAO.getAllRowData(pesquisa, categoria, atributo, "Number");
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }else if(categoria.equals("Deus")){
            try {
                dataColumn = DeusDAO.getAllColumnData();

                for (int i = 1; i < dataColumn.getNumColumns(); ++i) {
                    TableColumn<ArrayList<Object>, Object> column = new TableColumn<>(dataColumn.getColumnName(i));
                    int columnIndex = i;
                    column.setCellValueFactory(arrayListObjectCellDataFeatures ->
                            new SimpleObjectProperty<>(arrayListObjectCellDataFeatures.getValue().get(columnIndex)));
                    column.setPrefWidth(100);
                    tableView.getColumns().add(column);
                }
                if(atributo == "nomeDeus" || atributo == "mitologia" || atributo == "dominio" || atributo == "tendencia" || atributo == "simbolo" || atributo == "descricao")
                    dataRow = DeusDAO.getAllRowData(pesquisa, categoria, atributo, "String");
                else
                    dataRow = DeusDAO.getAllRowData(pesquisa, categoria, atributo, "Number");
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }else if(categoria.equals("Item")){
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
                if(atributo == "nomeItem" || atributo == "descricao" || atributo == "categoria" || atributo == "moeda")
                    dataRow = ItemDAO.getAllRowData(pesquisa, categoria, atributo, "String");
                else
                    dataRow = ItemDAO.getAllRowData(pesquisa, categoria, atributo, "Number");
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }else if(categoria.equals("Magia")){
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
                if(atributo == "nomeMagia" || atributo == "tipo" || atributo == "descricao" || atributo == "duracao" || atributo == "componentes" || atributo == "alcance" || atributo == "tempoConjuracao")
                    dataRow = MagiaDAO.getAllRowData(pesquisa, categoria, atributo, "String");
                else
                    dataRow = MagiaDAO.getAllRowData(pesquisa, categoria, atributo, "Number");
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }else if(categoria.equals("Monstro")){
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
                if(atributo == "nomeMonstro" || atributo == "descricao" || atributo == "tendencia" || atributo == "formaCorporal" || atributo == "tamanho")
                    dataRow = MonstroDAO.getAllRowData(pesquisa, categoria, atributo, "String");
                else
                    dataRow = MonstroDAO.getAllRowData(pesquisa, categoria, atributo, "Number");
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }else if(categoria.equals("Pericia")){
            try {
                dataColumn = PericiaDAO.getAllColumnData();

                for (int i = 0; i < dataColumn.getNumColumns(); ++i) {
                    TableColumn<ArrayList<Object>, Object> column = new TableColumn<>(dataColumn.getColumnName(i));
                    int columnIndex = i;
                    column.setCellValueFactory(arrayListObjectCellDataFeatures ->
                            new SimpleObjectProperty<>(arrayListObjectCellDataFeatures.getValue().get(columnIndex)));
                    column.setPrefWidth(100);
                    tableView.getColumns().add(column);
                }
                dataRow = PericiaDAO.getAllRowData(pesquisa, categoria, atributo, "String");
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }else if(categoria.equals("Plano")){
            try {
                dataColumn = PlanoDAO.getAllColumnData();

                for (int i = 0; i < dataColumn.getNumColumns(); ++i) {
                    TableColumn<ArrayList<Object>, Object> column = new TableColumn<>(dataColumn.getColumnName(i));
                    int columnIndex = i;
                    column.setCellValueFactory(arrayListObjectCellDataFeatures ->
                            new SimpleObjectProperty<>(arrayListObjectCellDataFeatures.getValue().get(columnIndex)));
                    column.setPrefWidth(100);
                    tableView.getColumns().add(column);
                }
                dataRow = PlanoDAO.getAllRowData(pesquisa, categoria, atributo, "String");
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }else if(categoria.equals("SubRaca")){
            try {
                dataColumn = SubRacaDAO.getAllColumnData();

                for (int i = 0; i < dataColumn.getNumColumns(); ++i) {
                    TableColumn<ArrayList<Object>, Object> column = new TableColumn<>(dataColumn.getColumnName(i));
                    int columnIndex = i;
                    column.setCellValueFactory(arrayListObjectCellDataFeatures ->
                            new SimpleObjectProperty<>(arrayListObjectCellDataFeatures.getValue().get(columnIndex)));
                    column.setPrefWidth(100);
                    tableView.getColumns().add(column);
                }
                if(atributo == "nomeSubRaca" || atributo == "nomeRaca" || atributo == "descricao" || atributo == "tamanho" || atributo == "tendencia")
                    dataRow = SubRacaDAO.getAllRowData(pesquisa, categoria, atributo, "String");
                else
                    dataRow = SubRacaDAO.getAllRowData(pesquisa, categoria, atributo, "Number");
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }else if(categoria.equals("Talento")){
            try {
                dataColumn = TalentoDAO.getAllColumnData();

                for (int i = 0; i < dataColumn.getNumColumns(); ++i) {
                    TableColumn<ArrayList<Object>, Object> column = new TableColumn<>(dataColumn.getColumnName(i));
                    int columnIndex = i;
                    column.setCellValueFactory(arrayListObjectCellDataFeatures ->
                            new SimpleObjectProperty<>(arrayListObjectCellDataFeatures.getValue().get(columnIndex)));
                    column.setPrefWidth(100);
                    tableView.getColumns().add(column);
                }
                dataRow = TalentoDAO.getAllRowData(pesquisa, categoria, atributo, "String");
                tableView.getItems().setAll(dataRow.getData());

            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        }
    }

    @FXML
    private void comboAction(ActionEvent event) {
        comboBox02.getItems().clear();

        if(comboBox01.getValue() == "Classe")
            comboBox02.getItems().addAll("nomeClasse", "descricao", "habilidadePrimaria", "habilidadeSecundaria", "habilidadeSecundariaOpcional", "testeResistenciaPrimario", "testeResistenciaSecundario", "dadoVida", "modificadorVida", "progressaoPadraoVida"); //SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'some_table';
        else if(comboBox01.getValue() == "Deus")
            comboBox02.getItems().addAll("nomeDeus", "mitologia", "dominio", "tendencia", "simbolo", "descricao"); //SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'some_table';
        else if(comboBox01.getValue().equals("Item"))
            comboBox02.getItems().addAll("nomeItem", "descricao", "categoria", "custo", "moeda", "peso");
        else if(comboBox01.getValue() == "Magia")
            comboBox02.getItems().addAll("nomeMagia", "tipo", "nivel", "descricao", "duracao", "componentes", "alcance", "tempoConjuracao"); //SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'some_table';
        else if(comboBox01.getValue().equals("Monstro"))
            comboBox02.getItems().addAll("nomeMonstro", "descricao", "classeArmadura", "pontosVidaBase", "tendencia", "nivel", "pontosExperiencia", "formaCorporal", "tamanho", "deslocamentoBase");
        else if(comboBox01.getValue().equals("Pericia"))
            comboBox02.getItems().addAll("nomePericia", "descricao", "habilidadeImpacta");
        else if(comboBox01.getValue().equals("Plano"))
            comboBox02.getItems().addAll("nomePlano", "descricao", "corCortina", "corPoco");
        else if(comboBox01.getValue().equals("SubRaca"))
            comboBox02.getItems().addAll("nomeSubRaca", "nomeRaca", "descricao", "deslocamento", "idadeAdulto", "idadeExpectativaVida", "tamanho", "tendencia", "forca", "destreza", "constituicao", "sabedoria", "inteligencia", "carisma");
        else if(comboBox01.getValue().equals("Talento"))
            comboBox02.getItems().addAll("nomeTalento", "preRequisito", "descricao");
        else
            comboBox01.getValue();

    }

    public void InsertChoiceBox(){
        comboBox01.getItems().addAll("Classe", "Deus", "Item", "Magia", "Monstro", "Pericia", "Plano", "SubRaca", "Talento");
        // SELECT table_name FROM information_schema.tables WHERE table_type='BASE TABLE' AND table_schema='public';
    }

    public void genericInfo(String imagem){
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

        javafx.scene.image.ImageView view = new ImageView(imagem);
        staticImageView.setImage(view.getImage());
    }

    public void deusInfo(){
        staticLabelTitle.setText(String.valueOf(object.get(1)));
        ObservableList list = staticTextFlowPane.getChildren();
        list.clear();

        for(int i = 2; i < object.size() - 1; ++i){
            Text subtitle = new Text( tableView.getColumns().get(i).getText()+ "\n");
            subtitle.setFont(Font.font("Sylfaen", 30));
            subtitle.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle);

            Text text = new Text(String.valueOf(object.get(i)) + "\n");
            text.setFont(Font.font("Sylfaen", 24));
            text.setFill(Color.rgb(63, 4, 4));
            list.add(text);
        }

        javafx.scene.image.ImageView view = new ImageView("View\\Resources\\god.png");
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

        javafx.scene.image.ImageView view = new ImageView("View\\Resources\\class.png");
        staticImageView.setImage(view.getImage());
    }

    public void itemInfo(){
        staticLabelTitle.setText(String.valueOf(object.get(0)));
        ObservableList list = staticTextFlowPane.getChildren();
        list.clear();

        for(int i = 1; i < object.size(); ++i){
            Text subtitle = new Text( tableView.getColumns().get(i).getText()+ ": ");
            subtitle.setFont(Font.font("Sylfaen", 30));
            subtitle.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle);

            Text text = new Text(String.valueOf(object.get(i)) + "\n");
            text.setFont(Font.font("Sylfaen", 24));
            text.setFill(Color.rgb(63, 4, 4));
            list.add(text);
        }


        javafx.scene.image.ImageView view = new ImageView("View\\Resources\\item.png");
        staticImageView.setImage(view.getImage());

        if(String.valueOf(object.get(2)).equals("Arma")){
            Arma arma = ItemDAO.getArma(String.valueOf(object.get(0)));

            Text subtitle01 = new Text( "Tipo: ");
            subtitle01.setFont(Font.font("Sylfaen", 30));
            subtitle01.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle01);

            Text text01 = new Text(arma.getTipo() + "\n");
            text01.setFont(Font.font("Sylfaen", 24));
            text01.setFill(Color.rgb(63, 4, 4));
            list.add(text01);

            Text subtitle02 = new Text( "Dano: ");
            subtitle02.setFont(Font.font("Sylfaen", 30));
            subtitle02.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle02);

            Text text02 = new Text(arma.getDano() + "\n");
            text02.setFont(Font.font("Sylfaen", 24));
            text02.setFill(Color.rgb(63, 4, 4));
            list.add(text02);

            if(arma.getPropriedadeArma().size() > 0) {
                for (int i = 0; i < arma.getPropriedadeArma().size(); i++) {
                    Text subtitle03 = new Text(arma.getPropriedadeArma().get(i).getNome() + ": ");
                    subtitle03.setFont(Font.font("Sylfaen", 30));
                    subtitle03.setFill(Color.rgb(40, 2, 2));
                    list.add(subtitle03);

                    Text text03 = new Text(arma.getPropriedadeArma().get(i).getDescricaoPropriedade() + "\n");
                    text03.setFont(Font.font("Sylfaen", 24));
                    text03.setFill(Color.rgb(63, 4, 4));
                    list.add(text03);

                    Text subtitle04 = new Text("Característica da propriedade: ");
                    subtitle04.setFont(Font.font("Sylfaen", 30));
                    subtitle04.setFill(Color.rgb(40, 2, 2));
                    list.add(subtitle04);

                    Text text04 = new Text(arma.getPropriedadeArma().get(i).getDescricaoCaracteristica() + "\n");
                    text04.setFont(Font.font("Sylfaen", 24));
                    text04.setFill(Color.rgb(63, 4, 4));
                    list.add(text04);
                }
            }
        }else if(String.valueOf(object.get(2)).equals("armaduraEscudo")){
            ArmaduraEscudo armaduraEscudo = ItemDAO.getArmaduraEscudo(String.valueOf(object.get(0)));

            Text subtitle01 = new Text( "Classe Armadura: ");
            subtitle01.setFont(Font.font("Sylfaen", 30));
            subtitle01.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle01);

            Text text01 = new Text(armaduraEscudo.getClasseArmadura() + "\n");
            text01.setFont(Font.font("Sylfaen", 24));
            text01.setFill(Color.rgb(63, 4, 4));
            list.add(text01);

            Text subtitle02 = new Text( "Possui modificar de destreza? ");
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

            Text subtitle03 = new Text( "Modificador máximo de destreza: ");
            subtitle03.setFont(Font.font("Sylfaen", 30));
            subtitle03.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle03);

            Text text03 = new Text(armaduraEscudo.getMaxModificador() + "\n");
            text03.setFont(Font.font("Sylfaen", 24));
            text03.setFill(Color.rgb(63, 4, 4));
            list.add(text03);

            Text subtitle04 = new Text( "Força necessária: ");
            subtitle04.setFont(Font.font("Sylfaen", 30));
            subtitle04.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle04);

            Text text04 = new Text(armaduraEscudo.getForcaNecessaria() + "\n");
            text04.setFont(Font.font("Sylfaen", 24));
            text04.setFill(Color.rgb(63, 4, 4));
            list.add(text04);

            Text subtitle05 = new Text( "Tipo: ");
            subtitle05.setFont(Font.font("Sylfaen", 30));
            subtitle05.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle05);

            Text text05 = new Text(armaduraEscudo.getTipo() + "\n");
            text05.setFont(Font.font("Sylfaen", 24));
            text05.setFill(Color.rgb(63, 4, 4));
            list.add(text05);

            Text subtitle06 = new Text( "Possui desvantagem para furtividade?" );
            subtitle06.setFont(Font.font("Sylfaen", 30));
            subtitle06.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle06);

            if(armaduraEscudo.isFurtividade()){
                Text text06 = new Text("Sim" + "\n");
                text06.setFont(Font.font("Sylfaen", 24));
                text06.setFill(Color.rgb(63, 4, 4));
                list.add(text06);
            }else{
                Text text06 = new Text("Não" + "\n");
                text06.setFont(Font.font("Sylfaen", 24));
                text06.setFill(Color.rgb(63, 4, 4));
                list.add(text06);
            }

            Text subtitle07 = new Text( "Tempo para equipar: ");
            subtitle07.setFont(Font.font("Sylfaen", 30));
            subtitle07.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle07);

            Text text07 = new Text(armaduraEscudo.getPeriodoEquipar() + " " + armaduraEscudo.getMedidaPeriodo() + "\n");
            text07.setFont(Font.font("Sylfaen", 24));
            text07.setFill(Color.rgb(63, 4, 4));
            list.add(text07);

            Text subtitle08 = new Text( "Tempo para desequipar: ");
            subtitle08.setFont(Font.font("Sylfaen", 30));
            subtitle08.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle08);

            Text text08 = new Text(armaduraEscudo.getPeriodoDesequipar() + " " + armaduraEscudo.getMedidaPeriodo() + "\n");
            text08.setFont(Font.font("Sylfaen", 24));
            text08.setFill(Color.rgb(63, 4, 4));
            list.add(text08);

        }else if(String.valueOf(object.get(2)).equals("Item Mágico")){
            ItemMagico itemMagico = ItemDAO.getItemMagico(String.valueOf(object.get(0)));

            Text subtitle01 = new Text( "Tipo: ");
            subtitle01.setFont(Font.font("Sylfaen", 30));
            subtitle01.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle01);

            Text text01 = new Text(itemMagico.getTipo() + "\n");
            text01.setFont(Font.font("Sylfaen", 24));
            text01.setFill(Color.rgb(63, 4, 4));
            list.add(text01);

            Text subtitle02 = new Text( "Raridade: ");
            subtitle02.setFont(Font.font("Sylfaen", 30));
            subtitle02.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle02);

            Text text02 = new Text(itemMagico.getRaridade() + "\n");
            text02.setFont(Font.font("Sylfaen", 24));
            text02.setFill(Color.rgb(63, 4, 4));
            list.add(text02);

            Text subtitle03 = new Text( "Requisito: ");
            subtitle03.setFont(Font.font("Sylfaen", 30));
            subtitle03.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle03);

            Text text03 = new Text(itemMagico.getRequisito() + "\n");
            text03.setFont(Font.font("Sylfaen", 24));
            text03.setFill(Color.rgb(63, 4, 4));
            list.add(text03);
        }else if(String.valueOf(object.get(2)).equals("Montaria")){
            Montaria montaria = ItemDAO.getMontaria(String.valueOf(object.get(0)));

            Text subtitle01 = new Text( "Deslocamento: ");
            subtitle01.setFont(Font.font("Sylfaen", 30));
            subtitle01.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle01);

            Text text01 = new Text(montaria.getDeslocamento() + "\n");
            text01.setFont(Font.font("Sylfaen", 24));
            text01.setFill(Color.rgb(63, 4, 4));
            list.add(text01);

            Text subtitle02 = new Text( "Capacidade de carga: ");
            subtitle02.setFont(Font.font("Sylfaen", 30));
            subtitle02.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle02);

            Text text02 = new Text(montaria.getCapacidadeCarga() + "\n");
            text02.setFont(Font.font("Sylfaen", 24));
            text02.setFill(Color.rgb(63, 4, 4));
            list.add(text02);
        }
    }

    public void monstroInfo(){
        staticLabelTitle.setText(String.valueOf(object.get(0)));
        ObservableList list = staticTextFlowPane.getChildren();
        list.clear();

        for(int i = 1; i < object.size(); ++i){
            if(i != 2) {
                Text subtitle = new Text(tableView.getColumns().get(i).getText() + ": ");
                subtitle.setFont(Font.font("Sylfaen", 30));
                subtitle.setFill(Color.rgb(40, 2, 2));
                list.add(subtitle);

                Text text = new Text(String.valueOf(object.get(i)) + "\n");
                text.setFont(Font.font("Sylfaen", 24));
                text.setFill(Color.rgb(63, 4, 4));
                list.add(text);
            }
        }

        Text Carisma = new Text( "\nCarisma: ");
        Carisma.setFont(Font.font("Sylfaen", 30));
        Carisma.setFill(Color.rgb(40, 2, 2));
        list.add(Carisma);

        Text Carisma1 = new Text( String.valueOf(MonstroDAO.getHabilidade("Carisma", String.valueOf(object.get(0)))) + "\n");
        Carisma1.setFont(Font.font("Sylfaen", 24));
        Carisma1.setFill(Color.rgb(63, 4, 4));
        list.add(Carisma1);

        Text Constituição = new Text( "Constituição: ");
        Constituição.setFont(Font.font("Sylfaen", 30));
        Constituição.setFill(Color.rgb(40, 2, 2));
        list.add(Constituição);

        Text Constituição1 = new Text( String.valueOf(MonstroDAO.getHabilidade("Constituição", String.valueOf(object.get(0)))) + "\n");
        Constituição1.setFont(Font.font("Sylfaen", 24));
        Constituição1.setFill(Color.rgb(63, 4, 4));
        list.add(Constituição1);

        Text Destreza = new Text( "Destreza: ");
        Destreza.setFont(Font.font("Sylfaen", 30));
        Destreza.setFill(Color.rgb(40, 2, 2));
        list.add(Destreza);

        Text Destreza1 = new Text( String.valueOf(MonstroDAO.getHabilidade("Destreza", String.valueOf(object.get(0)))) + "\n");
        Destreza1.setFont(Font.font("Sylfaen", 24));
        Destreza1.setFill(Color.rgb(63, 4, 4));
        list.add(Destreza1);

        Text Forca = new Text( "Força: ");
        Forca.setFont(Font.font("Sylfaen", 30));
        Forca.setFill(Color.rgb(40, 2, 2));
        list.add(Forca);

        Text Forca1 = new Text( String.valueOf(MonstroDAO.getHabilidade("Força", String.valueOf(object.get(0)))) + "\n");
        Forca1.setFont(Font.font("Sylfaen", 24));
        Forca1.setFill(Color.rgb(63, 4, 4));
        list.add(Forca1);

        Text Inteligencia = new Text( "Inteligência: ");
        Inteligencia.setFont(Font.font("Sylfaen", 30));
        Inteligencia.setFill(Color.rgb(40, 2, 2));
        list.add(Inteligencia);

        Text Inteligencia1 = new Text( String.valueOf(MonstroDAO.getHabilidade("Inteligência", String.valueOf(object.get(0)))) + "\n");
        Inteligencia1.setFont(Font.font("Sylfaen", 24));
        Inteligencia1.setFill(Color.rgb(63, 4, 4));
        list.add(Inteligencia1);

        Text Sabedoria = new Text( "Sabedoria: ");
        Sabedoria.setFont(Font.font("Sylfaen", 30));
        Sabedoria.setFill(Color.rgb(40, 2, 2));
        list.add(Sabedoria);

        Text Sabedoria1 = new Text( String.valueOf(MonstroDAO.getHabilidade("Sabedoria", String.valueOf(object.get(0)))) + "\n\n");
        Sabedoria1.setFont(Font.font("Sylfaen", 24));
        Sabedoria1.setFill(Color.rgb(63, 4, 4));
        list.add(Sabedoria1);

        ArrayList<CaracteristicaMonstro> caracteristicaMonstros = MonstroDAO.ListCaracteristica(String.valueOf(object.get(0)));

        for(int i = 0; i < caracteristicaMonstros.size(); ++i){
            Text subtitle = new Text( caracteristicaMonstros.get(i).getNome() + "\n");
            subtitle.setFont(Font.font("Sylfaen", 30));
            subtitle.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle);

            Text text = new Text( caracteristicaMonstros.get(i).getDescricao() + "\n");
            text.setFont(Font.font("Sylfaen", 24));
            text.setFill(Color.rgb(63, 4, 4));
            list.add(text);
        }

        javafx.scene.image.ImageView view = new ImageView(MonstroDAO.GetEnderecoFoto(String.valueOf(object.get(0))));
        staticImageView.setImage(view.getImage());
    }

    public void planoInfo(){
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


        ArrayList<Regra> regras = PlanoDAO.ListRegras(String.valueOf(object.get(0)));

        for(int i = 0; i < regras.size(); ++i){
            Text subtitle = new Text( regras.get(i).getNomeRegra() + "\n");
            subtitle.setFont(Font.font("Sylfaen", 30));
            subtitle.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle);

            Text text = new Text( regras.get(i).getDescricao() + "\n");
            text.setFont(Font.font("Sylfaen", 24));
            text.setFill(Color.rgb(63, 4, 4));
            list.add(text);
        }

        javafx.scene.image.ImageView view = new ImageView("View\\Resources\\plane.png");
        staticImageView.setImage(view.getImage());
    }

    public void subRacaInfo(){
        staticLabelTitle.setText(String.valueOf(object.get(0)));
        ObservableList list = staticTextFlowPane.getChildren();
        list.clear();
        Raca raca = SubRacaDAO.GetRaca(String.valueOf(object.get(1)));
        Text nome = new Text( raca.getNomeRaca() + "\n");
        nome.setFont(Font.font("Sylfaen", 30));
        nome.setFill(Color.rgb(40, 2, 2));
        list.add(nome);

        Text desc = new Text(raca.getDescricao() + "\n\n");
        desc.setFont(Font.font("Sylfaen", 24));
        desc.setFill(Color.rgb(63, 4, 4));
        list.add(desc);


        for(int i = 2; i < object.size(); ++i){
            Text subtitle = new Text( tableView.getColumns().get(i).getText()+ "\n");
            subtitle.setFont(Font.font("Sylfaen", 30));
            subtitle.setFill(Color.rgb(40, 2, 2));
            list.add(subtitle);

            Text text = new Text(String.valueOf(object.get(i)) + "\n");
            text.setFont(Font.font("Sylfaen", 24));
            text.setFill(Color.rgb(63, 4, 4));
            list.add(text);
        }

        javafx.scene.image.ImageView view = new ImageView(SubRacaDAO.GetEnderecoFoto(String.valueOf(object.get(1))));
        staticImageView.setImage(view.getImage());
    }

    public void talentoInfo(){
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

        Text jump = new Text("\n\n");
        list.add(jump);

        ArrayList<BonusTalento> bonusTalentos = TalentoDAO.ListBonus(String.valueOf(object.get(0)));
        for(int i = 0; i < bonusTalentos.size(); ++i){
            Text text = new Text( bonusTalentos.get(i).getDescricao() + "\n\n");
            text.setFont(Font.font("Sylfaen", 24));
            text.setFill(Color.rgb(63, 4, 4));
            list.add(text);
        }

        javafx.scene.image.ImageView view = new ImageView("View\\Resources\\talent.png");
        staticImageView.setImage(view.getImage());
    }

}
