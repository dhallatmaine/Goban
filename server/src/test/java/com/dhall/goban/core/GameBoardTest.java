package com.dhall.goban.core;

import com.dhall.goban.api.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameBoardTest {

    GameBoard gameBoard;

    @Before
    public void setup() {
        gameBoard = new GameBoard();
    }

    @Test
    public void testTurn() {
        gameBoard.makeMove(new Position(0,0, STONE.BLACK));
        assertEquals(STONE.WHITE, gameBoard.getTurn());
        assertEquals(1, gameBoard.totalStoneCount());

        gameBoard.makeMove(new Position(18, 18, STONE.WHITE));
        assertEquals(STONE.BLACK, gameBoard.getTurn());
        assertEquals(2, gameBoard.totalStoneCount());
    }

    @Test
    public void testOutOfOrderTurn() {
        gameBoard.makeMove(new Position(0, 0, STONE.WHITE));
        assertEquals(STONE.BLACK, gameBoard.getTurn());
        assertEquals(0, gameBoard.totalStoneCount());
    }

}
