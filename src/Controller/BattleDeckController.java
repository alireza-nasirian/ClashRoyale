package Controller;

import application.Main;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.dataBase.DataBaseHandler;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class BattleDeckController implements Initializable, ControlledScreen {

    ScreensController myController;
    private ArrayList<JFXRadioButton> buttons = new ArrayList<>();
    private ArrayList<JFXRadioButton> selectedButtons = new ArrayList<>();
    private DataBaseHandler dataBaseHandler = new DataBaseHandler();

    @FXML
    private Label error;

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
    private JFXRadioButton Barbarians, Archers, Baby_Dragon, Wizard, Mini_pekka, Giant, Valkyrie, Rage, Fireball, Arrows, Cannon, Inferno_Tower;



    private void addButtons() {
        buttons.add(Barbarians);
        buttons.add(Archers);
        buttons.add(Baby_Dragon);
        buttons.add(Wizard);
        buttons.add(Mini_pekka);
        buttons.add(Giant);
        buttons.add(Valkyrie);
        buttons.add(Rage);
        buttons.add(Fireball);
        buttons.add(Archers);
        buttons.add(Cannon);
        buttons.add(Inferno_Tower);
    }

    /**
     * back t main menu when button pressed
     */
    public void backMenu(ActionEvent event) {
        myController.setScreen(Main.menu);
    }

    /**
     * selects a card
     */
    public void selectButton(ActionEvent event) {
        if (selectedButtons.size() == 8){
            Random random = new Random();
            int n = random.nextInt(7);
            JFXRadioButton button = selectedButtons.get(n);
            button.setSelected(false);
            selectedButtons.remove(n);
        }
        selectedButtons.add((JFXRadioButton) event.getSource());
    }

    /**
     * convert selected buttons to String
     * @param radioButtons is selected buttons
     * @return arraylist of Strings.
     */
    private ArrayList<String> buttonsToString(ArrayList<JFXRadioButton> radioButtons){
        ArrayList<String> strings = new ArrayList<>();
        for (JFXRadioButton jfxRadioButton : radioButtons){
            strings.add(jfxRadioButton.getId());
        }
        return strings;
    }

    /**
     * save selected cards into data base
     */
    public void save(ActionEvent event) {
        if (selectedButtons.size() == 8){
            Main.player.setDeck(buttonsToString(selectedButtons));
            error.setText("Changes saved.");
            dataBaseHandler.updateDeck(Main.player.getDeck(), Main.player.getUsername());
        }else {
            error.setText("You must select 8 cards!");
        }
    }
}
