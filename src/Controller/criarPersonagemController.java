package Controller;

import Model.Cidade;
import Model.DAO.New.CidadeDAO;
import Model.Personagem.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.main;

import java.net.URL;
import java.util.ResourceBundle;

public class criarPersonagemController implements Initializable, controlledScreen {

    screensController myController;
    @FXML
    private TableView<Personagem> tableView;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column1;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column2;
    @FXML
    TableColumn<PersonagemItem, SimpleFloatProperty> column3;
    @FXML
    TableColumn<PersonagemItem, SimpleFloatProperty> column4;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column5;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column6;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column7;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column8;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column9;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column10;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column11;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column12;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column13;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column14;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column15;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column16;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column17;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column18;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column19;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column20;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column211;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column22;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column23;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column24;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column25;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column26;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column27;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column28;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column29;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column30;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column31;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column32;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column33;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column34;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> column35;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column36;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column37;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column38;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column39;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column40;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> column41;

    @FXML
    private TableView<PersonagemItem> tableViewA;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> columnA1;
    @FXML
    TableColumn<PersonagemItem, SimpleStringProperty> columnA2;
    @FXML
    TableColumn<PersonagemItem, SimpleIntegerProperty> columnA3;

    @FXML
    private TableView<PersonagemPericia> tableViewB;
    @FXML
    TableColumn<PersonagemPericia, SimpleIntegerProperty> columnB1;

    @FXML
    private TableView<PersonagemMagia> tableViewC;
    @FXML
    TableColumn<PersonagemMagia, SimpleIntegerProperty> columnC1;

    @FXML
    private TableView<PersonagemTalento> tableViewD;
    @FXML
    TableColumn<PersonagemTalento, SimpleIntegerProperty> columnD1;

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
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @Override
    public void setScreenParent(screensController screenPage) { myController = screenPage; }

    @FXML
    private void goToNovaCampanha(ActionEvent event){
        myController.setScreen(main.screen3ID);
    }{}



}
