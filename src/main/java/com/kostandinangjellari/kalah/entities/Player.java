package com.kostandinangjellari.kalah.entities;

import java.util.ArrayList;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

public class Player {

    private String name;
    private long id;

    public Player(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        Player otherPlayer = (Player) obj;
        return (this.id == otherPlayer.getId());
    }


    /**
     * Finds player by id in players array
     * @param players
     * @param playerId
     * @return
     */
    public static Player findPlayer(ArrayList<Player> players, long playerId) {
        for(Player player : players) {
            if (playerId == player.getId()) return player;
        }
        return null;
    }
}
