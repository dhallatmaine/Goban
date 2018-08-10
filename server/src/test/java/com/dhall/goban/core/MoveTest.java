package com.dhall.goban.core;

import com.dhall.goban.api.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveTest {

    GameBoard gameBoard;
    STONE[][] board;

    @Before
    public void setup() {
        gameBoard = new GameBoard();
        board = gameBoard.getBoard();
    }

    @Test
    public void testTurn() {
        Move.make(gameBoard, new Position(0,0, STONE.BLACK));
        assertEquals(STONE.WHITE, gameBoard.getTurn());
        assertEquals(1, gameBoard.totalStoneCount());

        Move.make(gameBoard, new Position(18, 18, STONE.WHITE));
        assertEquals(STONE.BLACK, gameBoard.getTurn());
        assertEquals(2, gameBoard.totalStoneCount());
    }

    @Test
    public void testOutOfOrderTurn() {
        Move.make(gameBoard, new Position(0, 0, STONE.WHITE));
        assertEquals(STONE.BLACK, gameBoard.getTurn());
        assertEquals(0, gameBoard.totalStoneCount());
    }

    @Test
    public void makeMoveOnEmptySpace() {
        Move.make(gameBoard, new Position(0, 0, STONE.BLACK));

        assertEquals(1, gameBoard.totalStoneCount());
    }

    @Test
    public void makeMoveOnOccupiedSpace() {
        Move.make(gameBoard, new Position(0, 0, STONE.BLACK));
        Move.make(gameBoard, new Position(0, 0, STONE.WHITE));

        assertEquals(1, gameBoard.totalStoneCount());
    }

}
