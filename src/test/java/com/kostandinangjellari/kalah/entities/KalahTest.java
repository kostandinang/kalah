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
        Game testGame = getTestGame();
        Game outputGame = Kalah.getNextGame(testGame);
        Assert.assertNotNull(outputGame);
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
        HashMap<Long, House> houses = new HashMap<>();
        houses.put(1l, new House(1, 0, 0, false));
        houses.put(2l, new House(2, 0, 0, false));
        houses.put(3l, new House(3, 0, 0, false));
        houses.put(4l, new House(4, 0, 0, false));
        houses.put(5l, new House(5, 6, 0, false));
        houses.put(6l, new House(6, 6, 0, false));
        houses.put(7l, new House(7, 6, 0, true));
        houses.put(8l, new House(8, 0, 1, false));
        houses.put(9l, new House(9, 0, 1, false));
        houses.put(10l, new House(10, 0, 1, false));
        houses.put(11l, new House(11, 0, 1, false));
        houses.put(12l, new House(12, 0, 1, false));
        houses.put(13l, new House(13, 1, 1, false));
        houses.put(14l, new House(14, 0, 1, true));
        //Players
        Player player1 = new Player("Kostandin", 0);
        Player player2 = new Player("Opponent", 1);
        //Game
        Game game = new Game(player1, player2, houses);
        game.setActivePlayer(player2);
        game.setCurrentHouse(houses.get(13l));
        return game;
    }
}