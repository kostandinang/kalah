package com.kostandinangjellari.kalah.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/18/2015.
 * Copyright 2015
 */

public class GameRequest {

    private ArrayList<House> houses;
    private ArrayList<Player> players;
    @SerializedName("current_house")
    long currentHouse;
    @SerializedName("current_player")
    long currentPlayer;

    public GameRequest(ArrayList<House> houses, ArrayList<Player> players, long currentHouse, long currentPlayer) {
        this.houses = houses;
        this.players = players;
        this.currentHouse = currentHouse;
        this.currentPlayer = currentPlayer;
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public void setHouses(ArrayList<House> houses) {
        this.houses = houses;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public long getCurrentHouse() {
        return currentHouse;
    }

    public void setCurrentHouse(long currentHouse) {
        this.currentHouse = currentHouse;
    }

    public long getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(long currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
