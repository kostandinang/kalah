package com.kostandinangjellari.kalah.entities;

import java.util.ArrayList;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/18/2015.
 * Copyright 2015
 */

public class GameResponse {

    private ArrayList<House> houses;
    private long currentPlayerId;
    private long winnerPlayerId;

    public GameResponse(ArrayList<House> houses, long currentPlayerId, long winnerPlayerId) {
        this.houses = houses;
        this.currentPlayerId = currentPlayerId;
        this.winnerPlayerId = winnerPlayerId;
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public void setHouses(ArrayList<House> houses) {
        this.houses = houses;
    }

    public long getCurrentPlayerId() {
        return currentPlayerId;
    }

    public void setCurrentPlayerId(long currentPlayerId) {
        this.currentPlayerId = currentPlayerId;
    }

    public long getWinnerPlayerId() {
        return winnerPlayerId;
    }

    public void setWinnerPlayerId(long winnerPlayerId) {
        this.winnerPlayerId = winnerPlayerId;
    }
}
