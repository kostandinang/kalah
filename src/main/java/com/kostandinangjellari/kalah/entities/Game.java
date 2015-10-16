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
    private Player winnerPlayer;
    private HashMap<Long, Pit> pits;
    private Pit currentPit;

    public Game(Player player1, Player player2, HashMap<Long, Pit> pits) {
        this.player1 = player1;
        this.player2 = player2;
        this.pits = pits;
        this.winnerPlayer = null;
    }

    /**
     * Set game players
     *
     * @param player1
     * @param player2
     */
    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
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

    public void setActivePlayer(Player player) {
        this.activePlayer = player;
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

    public void setCurrentPit(Pit pit) {
        this.currentPit = pit;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }
}
