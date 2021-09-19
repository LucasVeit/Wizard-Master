package Controller;

import Model.Cidade;
import Model.DAO.DeusDAO;
import Model.DAO.New.CidadeDAO;
import Model.DAO.New.LiderDAO;
import Model.DAO.New.PersonagemDAO;
import Model.Lider;
import Model.Personagem.*;
import javafx.beans.property.*;
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
    TableColumn<PersonagemItem, SimpleStringProperty> columnA1;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> columnA2;
    @FXML
    TableColumn<PersonagemItem, SimpleBooleanProperty> columnA3;

    @FXML
    private TableView<PersonagemPericia> tableViewB;
    @FXML
    TableColumn<PersonagemPericia, SimpleStringProperty> columnB1;

    @FXML
    private TableView<PersonagemMagia> tableViewC;
    @FXML
    TableColumn<PersonagemMagia, SimpleStringProperty> columnC1;

    @FXML
    private TableView<PersonagemTalento> tableViewD;
    @FXML
    TableColumn<PersonagemTalento, SimpleStringProperty> columnD1;

    @FXML
    private ComboBox<String> comboBoxItem;
    @FXML
    private TextField nomeItem;
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
    String lider;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("oi");
        reloadPersonagem();
        System.out.println("Bão?");
        initTable();
        initComboBox();
        System.out.println("Sim e tu?");

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                personagemAntigo = tableView.getSelectionModel().getSelectedItem();
                if (mouseEvent.getClickCount() == 2){


                    removerPersonagem.setDisable(false);
                    atualizarPersonagem.setDisable(false);
                    adicionarPersonagem.setDisable(true);

                    adicionarItem.setDisable(false);
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
                    vinculoPersonagem.setText(personagemAntigo.getVinculo());
                    defeitoPersonagem.setText(personagemAntigo.getDefeito());
                    idealPersonagem.setText(personagemAntigo.getIdeal());
                    tracoPersonalidadePersonagem.setText(personagemAntigo.getTracoPersonalidade());

                    ObservableList<Personagem> personagens = FXCollections.observableArrayList(PersonagemDAO.Listar());

                    if(personagens.size() > 0){
                        tableView.setItems(personagens);
                    }

                    initComboBox();
                }
            }});

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
        System.out.println("Eta");
        columnA1.setCellValueFactory(new PropertyValueFactory<>("nomeItem"));
        System.out.println("Etaa");
        columnA2.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        System.out.println("Etaaa");
        columnA3.setCellValueFactory(new PropertyValueFactory<>("equipado"));
        System.out.println("Etax");
        columnB1.setCellValueFactory(new PropertyValueFactory<>("nomePericia"));

        System.out.println("Etaxa");
        columnC1.setCellValueFactory(new PropertyValueFactory<>("nomeMagia"));
        System.out.println("Etaxaa");
        columnD1.setCellValueFactory(new PropertyValueFactory<>("nomeTalento"));
        System.out.println("Etaxaa");
        System.out.println("aonde para?");

        refreshTable();
    }


    private void refreshTable(){
        System.out.println("Será que aqui?");
        tableView.getItems().clear();
        System.out.println("aqui foi?");
        ObservableList<Personagem> personagem = FXCollections.observableArrayList(PersonagemDAO.Listar());
        System.out.println("e aqui?");
        if(personagem.size() > 0){
            tableView.setItems(personagem);
        }
        System.out.println("se foi aqui foi tudo");
    }

    void reloadPersonagem(){
        removerPersonagem.setDisable(true);
        atualizarPersonagem.setDisable(true);
        adicionarPersonagem.setDisable(false);

        adicionarItem.setDisable(false);
        removerItem.setDisable(false);
        adicionarPericia.setDisable(false);
        removerPericia.setDisable(false);
        adicionarMagia.setDisable(false);
        removerMagia.setDisable(false);
        adicionarTalento.setDisable(false);
        removerTalento.setDisable(false);
    }
    
    private void clearLabels(){
        nomePersonagem.clear();
        classeArmaduraPersonagem.clear();
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
        vinculoPersonagem.clear();
        defeitoPersonagem.clear();
        idealPersonagem.clear();
        tracoPersonalidadePersonagem.clear();
        nomeItem.clear();
        quantidadeItem.clear();
    }

    @FXML
    private void limpar(ActionEvent event){

        clearLabels();
        reloadPersonagem();
        tableViewA.getItems().clear();
        tableViewB.getItems().clear();
        tableViewC.getItems().clear();
        tableViewD.getItems().clear();
    }

    @FXML
    private void adicionarPersonagem(ActionEvent event){

        personagemAtual = new Personagem(0, nomePersonagem.getText(), Integer.parseInt(alturaPersonagem.getText()), Integer.parseInt(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), 0,
        nomeJogadorPersonagem.getText(), "Lorin", comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
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
        personagemAtual = new Personagem(personagemAntigo.getCodigoAparencia(), nomePersonagem.getText(), Integer.parseInt(alturaPersonagem.getText()), Integer.parseInt(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), personagemAntigo.getCodigoPersonagem(),
                nomeJogadorPersonagem.getText(), "Lorin", comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
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

        personagemAtual = new Personagem(0, nomePersonagem.getText(), Integer.parseInt(alturaPersonagem.getText()), Integer.parseInt(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), 0,
                nomeJogadorPersonagem.getText(), "Lorin", comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
                Integer.parseInt(numeroInspiracaoPersonagem.getText()), Integer.parseInt(pontosVidaAtualPersonagem.getText()), Integer.parseInt(pontosVidaTotalPersonagem.getText()), Integer.parseInt(pontosExperienciaPersonagem.getText()), Integer.parseInt(capacidadeCargaPersonagem.getText()), Integer.parseInt(cobrePersonagem.getText()),
                Integer.parseInt(prataPersonagem.getText()), Integer.parseInt(ouroPersonagem.getText()), Integer.parseInt(platinaPersonagem.getText()), Integer.parseInt(electroPersonagem.getText()), Integer.parseInt(classeArmaduraPersonagem.getText()), Float.parseFloat(deslocamentoPersonagem.getText()), caracteristicaAdicionalPersonagem.getText(),
                vinculoPersonagem.getText(), defeitoPersonagem.getText(), idealPersonagem.getText(), tracoPersonalidadePersonagem.getText(), Integer.parseInt(carismaPersonagem.getText()), Integer.parseInt(constituicaoPersonagem.getText()), Integer.parseInt(forcaPersonagem.getText()), Integer.parseInt(destrezaPersonagem.getText()), Integer.parseInt(sabedoriaPersonagem.getText()), Integer.parseInt(inteligenciaPersonagem.getText()));
        PersonagemDAO.Inserir(personagemAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }

    @FXML
    private void removerItem(ActionEvent event){

        personagemAtual = new Personagem(0, nomePersonagem.getText(), Integer.parseInt(alturaPersonagem.getText()), Integer.parseInt(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), 0,
                nomeJogadorPersonagem.getText(), "Lorin", comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
                Integer.parseInt(numeroInspiracaoPersonagem.getText()), Integer.parseInt(pontosVidaAtualPersonagem.getText()), Integer.parseInt(pontosVidaTotalPersonagem.getText()), Integer.parseInt(pontosExperienciaPersonagem.getText()), Integer.parseInt(capacidadeCargaPersonagem.getText()), Integer.parseInt(cobrePersonagem.getText()),
                Integer.parseInt(prataPersonagem.getText()), Integer.parseInt(ouroPersonagem.getText()), Integer.parseInt(platinaPersonagem.getText()), Integer.parseInt(electroPersonagem.getText()), Integer.parseInt(classeArmaduraPersonagem.getText()), Float.parseFloat(deslocamentoPersonagem.getText()), caracteristicaAdicionalPersonagem.getText(),
                vinculoPersonagem.getText(), defeitoPersonagem.getText(), idealPersonagem.getText(), tracoPersonalidadePersonagem.getText(), Integer.parseInt(carismaPersonagem.getText()), Integer.parseInt(constituicaoPersonagem.getText()), Integer.parseInt(forcaPersonagem.getText()), Integer.parseInt(destrezaPersonagem.getText()), Integer.parseInt(sabedoriaPersonagem.getText()), Integer.parseInt(inteligenciaPersonagem.getText()));
        PersonagemDAO.Inserir(personagemAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }


    @FXML
    private void adicionarPericia(ActionEvent event){

        personagemAtual = new Personagem(0, nomePersonagem.getText(), Integer.parseInt(alturaPersonagem.getText()), Integer.parseInt(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), 0,
                nomeJogadorPersonagem.getText(), "Lorin", comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
                Integer.parseInt(numeroInspiracaoPersonagem.getText()), Integer.parseInt(pontosVidaAtualPersonagem.getText()), Integer.parseInt(pontosVidaTotalPersonagem.getText()), Integer.parseInt(pontosExperienciaPersonagem.getText()), Integer.parseInt(capacidadeCargaPersonagem.getText()), Integer.parseInt(cobrePersonagem.getText()),
                Integer.parseInt(prataPersonagem.getText()), Integer.parseInt(ouroPersonagem.getText()), Integer.parseInt(platinaPersonagem.getText()), Integer.parseInt(electroPersonagem.getText()), Integer.parseInt(classeArmaduraPersonagem.getText()), Float.parseFloat(deslocamentoPersonagem.getText()), caracteristicaAdicionalPersonagem.getText(),
                vinculoPersonagem.getText(), defeitoPersonagem.getText(), idealPersonagem.getText(), tracoPersonalidadePersonagem.getText(), Integer.parseInt(carismaPersonagem.getText()), Integer.parseInt(constituicaoPersonagem.getText()), Integer.parseInt(forcaPersonagem.getText()), Integer.parseInt(destrezaPersonagem.getText()), Integer.parseInt(sabedoriaPersonagem.getText()), Integer.parseInt(inteligenciaPersonagem.getText()));
        PersonagemDAO.Inserir(personagemAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }

    @FXML
    private void removerPericia(ActionEvent event){

        personagemAtual = new Personagem(0, nomePersonagem.getText(), Integer.parseInt(alturaPersonagem.getText()), Integer.parseInt(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), 0,
                nomeJogadorPersonagem.getText(), "Lorin", comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
                Integer.parseInt(numeroInspiracaoPersonagem.getText()), Integer.parseInt(pontosVidaAtualPersonagem.getText()), Integer.parseInt(pontosVidaTotalPersonagem.getText()), Integer.parseInt(pontosExperienciaPersonagem.getText()), Integer.parseInt(capacidadeCargaPersonagem.getText()), Integer.parseInt(cobrePersonagem.getText()),
                Integer.parseInt(prataPersonagem.getText()), Integer.parseInt(ouroPersonagem.getText()), Integer.parseInt(platinaPersonagem.getText()), Integer.parseInt(electroPersonagem.getText()), Integer.parseInt(classeArmaduraPersonagem.getText()), Float.parseFloat(deslocamentoPersonagem.getText()), caracteristicaAdicionalPersonagem.getText(),
                vinculoPersonagem.getText(), defeitoPersonagem.getText(), idealPersonagem.getText(), tracoPersonalidadePersonagem.getText(), Integer.parseInt(carismaPersonagem.getText()), Integer.parseInt(constituicaoPersonagem.getText()), Integer.parseInt(forcaPersonagem.getText()), Integer.parseInt(destrezaPersonagem.getText()), Integer.parseInt(sabedoriaPersonagem.getText()), Integer.parseInt(inteligenciaPersonagem.getText()));
        PersonagemDAO.Inserir(personagemAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }


    @FXML
    private void adicionarMagia(ActionEvent event){

        personagemAtual = new Personagem(0, nomePersonagem.getText(), Integer.parseInt(alturaPersonagem.getText()), Integer.parseInt(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), 0,
                nomeJogadorPersonagem.getText(), "Lorin", comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
                Integer.parseInt(numeroInspiracaoPersonagem.getText()), Integer.parseInt(pontosVidaAtualPersonagem.getText()), Integer.parseInt(pontosVidaTotalPersonagem.getText()), Integer.parseInt(pontosExperienciaPersonagem.getText()), Integer.parseInt(capacidadeCargaPersonagem.getText()), Integer.parseInt(cobrePersonagem.getText()),
                Integer.parseInt(prataPersonagem.getText()), Integer.parseInt(ouroPersonagem.getText()), Integer.parseInt(platinaPersonagem.getText()), Integer.parseInt(electroPersonagem.getText()), Integer.parseInt(classeArmaduraPersonagem.getText()), Float.parseFloat(deslocamentoPersonagem.getText()), caracteristicaAdicionalPersonagem.getText(),
                vinculoPersonagem.getText(), defeitoPersonagem.getText(), idealPersonagem.getText(), tracoPersonalidadePersonagem.getText(), Integer.parseInt(carismaPersonagem.getText()), Integer.parseInt(constituicaoPersonagem.getText()), Integer.parseInt(forcaPersonagem.getText()), Integer.parseInt(destrezaPersonagem.getText()), Integer.parseInt(sabedoriaPersonagem.getText()), Integer.parseInt(inteligenciaPersonagem.getText()));
        PersonagemDAO.Inserir(personagemAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }

    @FXML
    private void removerMagia(ActionEvent event){

        personagemAtual = new Personagem(0, nomePersonagem.getText(), Integer.parseInt(alturaPersonagem.getText()), Integer.parseInt(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), 0,
                nomeJogadorPersonagem.getText(), "Lorin", comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
                Integer.parseInt(numeroInspiracaoPersonagem.getText()), Integer.parseInt(pontosVidaAtualPersonagem.getText()), Integer.parseInt(pontosVidaTotalPersonagem.getText()), Integer.parseInt(pontosExperienciaPersonagem.getText()), Integer.parseInt(capacidadeCargaPersonagem.getText()), Integer.parseInt(cobrePersonagem.getText()),
                Integer.parseInt(prataPersonagem.getText()), Integer.parseInt(ouroPersonagem.getText()), Integer.parseInt(platinaPersonagem.getText()), Integer.parseInt(electroPersonagem.getText()), Integer.parseInt(classeArmaduraPersonagem.getText()), Float.parseFloat(deslocamentoPersonagem.getText()), caracteristicaAdicionalPersonagem.getText(),
                vinculoPersonagem.getText(), defeitoPersonagem.getText(), idealPersonagem.getText(), tracoPersonalidadePersonagem.getText(), Integer.parseInt(carismaPersonagem.getText()), Integer.parseInt(constituicaoPersonagem.getText()), Integer.parseInt(forcaPersonagem.getText()), Integer.parseInt(destrezaPersonagem.getText()), Integer.parseInt(sabedoriaPersonagem.getText()), Integer.parseInt(inteligenciaPersonagem.getText()));
        PersonagemDAO.Inserir(personagemAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }


    @FXML
    private void adicionarTalento(ActionEvent event){

        personagemAtual = new Personagem(0, nomePersonagem.getText(), Integer.parseInt(alturaPersonagem.getText()), Integer.parseInt(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), 0,
                nomeJogadorPersonagem.getText(), "Lorin", comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
                Integer.parseInt(numeroInspiracaoPersonagem.getText()), Integer.parseInt(pontosVidaAtualPersonagem.getText()), Integer.parseInt(pontosVidaTotalPersonagem.getText()), Integer.parseInt(pontosExperienciaPersonagem.getText()), Integer.parseInt(capacidadeCargaPersonagem.getText()), Integer.parseInt(cobrePersonagem.getText()),
                Integer.parseInt(prataPersonagem.getText()), Integer.parseInt(ouroPersonagem.getText()), Integer.parseInt(platinaPersonagem.getText()), Integer.parseInt(electroPersonagem.getText()), Integer.parseInt(classeArmaduraPersonagem.getText()), Float.parseFloat(deslocamentoPersonagem.getText()), caracteristicaAdicionalPersonagem.getText(),
                vinculoPersonagem.getText(), defeitoPersonagem.getText(), idealPersonagem.getText(), tracoPersonalidadePersonagem.getText(), Integer.parseInt(carismaPersonagem.getText()), Integer.parseInt(constituicaoPersonagem.getText()), Integer.parseInt(forcaPersonagem.getText()), Integer.parseInt(destrezaPersonagem.getText()), Integer.parseInt(sabedoriaPersonagem.getText()), Integer.parseInt(inteligenciaPersonagem.getText()));
        PersonagemDAO.Inserir(personagemAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }

    @FXML
    private void removerTalento(ActionEvent event){

        personagemAtual = new Personagem(0, nomePersonagem.getText(), Integer.parseInt(alturaPersonagem.getText()), Integer.parseInt(pesoPersonagem.getText()),corOlhosPersonagem.getText(), Integer.parseInt(idadePersonagem.getText()), corPelePersonagem.getText(), corCabeloPersonagem.getText(), 0,
                nomeJogadorPersonagem.getText(), "Lorin", comboBoxSubRaca.getValue(), comboBoxClasse.getValue(), DeusDAO.GetDeus(comboBoxDeus.getValue()).getCodigoDeus(), comboBoxArquetipo.getValue(), comboBoxAntecedente.getValue(), comboBoxTendencia.getValue(), Integer.parseInt(percepcaoPassivaPersonagem.getText()),
                Integer.parseInt(numeroInspiracaoPersonagem.getText()), Integer.parseInt(pontosVidaAtualPersonagem.getText()), Integer.parseInt(pontosVidaTotalPersonagem.getText()), Integer.parseInt(pontosExperienciaPersonagem.getText()), Integer.parseInt(capacidadeCargaPersonagem.getText()), Integer.parseInt(cobrePersonagem.getText()),
                Integer.parseInt(prataPersonagem.getText()), Integer.parseInt(ouroPersonagem.getText()), Integer.parseInt(platinaPersonagem.getText()), Integer.parseInt(electroPersonagem.getText()), Integer.parseInt(classeArmaduraPersonagem.getText()), Float.parseFloat(deslocamentoPersonagem.getText()), caracteristicaAdicionalPersonagem.getText(),
                vinculoPersonagem.getText(), defeitoPersonagem.getText(), idealPersonagem.getText(), tracoPersonalidadePersonagem.getText(), Integer.parseInt(carismaPersonagem.getText()), Integer.parseInt(constituicaoPersonagem.getText()), Integer.parseInt(forcaPersonagem.getText()), Integer.parseInt(destrezaPersonagem.getText()), Integer.parseInt(sabedoriaPersonagem.getText()), Integer.parseInt(inteligenciaPersonagem.getText()));
        PersonagemDAO.Inserir(personagemAtual);
        //adicionar no banco de dados

        refreshTable();
        clearLabels();
    }

    public void initComboBox(){
         comboBoxSubRaca.getItems().clear();
         comboBoxClasse.getItems().clear();
         comboBoxDeus.getItems().clear();
         comboBoxArquetipo.getItems().clear();
         comboBoxAntecedente.getItems().clear();
         comboBoxTendencia.getItems().clear();

    }
}
