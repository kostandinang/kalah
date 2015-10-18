package com.kostandinangjellari.kalah.entities;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

import com.kostandinangjellari.kalah.constants.GameConfig;
import com.kostandinangjellari.kalah.exceptions.EmptyHouseException;
import com.kostandinangjellari.kalah.exceptions.GameOverException;

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
    public static Game getNextGame(Game inputGame) throws EmptyHouseException, GameOverException {
        game = inputGame;
        sowSeeds(game);
        return game;
    }

    /**
     * Main game algorithm which distributes seeds
     * into other houses while listening for game rules all the time
     * @param game
     * @throws EmptyHouseException
     */
    public static void sowSeeds(Game game) throws EmptyHouseException, GameOverException {
        Player activePlayer = game.getActivePlayer();
        Player outputActivePlayer = null;
        House currentHouse = game.getCurrentHouse();
        long numOfSeeds = currentHouse.getSeeds();
        long houseCount = 1;
        long startHouseId = currentHouse.getId();
        House nextHouse;
        long nextHouseId;
        /**
         * Set other player as active player
         */
        outputActivePlayer = getOtherPlayer(activePlayer);
        /**
         * For each seed distribute to other houses except other player Kalah
         */
        if (numOfSeeds > 0) {
            for (int i = 1; i <= numOfSeeds; i++) {
                /**
                 * Get next house id, when maximum number of houses reached, start from the first one
                 */
                nextHouseId = (startHouseId + houseCount) % (getTotalNumberOfHouses() + 1);
                if (nextHouseId == 0) {
                    nextHouseId = 1l;
                    houseCount++;
                }
                nextHouse = game.getHouses().get(nextHouseId);
                /**
                 * If house is other player Kalah, then start counting from current
                 * player first house id and reset the house counter
                 */
                if (isOtherPlayerKalah(activePlayer, nextHouse)) {
                    startHouseId = getPlayerFirstHouseId(activePlayer);
                    houseCount = 0;
                    nextHouse = game.getHouses().get(startHouseId);
                }
                houseCount++;
                nextHouse.addSeed();
                currentHouse.removeSeed();
                /**
                 * If the last seed is in an empty house follow two rules
                 */
                if (i == numOfSeeds) {
                    /**
                     * This player turn again
                     */
                    if (nextHouse.isKalah()) {
                        outputActivePlayer = activePlayer;
                    }
                    /**
                     * Remove all other seeds and other player
                     * parallel seeds and send it to active player Kalah
                     */
                    if (nextHouse.isEmptyHouse()) {
                        seedIntoPlayerKalah(nextHouse, activePlayer);
                    }
                }
            }
            /**
             * Sets active player as winner if game has finished
             */
            if (hasGameFinished()) {
                game.setWinnerPlayer(activePlayer);
                throw new GameOverException();
            }
            /**
             * Set other player as active
             */
            game.setActivePlayer(outputActivePlayer);
        } else {
            throw new EmptyHouseException();
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Checks if game has finished
     * @return true if player has empty pits, false otherwiase
     */
    private static boolean hasGameFinished() {
        for (long houseId : game.getHouses().keySet()) {
            if (houseId < getPlayerKalah(game.getActivePlayer()).getId()) {
                if (!game.getHouses().get(houseId).isEmptyHouse()) {
                    return false;
                }
            }
        }
        return true;
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
        long otherPlayerSeeds = otherPlayerParallellHouse.getSeeds();
        house.emptyHouse();
        otherPlayerParallellHouse.emptyHouse();
        playerKalah.setSeeds(playerKalah.getSeeds() + otherPlayerSeeds + 1);
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
        return game.getHouses().get(getTotalNumberOfHouses() - house.getId());
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
    private static long getTotalNumberOfHouses() {
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
                game.getHouses().get(new Long(GameConfig.HOUSE_PER_PLAYER + 1)) :
                game.getHouses().get(getTotalNumberOfHouses());
    }

}
