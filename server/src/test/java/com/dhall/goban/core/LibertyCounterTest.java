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
        Move.make(board, black);
        int leftTopCorner = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(2, leftTopCorner);
        gameBoard.clearBoard();

        black = new Position(0, 18, STONE.BLACK);
        Move.make(board, black);
        int rightTopCorner = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(2, rightTopCorner);
        gameBoard.clearBoard();

        black = new Position(18, 0, STONE.BLACK);
        Move.make(board, black);
        int leftBottomCorner = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(2, leftBottomCorner);
        gameBoard.clearBoard();

        black = new Position(18, 18, STONE.BLACK);
        Move.make(board, black);
        int rightBottomCorner = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(2, rightBottomCorner);
        gameBoard.clearBoard();
    }

    @Test
    public void singleEnemyToTheLeft() {
        Move.make(board, new Position(5, 5, STONE.BLACK));
        Position white = new Position(6, 5, STONE.WHITE);
        Move.make(board, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyToTheRight() {
        Move.make(board, new Position(5, 5, STONE.BLACK));
        Position white = new Position(4, 5, STONE.WHITE);
        Move.make(board, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyAbove() {
        Move.make(board, new Position(5, 5, STONE.BLACK));
        Position white = new Position(5, 6, STONE.WHITE);
        Move.make(board, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyBelow() {
        Move.make(board, new Position(5, 5, STONE.BLACK));
        Position white = new Position(5, 4, STONE.WHITE);
        Move.make(board, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(3, liberties);
    }

    @Test
    public void enemiesLeftAndRight() {
        Move.make(board, new Position(5, 5, STONE.BLACK));
        Position white = new Position(6, 5, STONE.WHITE);
        Move.make(board, new Position(7, 5, STONE.BLACK));
        Move.make(board, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals( 2, liberties);
    }

    @Test
    public void enemiesAboveAndBelow() {
        Move.make(board, new Position(5, 5, STONE.WHITE));
        Position black = new Position(5, 6, STONE.BLACK);
        Move.make(board, new Position(5, 7, STONE.WHITE));
        Move.make(board, black);
        int liberties = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(2, liberties);
    }

    @Test
    public void threeEnemies() {
        Move.make(board, new Position(4, 5, STONE.WHITE));
        Move.make(board, new Position(5, 4, STONE.WHITE));
        Move.make(board, new Position(6, 5, STONE.WHITE));
        Position black = new Position(5, 5, STONE.BLACK);
        Move.make(board, black);
        int liberties = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(1, liberties);
    }

    @Test
    public void surrounded() {
        Move.make(board, new Position(4, 5, STONE.WHITE));
        Move.make(board, new Position(5, 4, STONE.WHITE));
        Move.make(board, new Position(6, 5, STONE.WHITE));
        Move.make(board, new Position(5, 6, STONE.WHITE));
        Position black = new Position(5, 5, STONE.BLACK);
        Move.make(board, black);
        int liberties = LibertyCounter.getNumberOfLiberties(board, black);
        assertEquals(0, liberties);
    }

    @Test
    public void twoXConnectedLiberties() {
        Move.make(board, new Position(4, 5, STONE.WHITE));
        Position white = new Position(5, 5, STONE.WHITE);
        Move.make(board, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(6, liberties);
    }

    @Test
    public void twoYConnectedStones() {
        Move.make(board, new Position(5, 4, STONE.WHITE));
        Position white = new Position(5, 5, STONE.WHITE);
        Move.make(board, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(6, liberties);
    }

    @Test
    public void threeConnectedStones() {
        Move.make(board, new Position(4, 5, STONE.WHITE));
        Move.make(board, new Position(5, 5, STONE.WHITE));
        Position white = new Position(6, 5, STONE.WHITE);
        Move.make(board, white);
        int liberties = LibertyCounter.getNumberOfLiberties(board, white);
        assertEquals(8, liberties);
    }

}
