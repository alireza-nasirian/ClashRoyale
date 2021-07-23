package Controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.dataBase.DataBaseHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable, ControlledScreen {

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
    private javafx.scene.control.Label error;

    @FXML
    private javafx.scene.control.TextField usernameField;

    @FXML
    private javafx.scene.control.TextField passwordField;

    @FXML
    private javafx.scene.control.TextField password2Field;

    /**
     * send username and password to database
     */
    @FXML
    public void registerButton(ActionEvent event) {
        String userName = usernameField.getText();
        String password = passwordField.getText();
        String password2 = password2Field.getText();
        if (password.isEmpty() || password2.isEmpty() || userName.isEmpty()) {
            error.setText("All fields must be filled!");
            return;
        }
        if (!password.equals(password2)) {
            error.setText("Passwords do not match!");
            return;
        }
        int sent = dataBaseHandler.sendInfo(userName, password);
        if (sent == 0) {
            error.setText("Done!");
            Main.player = dataBaseHandler.makePlayer(userName);
            myController.setScreen(Main.menu);
        }else if (sent == 1){
            error.setText("This username has been already\n chosen!");
        }else {
            error.setText("Something went wrong!\n try again.");
        }
    }

    /**
     * go to login page when button pressed
     */
    @FXML
    public void goLogin(ActionEvent event) {
        myController.setScreen(Main.login);
    }
}
