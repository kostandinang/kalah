package com.kostandinangjellari.kalah.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/13/2015.
 * Copyright 2015
 */

public class House {

    private long id;
    @SerializedName("player_id")
    private long playerId;
    @SerializedName("seeds")
    private long seeds;
    @SerializedName("is_kalah")
    private boolean isKalah;

    public House(long id, long seeds, long playerId, boolean isKalah) {
        this.id = id;
        this.playerId = playerId;
        this.seeds = seeds;
        this.isKalah = isKalah;
    }

    /**
     * Checks if house is empty
     *
     * @return true if house is empty
     */
    public boolean isEmptyHouse() {
        return (seeds == 0);
    }

    /**
     * Empties house
     */
    public void emptyHouse() {
        this.seeds = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlayer() {
        return playerId;
    }

    public void setPlayer(long player) {
        this.playerId = player;
    }

    public long getSeeds() {
        return seeds;
    }

    public void setSeeds(long seeds) {
        this.seeds = seeds;
    }

    public boolean isKalah() {
        return isKalah;
    }

    public void setIsKalah(boolean isKalah) {
        this.isKalah = isKalah;
    }

    /**
     * Gets houses Hash Map from houses Array
     *
     * @param houseList
     * @return
     */
    public static HashMap<Long, House> mapHouses(ArrayList<House> houseList) {
        HashMap<Long, House> houses = new HashMap<>();
        if (houseList != null && houseList.size() > 0) {
            for (House house : houseList) {
                houses.put(house.getId(), house);
            }
        }
        return houses;
    }
}
