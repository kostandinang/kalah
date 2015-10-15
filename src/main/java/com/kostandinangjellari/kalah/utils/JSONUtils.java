package com.kostandinangjellari.kalah.utils;

import com.kostandinangjellari.kalah.constants.Keys;
import com.kostandinangjellari.kalah.constants.Logs;
import com.kostandinangjellari.kalah.entities.Pit;
import com.kostandinangjellari.kalah.entities.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

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
    public static Player getPlayerFromJson(JSONArray playerJsonArray, short playerNumber) {
        Player player = null;
        if (playerJsonArray.size() > 0) {
            JSONObject playerJsonObject = (JSONObject) playerJsonArray.get(playerNumber);
            player = new Player(
                    (String)playerJsonObject.get(Keys.NAME),
                    (Short) playerJsonObject.get(Keys.ID)
            );
        }
        return player;
    }

    /**
     * Gets array of pits from json array object
     * @param pitsJsonArray
     * @return
     */
    public static ArrayList<Pit> getPitsFromJson(JSONArray pitsJsonArray) {
        ArrayList<Pit> pits = new ArrayList<>();
        if (pitsJsonArray != null && pitsJsonArray.size() > 0) {
            JSONObject pitJsonObject;
            Iterator iterator = pitsJsonArray.iterator();
            while (iterator.hasNext()) {
                //Add pit
                pitJsonObject = (JSONObject) iterator.next();
                Pit pit = new Pit(
                        (Short) pitJsonObject.get(Keys.PIT_ID),
                        (Short) pitJsonObject.get(Keys.STONES),
                        (Short) pitJsonObject.get(Keys.PLAYER_ID),
                        (Boolean) pitJsonObject.get(Keys.IS_KALAH)
                );
                pits.add(pit);
            }
        }
        return pits;
    }
}
