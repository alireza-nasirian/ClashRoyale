package Controller;

import application.Main;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProfileController implements Initializable, ControlledScreen {

    ScreensController myController;
    
    public static String s = "cup";

    @FXML
    private Label name;

    @FXML
    private Label cup;

    @FXML
    private Label league;

    @FXML
    private Label level;

    @FXML
    private Label xp;

    @FXML
    private JFXButton card1, card2, card3, card4, card5, card6, card7, card8;

    private ArrayList<JFXButton> buttons = new ArrayList<>();

    /**
     * add buttons to buttons array list
     */
    private void addButtons(){
        if (buttons.isEmpty()) {
            buttons.add(card1);
            buttons.add(card2);
            buttons.add(card3);
            buttons.add(card4);
            buttons.add(card5);
            buttons.add(card6);
            buttons.add(card7);
            buttons.add(card8);
        }
    }

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
     * back to main menu when button pressed
     */
    @FXML
    private void backMenu(ActionEvent event){
        myController.setScreen(Main.menu);
    }

    /**
     * get a name and return path of image of card
     * @param name is name of card
     * @return path of image file
     */
    private String detectCard(String name){
        switch (name){
            case "Barbarians":
                return "/resources/profile/barbarians.png";
            case "Archers":
                return "/resources/profile/archers.png";
            case "Baby_Dragon":
                return "/resources/profile/baby-dragon.png";
            case "Wizard":
                return "/resources/profile/wizard.png";
            case "Mini_pekka":
                return "/resources/profile/mini-pekka.png";
            case "Giant":
                return "/resources/profile/giant.png";
            case "Valkyrie":
                return "/resources/profile/valkyrie.png";
            case "Rage":
                return "/resources/profile/rage.png";
            case "Fireball":
                return "/resources/profile/fireball.png";
            case "Arrows":
                return "/resources/profile/arrows.png";
            case "Cannon":
                return "/resources/profile/cannon.png";
            case "Inferno_Tower":
                return "/resources/profile/inferno-tower.png";
        }
        return null;
    }

    /**
     * load battle deck from player and show that in pagee
     */
    private void updateDeck(){
        if (Main.player.getDeck().isEmpty() || Main.player.getDeck() == null){
            return;
        }
        ArrayList<String> deck = Main.player.getDeck();
        for (int i = 0; i < 8; i++) {
            BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource(detectCard(deck.get(i))).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            Background background = new Background(backgroundImage);
            buttons.get(i).setBackground(background);
        }

    }

    /**
     * use methods
     */
    public void updateProfile(MouseEvent actionEvent){
        addButtons();
        name.setText(Main.player.getUsername());
        cup.setText(String.valueOf(Main.player.getCup()));
        league.setText(Main.player.getLeague());
        level.setText(String.valueOf(Main.player.getLevel()));
        xp.setText("(" + Main.player.getXp() + ")");
        updateDeck();
    }
}
