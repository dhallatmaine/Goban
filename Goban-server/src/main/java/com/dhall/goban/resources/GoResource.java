package com.dhall.goban.resources;

import com.dhall.goban.api.Position;
import com.dhall.goban.core.GameBoard;
import com.google.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("go")
@Produces(MediaType.APPLICATION_JSON)
public class GoResource {

    @Inject
    private GameBoard gameBoard;

    @GET
    public GameBoard getBoardState() {
        return gameBoard;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public GameBoard move(Position position) {
        gameBoard.makeMove(position);
        return gameBoard;
    }

}
