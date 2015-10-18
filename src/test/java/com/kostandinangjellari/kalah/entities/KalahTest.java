package com.kostandinangjellari.kalah.entities;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */
public class KalahTest {

    @Test
    public void testGetNextGame() throws Exception {
        Player player1 = new Player("Kostandin", 0);
        Player player2 = new Player("Kostandin's Opponent", 1);
        Assert.assertTrue(Kalah.isOtherPlayerKalah(player1, new House(0, 5, player2.getId(), true)));
    }

    @Test
    public void testGetNextGame1() throws Exception {

    }

    @Test
    public void testIsOtherPlayerKalah() throws Exception {

    }

    @Test
    public void testSeedStones() throws Exception {
        Kalah.sowSeeds(getTestGame());
    }

    /**
     * Gets a testing game configuration
     * @return Game
     */
    private Game getTestGame() {
        //Pits
        HashMap<Long, House> pits = new HashMap<>();
        pits.put(1l, new House(1, 6, 0, false));
        pits.put(2l, new House(2, 6, 0, false));
        pits.put(3l, new House(3, 6, 0, false));
        pits.put(4l, new House(4, 6, 0, false));
        pits.put(5l, new House(5, 6, 0, false));
        pits.put(6l, new House(6, 6, 0, false));
        pits.put(7l, new House(7, 0, 0, true));
        pits.put(8l, new House(8, 6, 1, false));
        pits.put(9l, new House(9, 6, 1, false));
        pits.put(10l, new House(10, 6, 1, false));
        pits.put(11l, new House(11, 6, 1, false));
        pits.put(12l, new House(12, 6, 1, false));
        pits.put(13l, new House(13, 6, 1, false));
        pits.put(14l, new House(14, 0, 1, true));
        //Players
        Player player1 = new Player("Kostandin", 0);
        Player player2 = new Player("Opponent", 1);
        //Game
        Game game = new Game(player1, player2, pits);
        game.setActivePlayer(player1);
        game.setCurrentHouse(pits.get(9l));
        return game;
    }
}