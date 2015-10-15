package com.kostandinangjellari.kalah.utils;

import com.kostandinangjellari.kalah.constants.Keys;
import com.kostandinangjellari.kalah.constants.Logs;
import com.kostandinangjellari.kalah.entities.Pit;
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
     * @param jsonString
     * @return
     */
    public static JSONObject getJsonObjectFromJsonString(String jsonString) {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(jsonString);
        } catch (ParseException e) {
            Logger.getAnonymousLogger().severe(Logs.JSON_PARSE_ERROR);
        }
        return jsonObject;
    }

    /**
     * Gets player from Game State object
     * @param playerJsonArray
     * @param playerNumber
     * @return
     */
    public static Player getPlayerFromJson(JSONArray playerJsonArray, long playerNumber) {
        Player player = null;
        if (playerJsonArray.size() > 0) {
            JSONObject playerJsonObject = (JSONObject) playerJsonArray.get((int)playerNumber);
            player = new Player(
                    (String)playerJsonObject.get(Keys.NAME),
                    (Long) playerJsonObject.get(Keys.ID)
            );
        }
        return player;
    }

    /**
     * Gets array of pits from json array object
     * @param pitsJsonArray
     * @return
     */
    public static HashMap<Long, Pit> getPitsFromJson(JSONArray pitsJsonArray) {
        HashMap<Long, Pit> pits = new HashMap<>();
        if (pitsJsonArray != null && pitsJsonArray.size() > 0) {
            JSONObject pitJsonObject;
            Iterator iterator = pitsJsonArray.iterator();
            while (iterator.hasNext()) {
                //Add pit
                pitJsonObject = (JSONObject) iterator.next();
                long key = (Long) pitJsonObject.get(Keys.ID);
                Pit pit = new Pit(
                        key,
                        (Long) pitJsonObject.get(Keys.STONES),
                        (Long) pitJsonObject.get(Keys.PLAYER_ID),
                        (Boolean) pitJsonObject.get(Keys.IS_KALAH)
                );
                pits.put(key, pit);
            }
        }
        return pits;
    }
}
