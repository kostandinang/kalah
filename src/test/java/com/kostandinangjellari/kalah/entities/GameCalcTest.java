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
public class GameCalcTest {

    @Test
    public void testGetNextGame() throws Exception {
        Player player1 = new Player("Kostandin", 0);
        Player player2 = new Player("Kostandin's Opponent", 1);
        Assert.assertTrue(GameCalc.isOtherPlayerKalah(player1, new Pit(0, 5, player2.getId(), true)));
    }

    @Test
    public void testGetNextGame1() throws Exception {

    }

    @Test
    public void testIsOtherPlayerKalah() throws Exception {

    }

    @Test
    public void testSeedStones() throws Exception {
        GameCalc.seedStones(getTestGame());
    }

    private Game getTestGame() {
        //Pits
        HashMap<Long, Pit> pits = new HashMap<>();
        pits.put(1l, new Pit(1, 15, 0, false));
        pits.put(2l, new Pit(2, 6, 0, false));
        pits.put(3l, new Pit(3, 6, 0, false));
        pits.put(4l, new Pit(4, 6, 0, false));
        pits.put(5l, new Pit(5, 6, 0, false));
        pits.put(6l, new Pit(6, 6, 0, false));
        pits.put(7l, new Pit(7, 0, 0, true));
        pits.put(8l, new Pit(8, 6, 1, false));
        pits.put(9l, new Pit(9, 6, 1, false));
        pits.put(10l, new Pit(10, 6,1, false));
        pits.put(11l, new Pit(11, 6, 1, false));
        pits.put(12l, new Pit(12, 6, 1, false));
        pits.put(13l, new Pit(13, 6, 1, false));
        pits.put(14l, new Pit(14, 0, 1, true));
        //Players
        Player player1 = new Player("Kostandin", 0);
        Player player2 = new Player("Opponent", 1);
        //Game
        Game game = new Game(player1, player2, pits);
        game.setActivePlayer(player1);
        game.setCurrentPit(pits.get(1l));
        return game;
    }
}