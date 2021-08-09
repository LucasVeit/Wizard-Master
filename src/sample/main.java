package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class main extends Application {

    public static String screen1ID = "telaInicio";
    public static String screen1File = "telaInicio.fxml";
    public static String screen2ID = "databaseGenerica";
    public static String screen2File = "databaseGenerica.fxml";
    public static String screen3ID = "novaCampanha";
    public static String screen3File = "novaCampanha.fxml";
    public static String screen4ID = "telaResultado";
    public static String screen4File = "telaResultado.fxml";


    @Override
    public void start(Stage primaryStage) {

        /*
        Parent root = FXMLLoader.load(getClass().getResource("telaInicio.fxml"));
        primaryStage.setTitle("Wizard Master");
        primaryStage.setScene(new Scene(root, 1176, 780));
        primaryStage.show();
        */

        screensController mainContainer = new screensController();
        mainContainer.loadScreen(main.screen1ID, main.screen1File);
        mainContainer.loadScreen(main.screen2ID, main.screen2File);
        mainContainer.loadScreen(main.screen3ID, main.screen3File);
        mainContainer.loadScreen(main.screen4ID, main.screen4File);

        mainContainer.setScreen(main.screen1ID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);

        primaryStage.setTitle("Wizard Master");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }
}
