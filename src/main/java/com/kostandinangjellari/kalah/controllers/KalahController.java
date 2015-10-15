package com.kostandinangjellari.kalah.controllers;

import com.kostandinangjellari.kalah.constants.Keys;
import com.kostandinangjellari.kalah.entities.Game;
import com.kostandinangjellari.kalah.entities.Pit;
import com.kostandinangjellari.kalah.entities.Player;
import com.kostandinangjellari.kalah.utils.JSONUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class KalahController {

    private static Game game;

    /**
     * Builds the game and calculates next game state
     * @param gameStateJson
     * @return next game state json configuration
     */
    public static JSONObject next(JSONObject gameStateJson) {
        JSONObject gameStateResult = new JSONObject();
        /**
         * Get Pits
         */
        JSONArray pitsJsonArray = (JSONArray) gameStateJson.get(Keys.PITS);
        ArrayList<Pit> pits = JSONUtils.getPitsFromJson(pitsJsonArray);
        /**
         * Get players
         */
        JSONArray playersJsonArray = (JSONArray) gameStateJson.get(Keys.PLAYERS);
        Player player1 = JSONUtils.getPlayerFromJson(playersJsonArray, (short) 0);
        Player player2 = JSONUtils.getPlayerFromJson(playersJsonArray, (short) 1);
        /**
         * Create Game
         */
        game = new Game(player1, player2, pits);
        /**
         * Get Active Player
         */
        short activePlayer = (Short) gameStateJson.get(Keys.ACTIVE_PLAYER);
        game.setActivePlayer((activePlayer == 0) ? player1 : player2);
        /**
         * Set currentPit
         */
        short currentPitId = (Short) gameStateJson.get(Keys.CURRENT_PIT);
        game.setCurrentPit(Pit.getPitById(currentPitId, game.getPits()));

        return gameStateResult;
    }

}
