package com.kostandinangjellari.kalah.controllers;

import com.kostandinangjellari.kalah.constants.Keys;
import com.kostandinangjellari.kalah.entities.Game;
import com.kostandinangjellari.kalah.entities.GameCalc;
import com.kostandinangjellari.kalah.entities.Pit;
import com.kostandinangjellari.kalah.entities.Player;
import com.kostandinangjellari.kalah.utils.JSONUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

public class KalahController {

    /**
     * Builds the game and calculates next game state
     * @param gameStateJson
     * @return next game state json configuration
     */
    public static JSONObject next(JSONObject gameStateJson) {
        JSONObject gameStateResult = new JSONObject();
        Game game = initGameFromGameState(gameStateJson);
        /**
         * Get next game state
         */
        game = GameCalc.getNextGame(game);
        return gameStateResult;
    }

    private static Game initGameFromGameState(JSONObject iputGameJson) {
        Game game;
        /**
         * Get Pits
         */
        JSONArray pitsJsonArray = (JSONArray) iputGameJson.get(Keys.PITS);
        ArrayList<Pit> pits = JSONUtils.getPitsFromJson(pitsJsonArray);
        /**
         * Get players
         */
        JSONArray playersJsonArray = (JSONArray) iputGameJson.get(Keys.PLAYERS);
        Player player1 = JSONUtils.getPlayerFromJson(playersJsonArray, 0);
        Player player2 = JSONUtils.getPlayerFromJson(playersJsonArray, 1);
        /**
         * Create Game
         */
        game = new Game(player1, player2, pits);
        /**
         * Get Active Player
         */
        long activePlayer = (Long) iputGameJson.get(Keys.ACTIVE_PLAYER);
        game.setActivePlayer((activePlayer == 0) ? player1 : player2);
        /**
         * Set currentPit
         */
        long currentPitId = (Long) iputGameJson.get(Keys.CURRENT_PIT);
        game.setCurrentPit(Pit.getPitById(currentPitId, game.getPits()));
        return game;
    }

}
