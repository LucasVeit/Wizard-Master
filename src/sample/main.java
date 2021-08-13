package sample;

import Controller.screensController;
import Model.ConnectPostgre;
import Model.DAO.MonstroDAO;
import Model.Monstro.Monstro;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class main extends Application {

    public static String screen1ID = "telaInicio";
    public static String screen1File = "/View/telaInicio.fxml";
    public static String screen2ID = "databaseGenerica";
    public static String screen2File = "/View/databaseGenerica.fxml";
    public static String screen3ID = "novaCampanha";
    public static String screen3File = "/View/novaCampanha.fxml";
    public static String screen4ID = "telaResultado";
    public static String screen4File = "/View/telaResultado.fxml";


    @Override
    public void start(Stage primaryStage) {

        Connection con = ConnectPostgre.ConnectDatabase();
        MonstroDAO monstroDAO = new MonstroDAO();
        ArrayList<Monstro> monstros = monstroDAO.List();

        for (int i = 0; i < monstros.size(); i++){
            System.out.println(monstros.get(i).getNomeMonstro());
        }

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
