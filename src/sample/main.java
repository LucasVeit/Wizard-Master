package sample;

import Controller.screensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    public static String screen1ID = "telaInicio";
    public static String screen1File = "/View/telaInicio.fxml";
    public static String screen2ID = "databaseGenerica";
    public static String screen2File = "/View/databaseGenerica.fxml";
    public static String screen3ID = "Campanha";
    public static String screen3File = "/View/Campanha.fxml";
    public static String screen4ID = "telaResultado";
    public static String screen4File = "/View/telaResultado.fxml";
    public static String screen5ID = "criarCidade";
    public static String screen5File = "/View/CriarCidade.fxml";
    public static String screen6ID = "criarFaccao";
    public static String screen6File = "/View/CriarFaccao.fxml";
    public static String screen7ID = "criarLider";
    public static String screen7File = "/View/CriarLider.fxml";
    public static String screen8ID = "criarMundo";
    public static String screen8File = "/View/CriarMundo.fxml";
    public static String screen9ID = "criarPanteao";
    public static String screen9File = "/View/CriarPanteao.fxml";
    public static String screen10ID = "criarPersonagem";
    public static String screen10File = "/View/CriarPersonagem.fxml";
    public static String screen11ID = "novaCampanha";
    public static String screen11File = "/View/novaCampanha.fxml";


    @Override
    public void start(Stage primaryStage) {

        screensController mainContainer = new screensController();
        mainContainer.loadScreen(main.screen1ID, main.screen1File);
        mainContainer.loadScreen(main.screen2ID, main.screen2File);
        mainContainer.loadScreen(main.screen3ID, main.screen3File);
        mainContainer.loadScreen(main.screen4ID, main.screen4File);
        mainContainer.loadScreen(main.screen5ID, main.screen5File);
        mainContainer.loadScreen(main.screen6ID, main.screen6File);
        mainContainer.loadScreen(main.screen7ID, main.screen7File);
        mainContainer.loadScreen(main.screen8ID, main.screen8File);
        mainContainer.loadScreen(main.screen9ID, main.screen9File);
        mainContainer.loadScreen(main.screen10ID, main.screen10File);
        mainContainer.loadScreen(main.screen11ID, main.screen11File);

        mainContainer.setScreen(main.screen1ID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);

        primaryStage.setTitle("Wizard Master");
        primaryStage.setScene(new Scene(root, 1280, 720));

        primaryStage.show();
    }
}
