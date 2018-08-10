package com.dhall.goban.resources;

import com.dhall.goban.api.Position;
import com.dhall.goban.core.GameBoard;
import com.dhall.goban.core.Move;
import com.dhall.goban.core.STONE;
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
        gameBoard.getBoard()[0][0] = STONE.WHITE;
        gameBoard.getBoard()[18][18] = STONE.BLACK;
        return gameBoard;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public GameBoard move(Position position) {
        Move.make(gameBoard, position);
        return gameBoard;
    }

}
