package com.kostandinangjellari.kalah.entities;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/13/2015.
 * Copyright 2015
 */

public class House {

    private long id;
    private long playerId;
    private long numberOfSeeds;
    private boolean isKalah;

    public House(long id, long numberOfSeeds, long playerId, boolean isKalah) {
        this.id = id;
        this.playerId = playerId;
        this.numberOfSeeds = numberOfSeeds;
        this.isKalah = isKalah;
    }

    /**
     * Checks if house is empty
     *
     * @return true if house is empty
     */
    public boolean isEmptyHouse() {
        return (numberOfSeeds == 0);
    }

    /**
     * Empties house
     */
    public void emptyHouse() {
        this.numberOfSeeds = 0;
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

    public long getNumberOfSeeds() {
        return numberOfSeeds;
    }

    public void setNumberOfSeeds(long numberOfSeeds) {
        this.numberOfSeeds = numberOfSeeds;
    }

    public boolean isKalah() {
        return isKalah;
    }

    public void setIsKalah(boolean isKalah) {
        this.isKalah = isKalah;
    }
}
