package com.kostandinangjellari.kalah.entities;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/18/2015.
 * Copyright 2015
 */

public class GameResponse {

    private HashMap<Long, House> houses;
    @SerializedName("current_player")
    private long currentPlayerId;
    @SerializedName("winner")
    private long winnerPlayerId;
    private String message;

    public GameResponse(HashMap<Long, House> houses, long currentPlayerId, long winnerPlayerId) {
        this.houses = houses;
        this.currentPlayerId = currentPlayerId;
        this.winnerPlayerId = winnerPlayerId;
    }

    public GameResponse() {

    }

    public HashMap<Long, House> getHouses() {
        return houses;
    }

    public void setHouses(HashMap<Long, House> houses) {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
