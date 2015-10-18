package com.kostandinangjellari.kalah.utils;

import com.kostandinangjellari.kalah.constants.JsonKeys;
import com.kostandinangjellari.kalah.constants.GameStrings;
import com.kostandinangjellari.kalah.entities.Game;
import com.kostandinangjellari.kalah.entities.House;
import com.kostandinangjellari.kalah.entities.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

public class JSONUtils {

    /**
     * Gets Json Object from Json String
     *
     * @param jsonString
     * @return
     */
    public static JSONObject getJsonObjectFromJsonString(String jsonString) {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(jsonString);
        } catch (ParseException e) {
            Logger.getAnonymousLogger().severe(GameStrings.JSON_PARSE_ERROR);
        }
        return jsonObject;
    }

    /**
     * Gets player from Game State object
     *
     * @param playerJsonArray
     * @param playerNumber
     * @return
     */
    public static Player getPlayerFromJson(JSONArray playerJsonArray, long playerNumber) {
        Player player = null;
        if (playerJsonArray.size() > 0) {
            JSONObject playerJsonObject = (JSONObject) playerJsonArray.get((int) playerNumber);
            player = new Player(
                    (String) playerJsonObject.get(JsonKeys.NAME),
                    (Long) playerJsonObject.get(JsonKeys.ID)
            );
        }
        return player;
    }

    /**
     * Gets array of pits from json array object
     *
     * @param housesJsonArray
     * @return
     */
    public static HashMap<Long, House> getPitsFromJson(JSONArray housesJsonArray) {
        HashMap<Long, House> houses = new HashMap<>();
        if (housesJsonArray != null && housesJsonArray.size() > 0) {
            JSONObject houseJsonObject;
            Iterator iterator = housesJsonArray.iterator();
            while (iterator.hasNext()) {
                //Add house
                houseJsonObject = (JSONObject) iterator.next();
                long key = (Long) houseJsonObject.get(JsonKeys.ID);
                House house = new House(
                        key,
                        (Long) houseJsonObject.get(JsonKeys.SEEDS),
                        (Long) houseJsonObject.get(JsonKeys.PLAYER_ID),
                        (Boolean) houseJsonObject.get(JsonKeys.IS_KALAH)
                );
                houses.put(key, house);
            }
        }
        return houses;
    }

    /**
     * Gets JsonObject from game
     *
     * @param game
     * @return
     */
    public static JSONObject getJsonFromGame(Game game) {
        JSONObject resultJson = new JSONObject();
        //TODO - Add Game to Json response
        return resultJson;
    }
}
