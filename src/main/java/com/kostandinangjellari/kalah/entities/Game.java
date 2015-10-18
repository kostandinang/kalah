package com.kostandinangjellari.kalah.entities;

import java.util.HashMap;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

public class Game {

    private Player p1;
    private Player p2;
    private Player activePlayer;
    private Player winnerPlayer;
    private HashMap<Long, House> houses;
    private House currentHouse;

    public Game(Player p1, Player p2, HashMap<Long, House> houses) {
        this.p1 = p1;
        this.p2 = p2;
        this.houses = houses;
        this.winnerPlayer = null;
    }

    /**
     * Set game players
     *
     * @param player1
     * @param player2
     */
    public void setPlayers(Player player1, Player player2) {
        this.p1 = player1;
        this.p2 = player2;
    }

    public Player getPlayer1() {
        return p1;
    }

    public void setPlayer1(Player p1) {
        this.p1 = p1;
    }

    public Player getPlayer2() {
        return p2;
    }

    public void setPlayer2(Player p2) {
        this.p2 = p2;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player player) {
        this.activePlayer = player;
    }

    public HashMap<Long, House> getHouses() {
        return houses;
    }

    public void setHouses(HashMap<Long, House> houses) {
        this.houses = houses;
    }

    public House getCurrentHouse() {
        return currentHouse;
    }

    public void setCurrentHouse(House house) {
        this.currentHouse = house;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }
}
