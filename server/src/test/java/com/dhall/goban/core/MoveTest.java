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
    public void makeMoveOnEmptySpace() {
        Move.make(board, new Position(0, 0, STONE.WHITE));

        assertEquals(1, gameBoard.totalStoneCount());
    }

    @Test
    public void makeMoveOnOccupiedSpace() {
        Move.make(board, new Position(0, 0, STONE.WHITE));
        Move.make(board, new Position(0, 0, STONE.WHITE));

        assertEquals(1, gameBoard.totalStoneCount());
    }

}
