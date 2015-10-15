package com.kostandinangjellari.kalah.entities;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

import com.kostandinangjellari.kalah.constants.GameConfig;

import java.util.logging.Logger;

/**
 * GameCalc processes game rules and logic and
 * calculates next game state
 */
public class GameCalc {
    private static Game game;
    /**
     * Based on input game configuration
     * and the usage of game rules and logic
     * calculates the next game
     * @param inputGame Input Game
     * @return Game Output Game
     */
    public static Game getNextGame(Game inputGame) {
        game = inputGame;
        Game outputGame = null;
        //TODO - Game logic goes here
        return outputGame;
    }

    public static void seedStones(Game game) {
        Player activePlayer = game.getActivePlayer();
        Pit currentPit = game.getCurrentPit();
        Pit nextPit;
        //Count all stones for the current pit
        if (currentPit.getStones() > 0) {
            long stoneNum = currentPit.getStones();
            //For each stone distribute to other pits except other player Kalah
            for (int i = 1; i <= stoneNum; i++) {
                long nextPitNumber = (currentPit.getId() + i) % getTotalPitNumber();
                if (nextPitNumber == 0) {
                    nextPit = game.getPits().get(getPlayerFirstPitId(activePlayer));
                } else {
                    nextPit = game.getPits().get(nextPitNumber);
                }
                //If Kalah is encountered continue with next pit
                if (isOtherPlayerKalah(activePlayer, nextPit)) {
                    nextPit = game.getPits().get(getPlayerFirstPitId(activePlayer));
                }
                nextPit.setStones(nextPit.getStones() + 1);
                currentPit.setStones(currentPit.getStones() - 1);
            }
        }
        Logger.getAnonymousLogger().info(game.toString());
    }

    private static Pit getNextPit(Pit currentPit, Player currentPlayer) {
        long currentPitId = currentPit.getId();
        long numberOfStones = currentPit.getStones();
        long result;

        int nextPits;

        return null;
    };

    private static int getTotalPitNumber() {
        return GameConfig.PIT_NUMBER * 2 + 2;
    }

    public static boolean isOtherPlayerKalah(Player currentPlayer, Pit pit) {
        return (pit.isKalah() && (pit.getPlayer() != currentPlayer.getId()));
    }

    public static long getPlayerFirstPitId(Player player) {
        return (player.getId() == 0) ? 1 : GameConfig.PIT_NUMBER + 2;
    }

}
