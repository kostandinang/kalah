package com.kostandinangjellari.kalah.entities;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

import com.kostandinangjellari.kalah.constants.GameConfig;
import com.kostandinangjellari.kalah.exceptions.InvalidMoveException;

import java.util.logging.Logger;

/**
 * Kalah processes game rules and logic and
 * calculates next game state
 */
public class Kalah {
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

    public static void sowSeeds(Game game) throws InvalidMoveException {
        Player activePlayer = game.getActivePlayer();
        House currentHouse = game.getCurrentHouse();
        long numOfSeeds = currentHouse.getNumberOfSeeds();
        House nextHouse;
        /**
         * For each seed distribute to other houses except other player Kalah
         */
        if (numOfSeeds > 0) {
            for (int i = 1; i <= numOfSeeds; i++) {
                currentHouse.setNumberOfSeeds(currentHouse.getNumberOfSeeds() - 1);
                long nextPitNum = ((currentHouse.getId() + i) % getTotalNumberOfHouses());
                //TODO - Untested Functionality
                if (nextPitNum != 0) {
                    nextHouse = game.getHouses().get(nextPitNum);
                } else {
                    nextHouse = game.getHouses().get(getPlayerFirstHouseId(activePlayer));
                    i++;
                    numOfSeeds++;
                }
                /**
                 * If the last seed is in an empty pit
                 * remove all other seeds and other player
                 * parallell seeds and send it to active player Kalah
                 */
                if (i == numOfSeeds) {
                    if (nextHouse.isEmptyHouse()) {
                        seedIntoPlayerKalah(nextHouse, activePlayer);
                    }
                }
                Logger.getAnonymousLogger().info(String.valueOf(nextHouse.getId()));
            }
            /**
             * Sets active player as winner if game has finished
             */
            if (hasGameFinished()) {
                game.setWinnerPlayer(activePlayer);
            }
        } else {
            throw new InvalidMoveException();
        }
    }

    /**
     * Checks if game has finished
     * @return true if player has empty pits, false otherwiase
     */
    private static boolean hasGameFinished() {
        boolean hasFinished = true;
        for (long pitId : game.getHouses().keySet()) {
            if (pitId < getPlayerKalah(game.getActivePlayer()).getId()) {
                if (!game.getHouses().get(pitId).isEmptyHouse()) {
                    hasFinished = false;
                    break;
                }
            }
        }
        return hasFinished;
    }

    /**
     * Removes seeds from player house and parallell
     * other player house and seeds them into player's Kalah
     *
     * @param house
     * @param player
     */
    private static void seedIntoPlayerKalah(House house, Player player) {
        House playerKalah = getPlayerKalah(player);
        House otherPlayerParallellHouse = getOtherPlayerParallellHouse(house, player);
        long otherPlayerStoneNumber = otherPlayerParallellHouse.getNumberOfSeeds();
        house.emptyHouse();
        otherPlayerParallellHouse.emptyHouse();
        playerKalah.setNumberOfSeeds(otherPlayerStoneNumber + 1);
    }

    /**
     * Gets other player house in parallell direction
     * with current house
     *
     * @param house
     * @param player
     * @return
     */
    private static House getOtherPlayerParallellHouse(House house, Player player) {
        long pitNumber = house.getId();
        return game.getHouses().get(getTotalNumberOfHouses() - pitNumber);
    }

    /**
     * Gets opponent of the given player
     *
     * @param player
     * @return
     */
    private static Player getOtherPlayer(Player player) {
        return (player.equals(game.getPlayer1()) ? game.getPlayer2() : game.getPlayer1());
    }

    /**
     * Gets total House Number
     *
     * @return
     */
    private static int getTotalNumberOfHouses() {
        return GameConfig.HOUSE_PER_PLAYER * 2 + 2;
    }

    /**
     * Checks if this house is Kalah of the opponent
     *
     * @param currentPlayer
     * @param house
     * @return
     */
    public static boolean isOtherPlayerKalah(Player currentPlayer, House house) {
        return (house.isKalah() && (house.getPlayer() != currentPlayer.getId()));
    }

    /**
     * Gets the first id of the player's house
     *
     * @param player
     * @return
     */
    public static long getPlayerFirstHouseId(Player player) {
        return (player.getId() == 0) ? 1 : GameConfig.HOUSE_PER_PLAYER + 2;
    }

    /**
     * Gets player Kalah
     *
     * @param player
     * @return
     */
    public static House getPlayerKalah(Player player) {
        return (player.getId() == 0) ?
                game.getHouses().get(GameConfig.HOUSE_PER_PLAYER + 1) :
                game.getHouses().get(getTotalNumberOfHouses());
    }

}
