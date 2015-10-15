package com.kostandinangjellari.kalah.entities;

import java.util.ArrayList;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/13/2015.
 * Copyright 2015
 */
public class Pit {

    private short id;
    private short playerId;
    private short stones;
    private boolean isKalah;

    public Pit(short id, short stones, short playerId, boolean isKalah) {
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
    public static Pit getPitById(short id, ArrayList<Pit> pits) {
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

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getPlayer() {
        return playerId;
    }

    public void setPlayer(short player) {
        this.playerId = player;
    }

    public short getStones() {
        return stones;
    }

    public void setStones(short stones) {
        this.stones = stones;
    }

    public boolean isKalah() {
        return isKalah;
    }

    public void setIsKalah(boolean isKalah) {
        this.isKalah = isKalah;
    }
}
