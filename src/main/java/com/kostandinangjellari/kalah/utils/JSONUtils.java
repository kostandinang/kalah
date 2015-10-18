package com.kostandinangjellari.kalah.utils;

import com.google.gson.Gson;
import com.kostandinangjellari.kalah.entities.GameRequest;
import com.kostandinangjellari.kalah.entities.GameResponse;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

public class JSONUtils {

    /**
     * Get GameRequest from JsonString
     *
     * @param jsonString
     * @return
     */
    public static GameRequest getGameRequestFromJson(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, GameRequest.class);
    }

    /**
     * Gets GameResponse from json string
     *
     * @param jsonString
     * @return
     */
    public static GameResponse getGameResponseFromJsonString(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, GameResponse.class);
    }

    /**
     * Gets json from GameResponse object
     *
     * @param gameResponse
     * @return
     */
    public static String getJsonFromGameResponse(GameResponse gameResponse) {
        Gson gson = new Gson();
        return gson.toJson(gameResponse);
    }
}
