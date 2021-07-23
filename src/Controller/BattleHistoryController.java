package Controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.BattleHistory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BattleHistoryController implements Initializable, ControlledScreen {

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
    private Label mn1, mn2, mn3, on1, on2, on3, mr1, mr2, mr3, or1, or2, or3, d1, d2, d3;

    /**
     * get battle histories and show those in labels
     */
    private void updateHistories(){
        if (Main.player.getBattleHistories() == null){
            return;
        }
        ArrayList<BattleHistory> battleHistories = Main.player.getBattleHistories();
        if (battleHistories.size() > 0 ) {
            mn1.setText(Main.player.getUsername());
            on1.setText(battleHistories.get(0).getOpponent());
            mr1.setText(String.valueOf(battleHistories.get(0).getMyRes()));
            or1.setText(String.valueOf(battleHistories.get(0).getOppRes()));
            d1.setText(battleHistories.get(0).getDate().toString());
        }
        if (battleHistories.size() > 1) {
            mn2.setText(Main.player.getUsername());
            on2.setText(battleHistories.get(1).getOpponent());
            mr2.setText(String.valueOf(battleHistories.get(1).getMyRes()));
            or2.setText(String.valueOf(battleHistories.get(1).getOppRes()));
            d2.setText(battleHistories.get(1).getDate().toString());
        }
        if (battleHistories.size() > 2) {
            mn3.setText(Main.player.getUsername());
            on3.setText(battleHistories.get(2).getOpponent());
            mr3.setText(String.valueOf(battleHistories.get(2).getMyRes()));
            or3.setText(String.valueOf(battleHistories.get(2).getOppRes()));
            d3.setText(battleHistories.get(2).getDate().toString());
        }
    }

    /**
     * updates battle histories from data base
     */
    public void updateBattleHistories(MouseEvent mouseEvent) {
        updateHistories();
    }

    /**
     * back to menu when button pressed
     * @param event
     */
    @FXML
    public void backMenu(ActionEvent event) {
        myController.setScreen(Main.menu);
    }
}
