package Controller;

/**
 * @author Alireza Nasirian
 * @version 1.0
 */
public interface ControlledScreen {

    /**
     * This method will allow the injection of the Parent ScreenPane
     * @param screenPage is parent screen
     */
    public void setScreenParent(ScreensController screenPage);
}
