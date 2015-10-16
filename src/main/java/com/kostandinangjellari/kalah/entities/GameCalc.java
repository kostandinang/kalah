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
     *
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
        /**
         * Count all stones for the current pit
         */
        if (currentPit.getStones() > 0) {
            long stoneNum = currentPit.getStones();
            /**
             * For each stone distribute to other pits except other player Kalah
             */
            for (int i = 1; i <= stoneNum; i++) {
                currentPit.setStones(currentPit.getStones() - 1);
                long nextPitNum = ((currentPit.getId() + i) % getTotalPitNumber());
                //TODO - Untested Functionality
                if (nextPitNum != 0) {
                    nextPit = game.getPits().get(nextPitNum);
                } else {
                    nextPit = game.getPits().get(getPlayerFirstPitId(activePlayer));
                    i++;
                    stoneNum++;
                }
                /**
                 * If the last stone is in an empty pit
                 * remove all other stones and other player
                 * parallell stones and send it to active player Kalah
                 */
                if (i == stoneNum) {
                    if (nextPit.isEmptyPit()) {
                        seedIntoPlayerKalah(nextPit, activePlayer);
                    }
                }
                Logger.getAnonymousLogger().info(String.valueOf(nextPit.getId()));
            }
        }
    }

    /**
     * Removes stones from player pit and parallell
     * other player pit and seeds them into player's Kalah
     * @param pit
     * @param player
     */
    private static void seedIntoPlayerKalah(Pit pit, Player player) {
        Pit playerKalah = getPlayerKalah(player);
        Pit otherPlayerParallellPit = getOtherPlayerParallellPit(pit, player);
        long otherPlayerStoneNumber = otherPlayerParallellPit.getStones();
        pit.emptyPit();
        otherPlayerParallellPit.emptyPit();
        playerKalah.setStones(otherPlayerStoneNumber + 1);
    }

    /**
     * Gets other player pit in parallell direction
     * with current pit
     * @param pit
     * @param player
     * @return
     */
    private static Pit getOtherPlayerParallellPit(Pit pit, Player player) {
        long pitNumber = pit.getId();
        return game.getPits().get(getTotalPitNumber() - pitNumber);
    }

    /**
     * Gets opponent of the given player
     * @param player
     * @return
     */
    private static Player getOtherPlayer(Player player) {
        return (player.equals(game.getPlayer1()) ? game.getPlayer2() : game.getPlayer1());
    }

    /**
     * Gets total Pit Number
     * @return
     */
    private static int getTotalPitNumber() {
        return GameConfig.PIT_NUMBER * 2 + 2;
    }

    /**
     * Checks if this pit is Kalah of the opponent
     * @param currentPlayer
     * @param pit
     * @return
     */
    public static boolean isOtherPlayerKalah(Player currentPlayer, Pit pit) {
        return (pit.isKalah() && (pit.getPlayer() != currentPlayer.getId()));
    }

    /**
     * Gets the first id of the player's pit
     * @param player
     * @return
     */
    public static long getPlayerFirstPitId(Player player) {
        return (player.getId() == 0) ? 1 : GameConfig.PIT_NUMBER + 2;
    }

    /**
     * Gets player Kalah
     * @param player
     * @return
     */
    public static Pit getPlayerKalah(Player player) {
        return (player.getId() == 0) ?
                game.getPits().get(GameConfig.PIT_NUMBER + 1) :
                game.getPits().get(getTotalPitNumber());
    }

}
