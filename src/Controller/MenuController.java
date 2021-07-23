package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * @author Alireza Nasirian
 * @version 1.0
 *  FXML Controller class
 */
public class MenuController implements Initializable, ControlledScreen {
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

    /**
     * go to profile page when button is pressed
     */
    @FXML
    private void goToProfile(ActionEvent event){
        myController.setScreen(Main.profile);
    }

    /**
     * go to battle deck  page when button is pressed
     */
    @FXML
    private void goBattleDeck(ActionEvent event){
        myController.setScreen(Main.battleDeck);
    }

    /**
     * back to login page when button pressed
     */
    @FXML
    public void logout(ActionEvent event) {
        myController.setScreen(Main.login);
    }

    /**
     * go to battle history page when button is pressed
     */
    @FXML
    public void goBattleHistory(ActionEvent event) {
        myController.setScreen(Main.history);
    }
}
