package com.kostandinangjellari.kalah.controllers;

import com.kostandinangjellari.kalah.constants.JsonKeys;
import com.kostandinangjellari.kalah.entities.Game;
import com.kostandinangjellari.kalah.entities.House;
import com.kostandinangjellari.kalah.entities.Kalah;
import com.kostandinangjellari.kalah.entities.Player;
import com.kostandinangjellari.kalah.utils.JSONUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
     * @param gameInputJson
     * @return next game state json configuration
     */
    public static JSONObject next(JSONObject gameInputJson) {
        JSONObject gameStateResult = new JSONObject();
        Game game = initGameFromGameState(gameInputJson);
        /**
         * Get next game state
         */
        game = Kalah.getNextGame(game);
        //TODO - Generate gameOutputJson
        return gameStateResult;
    }

    private static Game initGameFromGameState(JSONObject iputGameJson) {
        Game game;
        /**
         * Get Pits
         */
        JSONArray pitsJsonArray = (JSONArray) iputGameJson.get(JsonKeys.HOUSES);
        HashMap<Long, House> pits = JSONUtils.getPitsFromJson(pitsJsonArray);
        /**
         * Get players
         */
        JSONArray playersJsonArray = (JSONArray) iputGameJson.get(JsonKeys.PLAYERS);
        Player player1 = JSONUtils.getPlayerFromJson(playersJsonArray, 0);
        Player player2 = JSONUtils.getPlayerFromJson(playersJsonArray, 1);
        /**
         * Create Game
         */
        game = new Game(player1, player2, pits);
        /**
         * Get Active Player
         */
        long activePlayer = (Long) iputGameJson.get(JsonKeys.ACTIVE_PLAYER);
        game.setActivePlayer((activePlayer == 0) ? player1 : player2);
        /**
         * Set currentPit
         */
        long currentPitId = (Long) iputGameJson.get(JsonKeys.CURRENT_HOUSE);
        game.setCurrentHouse(pits.get(currentPitId));
        return game;
    }

}
