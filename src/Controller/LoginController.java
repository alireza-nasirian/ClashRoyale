package Controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.dataBase.DataBaseHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable, ControlledScreen {

    private DataBaseHandler dataBaseHandler = new DataBaseHandler();
    ScreensController myController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * change the screen
     * @param screenParent screens name
     */
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label error;

    /**
     * sends user input to data base and login
     */
    @FXML
    public void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (username.isEmpty() || password.isEmpty()){
            error.setText("Fill username and password fields!");
            return;
        }
        if (dataBaseHandler.login(username, password)){
            error.setText("Done!");
            Main.player = dataBaseHandler.makePlayer(username);
            Main.player.setDeck(dataBaseHandler.getDeck(username));
            dataBaseHandler.loadHistory(username);
            myController.setScreen(Main.menu);
        }else {
            error.setText("Wrong username or password!");
        }

    }

    /**
     * go to register page if button pressed
     */
    @FXML
    public void goRegister(ActionEvent event) {
        myController.setScreen(Main.register);
    }
}
