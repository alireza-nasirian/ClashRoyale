package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import Controller.ScreensController;
import java.io.IOException;

public class Main extends Application {

    public static Player player;

    public static final String menu = "menu";
    public static final String menuFile = "StartMenu.fxml";
    public static final String profile = "profile";
    public static final String profileFile = "ProfileView.fxml";
    public static final String register = "register";
    public static final String registerFile = "Register.fxml";
    public static final String login = "login";
    public static final String loginFile = "Login.fxml";
    public static final String battleDeck ="battleDeck";
    public static final String battleDeckFile = "BattleDeck.fxml";
    public static final String history = "battleHistory";
    public static final String historyFile = "BattleHistory.fxml";


   /* @Override
    public void start(Stage primaryStage) {
        try {
            ViewManager manager = new ViewManager();
            primaryStage = manager.getMainStage();
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    @Override
    public void start(Stage primaryStage) throws IOException {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(menu, menuFile);
        mainContainer.loadScreen(profile, profileFile);
        mainContainer.loadScreen(register, registerFile);
        mainContainer.loadScreen(login, loginFile);
        mainContainer.loadScreen(battleDeck, battleDeckFile);
        mainContainer.loadScreen(history, historyFile);


        mainContainer.setScreen(login);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
/*

        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(root); // attach scene graph to scene
        primaryStage.setTitle("Tip Calculator"); // displayed in window's title bar
        primaryStage.setScene(scene); // attach scene to stage
        primaryStage.show(); // display the stage
*/

    }


    public static void main(String[] args) {
        launch(args);
    }
}
