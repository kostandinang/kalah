package com.kostandinangjellari.kalah.entities;

import java.util.ArrayList;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/13/2015.
 * Copyright 2015
 */

public class Pit {

    private long id;
    private long playerId;
    private long stones;
    private boolean isKalah;

    public Pit(long id, long stones, long playerId, boolean isKalah) {
        this.id = id;
        this.playerId = playerId;
        this.stones = stones;
        this.isKalah = isKalah;
    }

    /**
     * Returns pit by Id
     *
     * @param id
     * @param pits
     * @return
     */
    public static Pit getPitById(long id, ArrayList<Pit> pits) {
        for (Pit pit : pits) {
            if (id == pit.getId()) {
                return pit;
            }
        }
        return null;
    }

    /**
     * Checks if pit is empty
     *
     * @return True if pit is empty
     */
    public boolean isEmptyPit() {
        return (stones == 0);
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

    public long getStones() {
        return stones;
    }

    public void setStones(long stones) {
        this.stones = stones;
    }

    public boolean isKalah() {
        return isKalah;
    }

    public void setIsKalah(boolean isKalah) {
        this.isKalah = isKalah;
    }
}
