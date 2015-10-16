package com.kostandinangjellari.kalah.entities;

import java.util.HashMap;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

public class Game {

    private Player player1;
    private Player player2;
    private Player activePlayer;
    private HashMap<Long, Pit> pits;
    private Pit currentPit;
    private boolean isFinished;


    public Game(Player player1, Player player2, HashMap<Long, Pit> pits) {
        this.player1 = player1;
        this.player2 = player2;
        this.pits = pits;
        isFinished = false;
    }

    /**
     * Set game players
     * @param player1
     * @param player2
     */
    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Sets active player
     * @param player
     */
    public void setActivePlayer(Player player) {
        this.activePlayer = player;
    }

    /**
     *
     * @param pit
     */
    public void setCurrentPit(Pit pit) {
        this.currentPit = pit;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public HashMap<Long, Pit> getPits() {
        return pits;
    }

    public void setPits(HashMap<Long, Pit> pits) {
        this.pits = pits;
    }

    public Pit getCurrentPit() {
        return currentPit;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
}
