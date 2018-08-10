package com.dhall.goban.core;

import com.dhall.goban.api.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameBoardTest {

    GameBoard gameBoard = new GameBoard();

    @Test
    public void makeMoveOnEmptySpace() {
        gameBoard.makeMove(new Position(0, 0, STONE.WHITE));

        assertEquals(1, (gameBoard.whiteStoneCount() + gameBoard.blackStoneCount()));
    }

    @Test
    public void makeMoveOnOccupiedSpace() {
        gameBoard.makeMove(new Position(0, 0, STONE.WHITE));
        gameBoard.makeMove(new Position(0, 0, STONE.WHITE));

        assertEquals(1, (gameBoard.whiteStoneCount() + gameBoard.blackStoneCount()));
    }

}
