package com.kostandinangjellari.kalah.services;

import com.kostandinangjellari.kalah.entities.GameRequest;
import com.kostandinangjellari.kalah.utils.JSONUtils;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Title: kalah
 * Author: Kostandin Angjellari
 * Date: 10/15/2015.
 * Copyright 2015
 */

@Path("/play")
public class KalahService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(
            @FormParam("game_request") String gameRequestJsonString
    ) {
        GameRequest gameRequest = JSONUtils.getGameRequestFromJson(gameRequestJsonString);
        //GameResponse gameResponse = KalahController.next(gameRequest);
        return Response.ok("{}").entity(String.class).build();
    }
}
