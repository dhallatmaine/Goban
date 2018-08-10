package com.dhall.goban.core;

import com.dhall.goban.api.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibertyCounterTest {

    GameBoard gameBoard;

    @Before
    public void setup() {
        gameBoard = new GameBoard();
    }

    @Test
    public void nonSurroundedCornerLiberties() {
        Position black = new Position(0, 0, STONE.BLACK);
        gameBoard.makeMove(black);
        int leftTopCorner = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(2, leftTopCorner);
        gameBoard.clearBoard();

        black = new Position(0, 18, STONE.BLACK);
        gameBoard.makeMove(black);
        int rightTopCorner = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(2, rightTopCorner);
        gameBoard.clearBoard();

        black = new Position(18, 0, STONE.BLACK);
        gameBoard.makeMove(black);
        int leftBottomCorner = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(2, leftBottomCorner);
        gameBoard.clearBoard();

        black = new Position(18, 18, STONE.BLACK);
        gameBoard.makeMove(black);
        int rightBottomCorner = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(2, rightBottomCorner);
        gameBoard.clearBoard();
    }

    @Test
    public void singleEnemyToTheLeft() {
        gameBoard.makeMove(new Position(5, 5, STONE.WHITE));
        Position black = new Position(6, 5, STONE.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyToTheRight() {
        gameBoard.makeMove(new Position(5, 5, STONE.WHITE));
        Position black = new Position(4, 5, STONE.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyAbove() {
        gameBoard.makeMove(new Position(5, 5, STONE.WHITE));
        Position black = new Position(5, 6, STONE.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyBelow() {
        gameBoard.makeMove(new Position(5, 5, STONE.WHITE));
        Position black = new Position(5, 4, STONE.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(3, liberties);
    }

    @Test
    public void enemiesLeftAndRight() {
        gameBoard.makeMove(new Position(5, 5, STONE.WHITE));
        Position black = new Position(6, 5, STONE.BLACK);
        gameBoard.makeMove(new Position(7, 5, STONE.WHITE));
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals( 2, liberties);
    }

    @Test
    public void enemiesAboveAndBelow() {
        gameBoard.makeMove(new Position(5, 5, STONE.WHITE));
        Position black = new Position(5, 6, STONE.BLACK);
        gameBoard.makeMove(new Position(5, 7, STONE.WHITE));
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(2, liberties);
    }

    @Test
    public void threeEnemies() {
        gameBoard.makeMove(new Position(4, 5, STONE.WHITE));
        gameBoard.makeMove(new Position(5, 4, STONE.WHITE));
        gameBoard.makeMove(new Position(6, 5, STONE.WHITE));
        Position black = new Position(5, 5, STONE.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(1, liberties);
    }

    @Test
    public void surrounded() {
        gameBoard.makeMove(new Position(4, 5, STONE.WHITE));
        gameBoard.makeMove(new Position(5, 4, STONE.WHITE));
        gameBoard.makeMove(new Position(6, 5, STONE.WHITE));
        gameBoard.makeMove(new Position(5, 6, STONE.WHITE));
        Position black = new Position(5, 5, STONE.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(0, liberties);
    }

    @Test
    public void twoXConnectedLiberties() {
        gameBoard.makeMove(new Position(4, 5, STONE.WHITE));
        Position white = new Position(5, 5, STONE.WHITE);
        gameBoard.makeMove(white);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, white);
        assertEquals(6, liberties);
    }

    @Test
    public void twoYConnectedStones() {
        gameBoard.makeMove(new Position(5, 4, STONE.WHITE));
        Position white = new Position(5, 5, STONE.WHITE);
        gameBoard.makeMove(white);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, white);
        assertEquals(6, liberties);
    }

    @Test
    public void threeConnectedStones() {
        gameBoard.makeMove(new Position(4, 5, STONE.WHITE));
        gameBoard.makeMove(new Position(5, 5, STONE.WHITE));
        Position white = new Position(6, 5, STONE.WHITE);
        gameBoard.makeMove(white);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, white);
        assertEquals(8, liberties);
    }

}
