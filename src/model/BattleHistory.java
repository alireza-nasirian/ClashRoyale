package model;

import java.util.Date;

/**
 * The type Battle history.
 */
public class BattleHistory {

    private String opponent;
    private int myRes;
    private int oppRes;
    private Date date;

    /**
     * Instantiates a new Battle history.
     *
     * @param opponent the opponent
     * @param me       the me
     * @param opp      the opp
     * @param date     the date
     */
    public BattleHistory(String opponent, int me, int opp, Date date){
        this.opponent = opponent;
        myRes = me;
        oppRes = opp;
        this.date = date;
    }

    /**
     * Gets opponent.
     *
     * @return the opponent
     */
    public String getOpponent() {
        return opponent;
    }

    /**
     * Gets my res.
     *
     * @return the my res
     */
    public int getMyRes() {
        return myRes;
    }

    /**
     * Gets opp res.
     *
     * @return the opp res
     */
    public int getOppRes() {
        return oppRes;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }
}
