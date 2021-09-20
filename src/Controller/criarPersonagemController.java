package Controller;

import Model.DAO.*;
import Model.DAO.PersonagemDAO;
import Model.Personagem.*;
import javafx.beans.property.*;
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

public class criarPersonagemController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    private TableView<Personagem> tableView;
    @FXML
    private static TableView<Personagem> tableViewStatic;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column1;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column2;
    @FXML
    TableColumn<Personagem, SimpleFloatProperty> column3;
    @FXML
    TableColumn<Personagem, SimpleFloatProperty> column4;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column5;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column6;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column7;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column8;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column9;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column10;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column11;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column12;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column13;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column14;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column15;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column16;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column17;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column18;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column19;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column20;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column21;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column22;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column23;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column24;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column25;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column26;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column27;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column28;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column29;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column30;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column31;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column32;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column33;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column34;
    @FXML
    TableColumn<Personagem, SimpleStringProperty> column35;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column36;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column37;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column38;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column39;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column40;
    @FXML
    TableColumn<Personagem, SimpleIntegerProperty> column41;

    @FXML
    private TableView<PersonagemItem> tableViewA;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> columnA2;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> columnA3;
    @FXML
    TableColumn<PersonagemItem, SimpleBooleanProperty> columnA4;

    @FXML
    private TableView<String> tableViewB;
    @FXML
    TableColumn<String, String> columnB2;

    @FXML
    private TableView<String> tableViewC;
    @FXML
    TableColumn<String, String> columnC2;

    @FXML
    private TableView<String> tableViewD;
    @FXML
    TableColumn<String, String> columnD2;

    @FXML
    private ComboBox<String> comboBoxItem;
    @FXML
    private ComboBox<String> comboBoxEquipado;
    @FXML
    private TextField nomeItemItem;
    @FXML
    private TextField quantidadeItem;

    @FXML
    private ComboBox<String> comboBoxPericia;

    @FXML
    private ComboBox<String> comboBoxMagia;

    @FXML
    private ComboBox<String> comboBoxTalento;

    @FXML
    private Button adicionarItem;
    @FXML
    private Button atualizarItem;
    @FXML
    private Button removerItem;

    @FXML
    private Button adicionarPericia;
    @FXML
    private Button removerPericia;

    @FXML
    private Button adicionarMagia;
    @FXML
    private Button removerMagia;

    @FXML
    private Button adicionarTalento;
    @FXML
    private Button removerTalento;

    @FXML
    private Button adicionarPersonagem;
    @FXML
    private Button removerPersonagem;
    @FXML
    private Button atualizarPersonagem;
    @FXML
    private Button limparPersonagem;

    @FXML
    private ComboBox<String> comboBoxSubRaca;
    @FXML
    private ComboBox<String> comboBoxClasse;
    @FXML
    private ComboBox<String> comboBoxDeus;
    @FXML
    private ComboBox<String> comboBoxArquetipo;
    @FXML
    private ComboBox<String> comboBoxAntecedente;
    @FXML
    private ComboBox<String> comboBoxTendencia;

    @FXML
    private TextField nomePersonagem;
    @FXML
    private TextField classeArmaduraPersonagem;
    @FXML
    private TextField alturaPersonagem;
    @FXML
    private TextField corPelePersonagem;
    @FXML
    private TextField idadePersonagem;
    @FXML
    private TextField pesoPersonagem;
    @FXML
    private TextField corOlhosPersonagem;
    @FXML
    private TextField numeroInspiracaoPersonagem;
    @FXML
    private TextField percepcaoPassivaPersonagem;
    @FXML
    private TextField corCabeloPersonagem;
    @FXML
    private TextField nomeJogadorPersonagem;
    @FXML
    private TextField capacidadeCargaPersonagem;
    @FXML
    private TextField pontosExperienciaPersonagem;
    @FXML
    private TextField pontosVidaAtualPersonagem;
    @FXML
    private TextField pontosVidaTotalPersonagem;
    @FXML
    private TextField platinaPersonagem;
    @FXML
    private TextField ouroPersonagem;
    @FXML
    private TextField cobrePersonagem;
    @FXML
    private TextField prataPersonagem;
    @FXML
    private TextField electroPersonagem;
    @FXML
    private TextField deslocamentoPersonagem;
    @FXML
    private TextField carismaPersonagem;
    @FXML
    private TextField constituicaoPersonagem;
    @FXML
    private TextField forcaPersonagem;
    @FXML
    private TextField destrezaPersonagem;
    @FXML
    private TextField sabedoriaPersonagem;
    @FXML
    private TextField inteligenciaPersonagem;
    @FXML
    private TextArea caracteristicaAdicionalPersonagem;
    @FXML
    private TextArea vinculoPersonagem;
    @FXML
    private TextArea defeitoPersonagem;
    @FXML
    private TextArea idealPersonagem;
    @FXML
    private TextArea tracoPersonalidadePersonagem;
    private Personagem personagemAtual;
    private Personagem personagemAntigo;
    PersonagemItem item;
    String pericia;
    String magia;
    String talento;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewStatic = tableView;
        initTable();
        initComboBox();
        reloadPersonagem();
        classeArmaduraPersonagem.setText("0");

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                personagemAntigo = tableView.getSelectionModel().getSelectedItem();
                if (mouseEvent.getClickCount() == 2){

                    removerPersonagem.setDisable(false);
                    atualizarPersonagem.setDisable(false);
                    adicionarPersonagem.setDisable(true);

                    adicionarItem.setDisable(false);
                    atualizarItem.setDisable(false);
                    removerItem.setDisable(false);
                    adicionarPericia.setDisable(false);
                    removerPericia.setDisable(false);
                    adicionarMagia.setDisable(false);
                    removerMagia.setDisable(false);
                    adicionarTalento.setDisable(false);
                    removerTalento.setDisable(false);


                    nomePersonagem.setText(personagemAntigo.getNomePersonagem());
                    classeArmaduraPersonagem.setText(String.valueOf(personagemAntigo.getClasseArmadura()));
                    alturaPersonagem.setText(String.valueOf(personagemAntigo.getAltura()));
                    corPelePersonagem.setText(personagemAntigo.getCorPele());
                    idadePersonagem.setText(String.valueOf(personagemAntigo.getIdade()));
                    pesoPersonagem.setText(String.valueOf(personagemAntigo.getPeso()));
                    corOlhosPersonagem.setText(personagemAntigo.getCorOlhos());
                    numeroInspiracaoPersonagem.setText(String.valueOf(personagemAntigo.getNumeroInspiracao()));
                    percepcaoPassivaPersonagem.setText(String.valueOf(personagemAntigo.getPercepcaoPassiva()));
                    corCabeloPersonagem.setText(personagemAntigo.getCorCabelo());
                    nomeJogadorPersonagem.setText(personagemAntigo.getNomeJogador());
                    capacidadeCargaPersonagem.setText(String.valueOf(personagemAntigo.getCapacidadeCarga()));
                    pontosExperienciaPersonagem.setText(String.valueOf(personagemAntigo.getPontosExperiencia()));
                    pontosVidaAtualPersonagem.setText(String.valueOf(personagemAntigo.getPontosVidaAtual()));
                    pontosVidaTotalPersonagem.setText(String.valueOf(personagemAntigo.getPontosVidaTotal()));
                    platinaPersonagem.setText(String.valueOf(personagemAntigo.getPlatina()));
                    ouroPersonagem.setText(String.valueOf(personagemAntigo.getOuro()));
                    cobrePersonagem.setText(String.valueOf(personagemAntigo.getCobre()));
                    prataPersonagem.setText(String.valueOf(personagemAntigo.getPrata()));
                    electroPersonagem.setText(String.valueOf(personagemAntigo.getElectro()));
                    deslocamentoPersonagem.setText(String.valueOf(personagemAntigo.getDeslocamento()));
                    carismaPersonagem.setText(String.valueOf(personagemAntigo.getCarisma()));
                    constituicaoPersonagem.setText(String.valueOf(personagemAntigo.getConstituicao()));
                    forcaPersonagem.setText(String.valueOf(personagemAntigo.getForca()));
                    destrezaPersonagem.setText(String.valueOf(personagemAntigo.getDestreza()));
                    sabedoriaPersonagem.setText(String.valueOf(personagemAntigo.getSabedoria()));
                    inteligenciaPersonagem.setText(String.valueOf(personagemAntigo.getInteligencia()));
                    caracteristicaAdicionalPersonagem.setText(personagemAntigo.getCaracteristicaAdicional());
                    vinculoPersonagem.setText(personagemAntigo.getVinculo());
                    defeitoPersonagem.setText(personagemAntigo.getDefeito());
                    idealPersonagem.setText(personagemAntigo.getIdeal());
                    tracoPersonalidadePersonagem.setText(personagemAntigo.getTracoPersonalidade());

                    initComboBox();
                    comboBoxAntecedente.setValue(personagemAntigo.getNomeAntecedente());
                    comboBoxClasse.setValue(personagemAntigo.getPersonagemClasse());
                    comboBoxArquetipo.setValue(personagemAntigo.getArquetipo());
                    comboBoxDeus.setValue(DeusDAO.ListarDeus().get(personagemAntigo.getDeus() - 1));
                    comboBoxTendencia.setValue(personagemAntigo.getTendencia());
                    comboBoxSubRaca.setValue(personagemAntigo.getPersonagemSubRaca());

                    ObservableList<Personagem> personagens = FXCollections.observableArrayList(PersonagemDAO.Listar());

                    if(personagens.size() > 0){
                        tableView.setItems(personagens);
                    }

                    refreshItem();
                    refreshPericia();
                    refreshTalento();
                    refreshMagia();
                }
            }});



        tableViewA.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                item = new PersonagemItem();
                item.setNomeItem(tableViewA.getSelectionModel().getSelectedItem().getNomeItem());
                item.setQuantidade(tableViewA.getSelectionModel().getSelectedItem().getQuantidade());
                item.setEquipado(tableViewA.getSelectionModel().getSelectedItem().isEquipado());
                comboBoxItem.setValue(tableViewA.getSelectionModel().getSelectedItem().getNomeItem());
                quantidadeItem.setText(String.valueOf(tableViewA.getSelectionModel().getSelectedItem().getQuantidade()));
                comboBoxEquipado.setValue(String.valueOf(tableViewA.getSelectionModel().getSelectedItem().isEquipado()));
            }
        });

        tableViewB.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pericia = tableViewB.getSelectionModel().getSelectedItem();
                comboBoxPericia.setValue(pericia);
            }
        });

        tableViewC.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                magia = tableViewC.getSelectionModel().getSelectedItem();
                comboBoxMagia.setValue(magia);
            }
        });

        tableViewD.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                talento = tableViewD.getSelectionModel().getSelectedItem();
                comboBoxTalento.setValue(talento);
            }
        });



        comboBoxClasse.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               comboBoxArquetipo.setDisable(false);
               comboBoxArquetipo.getItems().clear();
               comboBoxArquetipo.getItems().addAll(ClasseDAO.ListArquetipo(comboBoxClasse.getValue()));
            }});

        Listeners();

    }

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToNovaCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }{}


    public void initTable(){

        column1.setCellValueFactory(new PropertyValueFactory<>("codigoAparencia"));
        column2.setCellValueFactory(new PropertyValueFactory<>("nomePersonagem"));
        column3.setCellValueFactory(new PropertyValueFactory<>("altura"));
        column4.setCellValueFactory(new PropertyValueFactory<>("peso"));
        column5.setCellValueFactory(new PropertyValueFactory<>("corOlhos"));
        column6.setCellValueFactory(new PropertyValueFactory<>("idade"));
        column7.setCellValueFactory(new PropertyValueFactory<>("corPele"));
        column8.setCellValueFactory(new PropertyValueFactory<>("corCabelo"));
        column9.setCellValueFactory(new PropertyValueFactory<>("codigoPersonagem"));
        column10.setCellValueFactory(new PropertyValueFactory<>("nomeJogador"));
        column11.setCellValueFactory(new PropertyValueFactory<>("nomeCampanha"));
        column12.setCellValueFactory(new PropertyValueFactory<>("personagemSubRaca"));
        column13.setCellValueFactory(new PropertyValueFactory<>("personagemClasse"));
        column14.setCellValueFactory(new PropertyValueFactory<>("deus"));
        column15.setCellValueFactory(new PropertyValueFactory<>("arquetipo"));
        column16.setCellValueFactory(new PropertyValueFactory<>("nomeAntecedente"));
        column17.setCellValueFactory(new PropertyValueFactory<>("tendencia"));
        column18.setCellValueFactory(new PropertyValueFactory<>("percepcaoPassiva"));
        column19.setCellValueFactory(new PropertyValueFactory<>("numeroInspiracao"));
        column20.setCellValueFactory(new PropertyValueFactory<>("pontosVidaAtual"));
        column21.setCellValueFactory(new PropertyValueFactory<>("pontosVidaTotal"));
        column22.setCellValueFactory(new PropertyValueFactory<>("pontosExperiencia"));
        column23.setCellValueFactory(new PropertyValueFactory<>("capacidadeCarga"));
        column24.setCellValueFactory(new PropertyValueFactory<>("cobre"));
        column25.setCellValueFactory(new PropertyValueFactory<>("prata"));
        column26.setCellValueFactory(new PropertyValueFactory<>("ouro"));
        column27.setCellValueFactory(new PropertyValueFactory<>("platina"));
        column28.setCellValueFactory(new PropertyValueFactory<>("electro"));
        column29.setCellValueFactory(new PropertyValueFactory<>("classeArmadura"));
        column30.setCellValueFactory(new PropertyValueFactory<>("deslocamento"));
        column31.setCellValueFactory(new PropertyValueFactory<>("caracteristicaAdicional"));
        column32.setCellValueFactory(new PropertyValueFactory<>("vinculo"));
        column33.setCellValueFactory(new PropertyValueFactory<>("defeito"));
        column34.setCellValueFactory(new PropertyValueFactory<>("ideal"));
        column35.setCellValueFactory(new PropertyValueFactory<>("tracoPersonalidade"));
        column36.setCellValueFactory(new PropertyValueFactory<>("carisma"));
        column37.setCellValueFactory(new PropertyValueFactory<>("constituicao"));
        column38.setCellValueFactory(new PropertyValueFactory<>("forca"));
        column39.setCellValueFactory(new PropertyValueFactory<>("destreza"));
        column40.setCellValueFactory(new PropertyValueFactory<>("sabedoria"));
        column41.setCellValueFactory(new PropertyValueFactory<>("inteligencia"));


        columnA2.setCellValueFactory(new PropertyValueFactory<>("nomeItem"));
        columnA3.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        columnA4.setCellValueFactory(new PropertyValueFactory<>("equipado"));

        columnB2.setCellValueFactory(stringStringCellDataFeatures -> new ReadOnlyStringWrapper(stringStringCellDataFeatures.getValue()));

        columnC2.setCellValueFactory(stringStringCellDataFeatures -> new ReadOnlyStringWrapper(stringStringCellDataFeatures.getValue()));

        columnD2.setCellValueFactory(stringStringCellDataFeatures -> new ReadOnlyStringWrapper(stringStringCellDataFeatures.getValue()));

        refreshTable();
    }


    public static void refreshTable(){
        tableViewStatic.getItems().clear();
        ObservableList<Personagem> personagem = FXCollections.observableArrayList(PersonagemDAO.Listar());
        if(personagem.size() > 0){
            tableViewStatic.setItems(personagem);
        }
    }

    void reloadPersonagem(){
        removerPersonagem.setDisable(true);
        atualizarPersonagem.setDisable(true);
        adicionarPersonagem.setDisable(false);

        adicionarItem.setDisable(true);
        atualizarItem.setDisable(true);
        removerItem.setDisable(true);
        adicionarPericia.setDisable(true);
        removerPericia.setDisable(true);
        adicionarMagia.setDisable(true);
        removerMagia.setDisable(true);
        adicionarTalento.setDisable(true);
        removerTalento.setDisable(true);

        comboBoxArquetipo.setDisable(true);
    }
    
    private void clearLabels(){
        nomePersonagem.clear();
        classeArmaduraPersonagem.clear();
        classeArmaduraPersonagem.setText("0");
        alturaPersonagem.clear();
        corPelePersonagem.clear();
        idadePersonagem.clear();
        pesoPersonagem.clear();
        corOlhosPersonagem.clear();
        numeroInspiracaoPersonagem.clear();
        percepcaoPassivaPersonagem.clear();
        corCabeloPersonagem.clear();
        nomeJogadorPersonagem.clear();
        capacidadeCargaPersonagem.clear();
        pontosExperienciaPersonagem.clear();
        pontosVidaAtualPersonagem.clear();
        pontosVidaTotalPersonagem.clear();
        platinaPersonagem.clear();
        ouroPersonagem.clear();
        cobrePersonagem.clear();
        prataPersonagem.clear();
        electroPersonagem.clear();
        deslocamentoPersonagem.clear();
        carismaPersonagem.clear();
        constituicaoPersonagem.clear();
        forcaPersonagem.clear();
        destrezaPersonagem.clear();
        sabedoriaPersonagem.clear();
        inteligenciaPersonagem.clear();
        caracteristicaAdicionalPersonagem.clear();
        vinculoPersonagem.clear();
        defeitoPersonagem.clear();
        idealPersonagem.clear();
        tracoPersonalidadePersonagem.clear();
        quantidadeItem.clear();
    }

    @FXML
    private void limpar(ActionEvent event){

        clearLabels();
        refreshTable();
        reloadPersonagem();
        tableViewA.getItems().clear();
        tableViewB.getItems().clear();
        tableViewC.getItems().clear();
        tableViewD.getItems().clear();
    }

    @FXML
    private void adicionarPersonagem(ActionEvent event){

        personagemAtual = new Personagem(0, nomePersonagem.getText(), Float.parseFloat(alturaPersonagem.getText()), Float.parseFloat(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), 0,
        nomeJogadorPersonagem.getText(), CampanhaAtualController.getCampanhaAtual().getNome(), comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
                Integer.parseInt(numeroInspiracaoPersonagem.getText()), Integer.parseInt(pontosVidaAtualPersonagem.getText()), Integer.parseInt(pontosVidaTotalPersonagem.getText()), Integer.parseInt(pontosExperienciaPersonagem.getText()), Integer.parseInt(capacidadeCargaPersonagem.getText()), Integer.parseInt(cobrePersonagem.getText()),
                Integer.parseInt(prataPersonagem.getText()), Integer.parseInt(ouroPersonagem.getText()), Integer.parseInt(platinaPersonagem.getText()), Integer.parseInt(electroPersonagem.getText()), Integer.parseInt(classeArmaduraPersonagem.getText()), Float.parseFloat(deslocamentoPersonagem.getText()), caracteristicaAdicionalPersonagem.getText(),
                vinculoPersonagem.getText(), defeitoPersonagem.getText(), idealPersonagem.getText(), tracoPersonalidadePersonagem.getText(), Integer.parseInt(carismaPersonagem.getText()), Integer.parseInt(constituicaoPersonagem.getText()), Integer.parseInt(forcaPersonagem.getText()), Integer.parseInt(destrezaPersonagem.getText()), Integer.parseInt(sabedoriaPersonagem.getText()), Integer.parseInt(inteligenciaPersonagem.getText()));
        PersonagemDAO.Inserir(personagemAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }

    @FXML
    private void atualizarPersonagem(ActionEvent event){
        personagemAtual = new Personagem(personagemAntigo.getCodigoAparencia(), nomePersonagem.getText(), Float.parseFloat(alturaPersonagem.getText()), Float.parseFloat(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), personagemAntigo.getCodigoPersonagem(),
                nomeJogadorPersonagem.getText(),  CampanhaAtualController.getCampanhaAtual().getNome(), comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
                Integer.parseInt(numeroInspiracaoPersonagem.getText()), Integer.parseInt(pontosVidaAtualPersonagem.getText()), Integer.parseInt(pontosVidaTotalPersonagem.getText()), Integer.parseInt(pontosExperienciaPersonagem.getText()), Integer.parseInt(capacidadeCargaPersonagem.getText()), Integer.parseInt(cobrePersonagem.getText()),
                Integer.parseInt(prataPersonagem.getText()), Integer.parseInt(ouroPersonagem.getText()), Integer.parseInt(platinaPersonagem.getText()), Integer.parseInt(electroPersonagem.getText()), Integer.parseInt(classeArmaduraPersonagem.getText()), Float.parseFloat(deslocamentoPersonagem.getText()), caracteristicaAdicionalPersonagem.getText(),
                vinculoPersonagem.getText(), defeitoPersonagem.getText(), idealPersonagem.getText(), tracoPersonalidadePersonagem.getText(), Integer.parseInt(carismaPersonagem.getText()), Integer.parseInt(constituicaoPersonagem.getText()), Integer.parseInt(forcaPersonagem.getText()), Integer.parseInt(destrezaPersonagem.getText()), Integer.parseInt(sabedoriaPersonagem.getText()), Integer.parseInt(inteligenciaPersonagem.getText()));

        PersonagemDAO.Atualizar(personagemAtual);
        refreshTable();
        reloadPersonagem();
        clearLabels();
        tableViewA.getItems().clear();
        tableViewB.getItems().clear();
        tableViewC.getItems().clear();
        tableViewD.getItems().clear();
    }

    @FXML
    private void removerPersonagem(ActionEvent event){
        PersonagemDAO.Remover(personagemAntigo);
        refreshTable();
        reloadPersonagem();
        clearLabels();
        tableViewA.getItems().clear();
        tableViewB.getItems().clear();
        tableViewC.getItems().clear();
        tableViewD.getItems().clear();

    }



    @FXML
    private void adicionarItem(ActionEvent event){

        if(comboBoxEquipado.getValue() == "true"){
            PersonagemDAO.InserirItem(personagemAntigo, comboBoxItem.getValue(), Integer.parseInt(quantidadeItem.getText()), true);

        }else{
            PersonagemDAO.InserirItem(personagemAntigo, comboBoxItem.getValue(), Integer.parseInt(quantidadeItem.getText()), false);

        }

        refreshItem();
    }
    @FXML
    private void atualizarItem(ActionEvent event){
        if(comboBoxEquipado.getValue() == "true"){
            PersonagemDAO.AtualizarItem(personagemAntigo, item.getNomeItem(), Integer.parseInt(quantidadeItem.getText()), true);

        }else{
            PersonagemDAO.AtualizarItem(personagemAntigo, item.getNomeItem(), Integer.parseInt(quantidadeItem.getText()), false);

        }

        refreshItem();
    }

    @FXML
    private void removerItem(ActionEvent event){
        PersonagemDAO.RemoverItem(personagemAntigo, item.getNomeItem());

        refreshItem();
    }


    @FXML
    private void adicionarPericia(ActionEvent event){
        PersonagemDAO.InserirPericia(personagemAntigo, comboBoxPericia.getValue());


        refreshPericia();
    }

    @FXML
    private void removerPericia(ActionEvent event){
        PersonagemDAO.RemoverPericia(personagemAntigo, pericia);



        refreshPericia();
    }


    @FXML
    private void adicionarMagia(ActionEvent event){
        PersonagemDAO.InserirMagia(personagemAntigo, comboBoxMagia.getValue());

        refreshMagia();
    }

    @FXML
    private void removerMagia(ActionEvent event){
        PersonagemDAO.RemoverMagia(personagemAntigo, magia);

        refreshMagia();
    }


    @FXML
    private void adicionarTalento(ActionEvent event){
        PersonagemDAO.InserirTalento(personagemAntigo, comboBoxTalento.getValue());


        refreshTalento();
    }

    @FXML
    private void removerTalento(ActionEvent event){
        PersonagemDAO.RemoverTalento(personagemAntigo, talento);

        refreshTalento();
    }

    public void initComboBox(){
        comboBoxSubRaca.getItems().clear();
        comboBoxClasse.getItems().clear();
        comboBoxDeus.getItems().clear();
        comboBoxArquetipo.getItems().clear();
        comboBoxAntecedente.getItems().clear();
        comboBoxTendencia.getItems().clear();
        comboBoxItem.getItems().clear();
        comboBoxEquipado.getItems().clear();
        comboBoxPericia.getItems().clear();
        comboBoxMagia.getItems().clear();
        comboBoxTalento.getItems().clear();

        comboBoxSubRaca.getItems().addAll(SubRacaDAO.ListSubRaca());
        comboBoxClasse.getItems().addAll(ClasseDAO.ListClasse());
        comboBoxDeus.getItems().addAll(DeusDAO.ListarDeus());
        comboBoxAntecedente.getItems().addAll(PersonagemDAO.ListAntecedente());
        comboBoxTendencia.getItems().addAll("Leal e Bom", "Neutro e Bom", "Caótico e Bom", "Leal e Neutro", "Neutro", "Caótico e Neutro", "Leal e Mal", "Neutro e Mal", "Caótico e Mal");
        comboBoxItem.getItems().addAll(ItemDAO.ListNomeItens());
        comboBoxEquipado.getItems().addAll(String.valueOf(true), String.valueOf(false));
        comboBoxPericia.getItems().addAll(PericiaDAO.ListPericias());
        comboBoxMagia.getItems().addAll(MagiaDAO.ListMagias());
        comboBoxTalento.getItems().addAll(TalentoDAO.ListTalentos());
    }


    private void refreshItem(){
        ArrayList<PersonagemItem> itens = PersonagemDAO.ListarItens(personagemAntigo);
        tableViewA.getItems().clear();
        if(itens.size() > 0){
            for(int i = 0; i < itens.size(); i++){
                tableViewA.getItems().add(itens.get(i));
            }
        }

    }

    private void refreshPericia(){
        ArrayList<String> nomes = PersonagemDAO.ListarPericias(personagemAntigo);
        tableViewB.getItems().clear();
        if(nomes.size() > 0){
            for(int i = 0; i < nomes.size(); i++){
                tableViewB.getItems().add(nomes.get(i));
            }
        }
    }

    private void refreshMagia(){
        ArrayList<String> nomes = PersonagemDAO.ListarMagias(personagemAntigo);
        tableViewC.getItems().clear();
        if(nomes.size() > 0){
            for(int i = 0; i < nomes.size(); i++){
                tableViewC.getItems().add(nomes.get(i));
            }
        }
    }

    private void refreshTalento(){
        ArrayList<String> nomes = PersonagemDAO.ListarTalentos(personagemAntigo);
        tableViewD.getItems().clear();
        if(nomes.size() > 0){
            for(int i = 0; i < nomes.size(); i++){
                tableViewD.getItems().add(nomes.get(i));
            }
        }
    }

    public void Listeners(){
        idadePersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    idadePersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        numeroInspiracaoPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    numeroInspiracaoPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        percepcaoPassivaPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    percepcaoPassivaPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        capacidadeCargaPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    capacidadeCargaPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        pontosExperienciaPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    pontosExperienciaPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        pontosVidaAtualPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    pontosVidaAtualPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        pontosVidaTotalPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    pontosVidaTotalPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        platinaPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    platinaPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        ouroPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    ouroPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        cobrePersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    cobrePersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        prataPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    prataPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        electroPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    electroPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        carismaPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    electroPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        constituicaoPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    electroPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        destrezaPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    electroPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        forcaPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    electroPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        inteligenciaPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    electroPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        sabedoriaPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    electroPersonagem.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        alturaPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    alturaPersonagem.setText(oldValue);
                }
            }
        });

        deslocamentoPersonagem.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    deslocamentoPersonagem.setText(oldValue);
                }
            }
        });
    }
}
