package model.dataBase;

import application.Main;
import model.BattleHistory;
import model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Data base handler.
 */
public class DataBaseHandler {


    public static Statement statement;

    /**
     * Instantiates a new Data base handler.
     */
    public DataBaseHandler() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3307/clash_players";
        String username = "root";
        String password = "a13801234A";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * insert new username and password into data base
     *
     * @param username the username
     * @param password the password
     * @return the int to specify the result
     */
    public int sendInfo(String username, String password) {
        String s = "";
        String query = "INSERT INTO players (username, password) values ('" + username + "'," + password + ")";
        try {
            statement.execute(query);
            return 0;
        } catch (SQLIntegrityConstraintViolationException throwables) {
            throwables.printStackTrace();
            return 1;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return 2;
        }
    }

    /**
     * get username and password and checks those from data base.
     *
     * @param username1 the username
     * @param password1 the password
     * @return true if username and password are correct.
     */
    public boolean login(String username1, String password1) {
        String query = "SELECT * from players WHERE username='" + username1 + "'";
        try {
            boolean state = statement.execute(query);
            if (state) {
                ResultSet rs = statement.getResultSet();
                rs.next();
                String pass = rs.getString(2);
                return pass.equals(password1);
            } else {
                return false;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * get a user name and make an object from Player class.
     *
     * @param username1 the username
     * @return the player
     */
    public Player makePlayer(String username1) {
        String query = "SELECT * from players WHERE username='" + username1 + "'";
        try {
            boolean state = statement.execute(query);
            if (state) {
                ResultSet rs = statement.getResultSet();
                rs.next();
                String username = rs.getString(1);
                int xp = rs.getInt(3);
                int cup = rs.getInt(4);
                return new Player(username, cup, xp);
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /**
     * Gets deck.
     *
     * @param username1 the username
     * @return the deck
     */
    public ArrayList<String> getDeck(String username1) {
        String query = "SELECT * from players WHERE username='" + username1 + "'";
        try {
            boolean state = statement.execute(query);
            if (state) {
                ResultSet rs = statement.getResultSet();
                rs.next();
                String deck = rs.getString(5);
                if (deck == null) {
                    return null;
                }
                String[] array = deck.split(" ");
                return new ArrayList<>(Arrays.asList(array));
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /**
     * Update players deck from data base.
     *
     * @param deck1    the deck
     * @param username the username
     * @return true if updated successfully
     */
    public boolean updateDeck(ArrayList<String> deck1, String username) {
        StringBuilder deckToString = new StringBuilder();
        for (String s : deck1) {
            deckToString.append(s).append(" ");
        }
        String query = "UPDATE players SET deck = '" + deckToString + "' WHERE username = " + "'" + username + "'";
        try {
            statement.execute(query);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * Update battle deck .
     *
     * @param battleHistories the battle histories
     * @param username        the username
     * @return true if updated successfully
     */
    public boolean updateBattleDeck(ArrayList<BattleHistory> battleHistories, String username) {
        BattleHistory bh;
        String query;
        boolean state = true;
        if (battleHistories.size() > 0) {
            bh = battleHistories.get(0);
            String his1 = bh.getOpponent() + " " + bh.getMyRes() + " " + bh.getOppRes() + " " + bh.getDate();
            query = "UPDATE players SET history1 = '" + his1 + "' WHERE username = '" + username + "'";
            try {
                statement.execute(query);
            } catch (SQLException exception) {
                state = false;
                exception.printStackTrace();
            }
        }
        if (battleHistories.size() > 1) {
            bh = battleHistories.get(1);
            String his2 = bh.getOpponent() + " " + bh.getMyRes() + " " + bh.getOppRes() + " " + bh.getDate();
            query = "UPDATE players SET history1 = '" + his2 + "' WHERE username = '" + username + "'";
            try {
                statement.execute(query);
            } catch (SQLException exception) {
                state = false;
                exception.printStackTrace();
            }
        }
        if (battleHistories.size() > 2) {
            bh = battleHistories.get(2);
            String his3 = bh.getOpponent() + " " + bh.getMyRes() + " " + bh.getOppRes() + "" + bh.getDate();
            query = "UPDATE players SET history1 = '" + his3 + "' WHERE username = '" + username + "'";
            try {
                statement.execute(query);
            } catch (SQLException exception) {
                state = false;
                exception.printStackTrace();
            }
        }
        return state;
    }

    /**
     * Load history.
     *
     * @param username the username
     */
    public void loadHistory(String username) {
        String query = "SELECT * from players WHERE username='" + username + "'";
        try {
            boolean state = statement.execute(query);
            if (state) {
                ResultSet rs = statement.getResultSet();
                rs.next();
                String his1 = rs.getString(6);
                String his2 = rs.getString(7);
                String his3 = rs.getString(8);
                if (his1 != null) {
                    String[] array1 = his1.split(" ");
                    BattleHistory battleHistory1 = new BattleHistory(array1[0], Integer.parseInt(array1[1]), Integer.parseInt(array1[2]), Date.valueOf(array1[3]));
                    Main.player.addBattleHistory(battleHistory1);
                }
                if (his1 != null) {
                    String[] array2 = his2.split(" ");
                    BattleHistory battleHistory2 = new BattleHistory(array2[0], Integer.parseInt(array2[1]), Integer.parseInt(array2[2]), Date.valueOf(array2[3]));
                    Main.player.addBattleHistory(battleHistory2);
                }
                if (his1 != null) {
                    String[] array3 = his3.split(" ");
                    BattleHistory battleHistory3 = new BattleHistory(array3[0], Integer.parseInt(array3[1]), Integer.parseInt(array3[2]), Date.valueOf(array3[3]));
                    Main.player.addBattleHistory(battleHistory3);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
