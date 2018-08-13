package com.dhall.goban.core;

import com.dhall.goban.api.Position;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaptureTest {

    GameBoard gameBoard;
    STONE[][] board;

    @Before
    public void setup() {
        gameBoard = new GameBoard();
        board = gameBoard.getBoard();
    }

    @Test
    public void testCornerCapture() {
        board[0][0] = STONE.WHITE;
        board[0][1] = STONE.BLACK;
        board[1][1] = STONE.BLACK;

        assertEquals(1, gameBoard.whiteStoneCount());
        Move.make(gameBoard, new Position(1, 0, STONE.BLACK));
        assertEquals(0, gameBoard.whiteStoneCount());
    }

    @Test
    public void testWallCapture() {
        board[1][0] = STONE.WHITE;
        board[0][0] = STONE.BLACK;
        board[1][1] = STONE.BLACK;

        assertEquals(1, gameBoard.whiteStoneCount());
        Move.make(gameBoard, new Position(2, 0, STONE.BLACK));
        assertEquals(0, gameBoard.whiteStoneCount());
    }

    @Test
    public void testOpenCapture() {
        board[1][1] = STONE.WHITE;
        board[0][1] = STONE.BLACK;
        board[1][0] = STONE.BLACK;
        board[2][1] = STONE.BLACK;

        assertEquals(1, gameBoard.whiteStoneCount());
        Move.make(gameBoard, new Position(1, 2, STONE.BLACK));
        assertEquals(0, gameBoard.whiteStoneCount());
    }

    @Test
    public void testMultipleCapture() {
        board[1][1] = STONE.WHITE;
        board[1][2] = STONE.WHITE;
        board[1][0] = STONE.BLACK;
        board[0][1] = STONE.BLACK;
        board[0][2] = STONE.BLACK;
        board[1][3] = STONE.BLACK;
        board[2][2] = STONE.BLACK;

        assertEquals(2, gameBoard.whiteStoneCount());
        Move.make(gameBoard, new Position(2, 1, STONE.BLACK));
        assertEquals(0, gameBoard.whiteStoneCount());
    }

    @Test
    public void testInsideCapture() {
        board[0][1] = STONE.WHITE;
        board[1][1] = STONE.WHITE;
        board[1][0] = STONE.WHITE;
        board[0][2] = STONE.BLACK;
        board[1][2] = STONE.BLACK;
        board[2][2] = STONE.BLACK;
        board[2][1] = STONE.BLACK;
        board[2][0] = STONE.BLACK;

        assertEquals(3, gameBoard.whiteStoneCount());
        Move.make(gameBoard, new Position(0, 0, STONE.BLACK));
        assertEquals(0, gameBoard.whiteStoneCount());
    }

}
