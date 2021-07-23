package model;

import java.util.ArrayList;
import java.util.Set;

/**
 * The type Player.
 */
public class Player {

    private String username;
    private int cup;
    private String league;
    private int level;
    private int xp;
    private ArrayList<String> deck;
    private ArrayList<BattleHistory> battleHistories;

    /**
     * Instantiates a new Player.
     *
     * @param username the username
     * @param cup      the cup
     * @param xp       the xp
     */
    public Player(String username, int cup, int xp) {
        this.username = username;
        this.cup = cup;
        this.xp = xp;
        setLeague(cup);
        setLevel(xp);
    }

    private void setLeague(int cup){
        if (cup >= 0 && cup<= 300) {
            league = "Challenger I";
        }else if (cup <= 500){
            league = "Challenger II";
        }else if (cup <= 700){
            league = "Challenger III";
        }else if (cup <= 1000){
            league = "Master I";
        }else if (cup <= 1200){
            league = "Master II";
        }else {
            league = "Master III";
        }
    }

    private void setLevel(int xp){
        if (xp < 300){
            level = 1;
        }else if (xp < 500){
            level = 2;
        }else if (xp < 900){
            level = 3;
        }else if (xp < 1700){
            level = 4;
        }else {
            level = 5;
        }
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets cup.
     *
     * @param cup the cup
     */
    public void setCup(int cup) {
        this.cup = cup;
    }

    /**
     * Sets xp.
     *
     * @param xp the xp
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * Sets deck.
     *
     * @param deck the deck
     */
    public void setDeck(ArrayList<String> deck) {
        this.deck = deck;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets cup.
     *
     * @return the cup
     */
    public int getCup() {
        return cup;
    }

    /**
     * Gets league.
     *
     * @return the league
     */
    public String getLeague() {
        return league;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets xp.
     *
     * @return the xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * Gets deck.
     *
     * @return the deck
     */
    public ArrayList<String> getDeck() {
        return deck;
    }

    /**
     * Add battle history.
     *
     * @param battleHistory the battle history
     */
    public void addBattleHistory(BattleHistory battleHistory){
        if (battleHistories.size() == 3){
            battleHistories.remove(0);
        }
        battleHistories.add(battleHistory);
    }

    /**
     * Gets battle histories.
     *
     * @return the battle histories
     */
    public ArrayList<BattleHistory> getBattleHistories() {
        return battleHistories;
    }
}
