package com.kostandinangjellari.kalah.utils;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */
public class JSONUtilsTest {

    @Test
    public void testGetJsonObjectFromJsonString() throws Exception {
        String jsonString = "{\"key\" : \"value\"}";
        JSONObject jsonObject = JSONUtils.getJsonObjectFromJsonString(jsonString);
        Assert.assertTrue(jsonObject.containsKey("key"));
    }
}