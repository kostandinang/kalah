package com.kostandinangjellari.kalah.controllers;

import com.kostandinangjellari.kalah.entities.*;

import java.util.HashMap;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

public class KalahController {

    /**
     * Builds the game and calculates next game state
     *
     * @param gameRequest
     * @return next game state json configuration
     */
    public static GameResponse next(GameRequest gameRequest) {
        GameResponse gameResponse = null;
        Game game = initGameFromGameState(gameRequest);
        /**
         * Get next game state
         */
        game = Kalah.getNextGame(game);
        //TODO - Generate gameOutputJson
        return gameResponse;
    }

    private static Game initGameFromGameState(GameRequest gameRequest) {
        Game game;
        /**
         * Get Pits
         */
        HashMap<Long, House> houses = House.mapHouses(gameRequest.getHouses());
        /**
         * Get players
         */
        Player player1 = Player.findPlayer(gameRequest.getPlayers(), 0);
        Player player2 = Player.findPlayer(gameRequest.getPlayers(), 1);
        /**
         * Create Game
         */
        game = new Game(player1, player2, houses);
        /**
         * Get Active Player
         */
        long activePlayer = gameRequest.getCurrentPlayer();
        game.setActivePlayer((activePlayer == 0) ? player1 : player2);
        /**
         * Set current house
         */
        long currentHouseId = gameRequest.getCurrentHouse();
        game.setCurrentHouse(houses.get(currentHouseId));
        return game;
    }

}
