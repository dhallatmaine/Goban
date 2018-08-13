package com.dhall.goban.core;

import com.dhall.goban.api.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibertyCounterTest {

    GameBoard gameBoard;
    STONE[][] board;

    @Before
    public void setup() {
        gameBoard = new GameBoard();
        board = gameBoard.getBoard();
    }

    @Test
    public void nonSurroundedCornerLiberties() {
        Position black = new Position(0, 0, STONE.BLACK);
        Move.make(gameBoard, black);
        int leftTopCorner = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(2, leftTopCorner);

        black = new Position(0, 18, STONE.BLACK);
        Move.make(gameBoard, black);
        int rightTopCorner = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(2, rightTopCorner);

        black = new Position(18, 0, STONE.BLACK);
        Move.make(gameBoard, black);
        int leftBottomCorner = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(2, leftBottomCorner);

        black = new Position(18, 18, STONE.BLACK);
        Move.make(gameBoard, black);
        int rightBottomCorner = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(2, rightBottomCorner);
    }

    @Test
    public void singleEnemyToTheLeft() {
        Move.make(gameBoard, new Position(5, 5, STONE.BLACK));
        Position white = new Position(6, 5, STONE.WHITE);
        Move.make(gameBoard, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyToTheRight() {
        Move.make(gameBoard, new Position(5, 5, STONE.BLACK));
        Position white = new Position(4, 5, STONE.WHITE);
        Move.make(gameBoard, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyAbove() {
        Move.make(gameBoard, new Position(5, 5, STONE.BLACK));
        Position white = new Position(5, 6, STONE.WHITE);
        Move.make(gameBoard, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyBelow() {
        Move.make(gameBoard, new Position(5, 5, STONE.BLACK));
        Position white = new Position(5, 4, STONE.WHITE);
        Move.make(gameBoard, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(3, liberties);
    }

    @Test
    public void enemiesLeftAndRight() {
        Move.make(gameBoard, new Position(5, 5, STONE.BLACK));
        Position white = new Position(6, 5, STONE.WHITE);
        Move.make(gameBoard, white);
        Move.make(gameBoard, new Position(7, 5, STONE.BLACK));
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals( 2, liberties);
    }

    @Test
    public void enemiesAboveAndBelow() {
        Move.make(gameBoard, new Position(5, 5, STONE.BLACK));
        Position white = new Position(5, 6, STONE.WHITE);
        Move.make(gameBoard, white);
        Move.make(gameBoard, new Position(5, 7, STONE.BLACK));
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(2, liberties);
    }

    @Test
    public void threeEnemies() {
        Move.make(gameBoard, new Position(4, 5, STONE.BLACK));
        Move.make(gameBoard, new Position(0, 0, STONE.WHITE));
        Move.make(gameBoard, new Position(5, 4, STONE.BLACK));
        Move.make(gameBoard, new Position(0, 1, STONE.WHITE));
        Move.make(gameBoard, new Position(6, 5, STONE.BLACK));
        Position white = new Position(5, 5, STONE.WHITE);
        Move.make(gameBoard, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(1, liberties);
    }

    @Test
    public void surrounded() {
        Move.make(gameBoard, new Position(4, 5, STONE.BLACK));
        Move.make(gameBoard, new Position(0, 0, STONE.WHITE));
        Move.make(gameBoard, new Position(5, 4, STONE.BLACK));
        Move.make(gameBoard, new Position(0, 1, STONE.WHITE));
        Move.make(gameBoard, new Position(6, 5, STONE.BLACK));
        Move.make(gameBoard, new Position(0, 2, STONE.WHITE));
        Move.make(gameBoard, new Position(5, 6, STONE.BLACK));
        Position white = new Position(5, 5, STONE.WHITE);
        Move.make(gameBoard, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(0, liberties);
    }

    @Test
    public void twoXConnectedLiberties() {
        Move.make(gameBoard, new Position(4, 5, STONE.BLACK));
        Move.make(gameBoard, new Position(0, 0, STONE.WHITE));
        Position black = new Position(5, 5, STONE.BLACK);
        Move.make(gameBoard, black);
        int liberties = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(6, liberties);
    }

    @Test
    public void twoYConnectedStones() {
        Move.make(gameBoard, new Position(5, 4, STONE.BLACK));
        Move.make(gameBoard, new Position(0, 0, STONE.WHITE));
        Position black = new Position(5, 5, STONE.BLACK);
        Move.make(gameBoard, black);
        int liberties = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(6, liberties);
    }

    @Test
    public void threeConnectedStones() {
        Move.make(gameBoard, new Position(4, 5, STONE.BLACK));
        Move.make(gameBoard, new Position(0, 0, STONE.WHITE));
        Move.make(gameBoard, new Position(5, 5, STONE.BLACK));
        Move.make(gameBoard, new Position(0, 1, STONE.WHITE));
        Position black = new Position(6, 5, STONE.BLACK);
        Move.make(gameBoard, black);
        int liberties = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(8, liberties);
    }

}
