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
        int leftTopCorner = LibertyCounter.getNumberOfLiberties(gameBoard, new Position(0, 0, COLORS.BLACK));
        assertEquals(2, leftTopCorner);

        int rightTopCorner = LibertyCounter.getNumberOfLiberties(gameBoard, new Position(0, 18, COLORS.BLACK));
        assertEquals(2, rightTopCorner);

        int leftBottomCorner = LibertyCounter.getNumberOfLiberties(gameBoard, new Position(18, 0, COLORS.BLACK));
        assertEquals(2, leftBottomCorner);

        int rightBottomCorner = LibertyCounter.getNumberOfLiberties(gameBoard, new Position(18, 18, COLORS.BLACK));
        assertEquals(2, rightBottomCorner);
    }

    @Test
    public void singleEnemyToTheLeft() {
        gameBoard.makeMove(new Position(5, 5, COLORS.WHITE));
        Position black = new Position(6, 5, COLORS.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyToTheRight() {
        gameBoard.makeMove(new Position(5, 5, COLORS.WHITE));
        Position black = new Position(4, 5, COLORS.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyAbove() {
        gameBoard.makeMove(new Position(5, 5, COLORS.WHITE));
        Position black = new Position(5, 6, COLORS.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(3, liberties);
    }

    @Test
    public void singleEnemyBelow() {
        gameBoard.makeMove(new Position(5, 5, COLORS.WHITE));
        Position black = new Position(5, 4, COLORS.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(3, liberties);
    }

    @Test
    public void enemiesLeftAndRight() {
        gameBoard.makeMove(new Position(5, 5, COLORS.WHITE));
        Position black = new Position(6, 5, COLORS.BLACK);
        gameBoard.makeMove(new Position(7, 5, COLORS.WHITE));
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals( 2, liberties);
    }

    @Test
    public void enemiesAboveAndBelow() {
        gameBoard.makeMove(new Position(5, 5, COLORS.WHITE));
        Position black = new Position(5, 6, COLORS.BLACK);
        gameBoard.makeMove(new Position(5, 7, COLORS.WHITE));
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(2, liberties);
    }

    @Test
    public void threeEnemies() {
        gameBoard.makeMove(new Position(4, 5, COLORS.WHITE));
        gameBoard.makeMove(new Position(5, 4, COLORS.WHITE));
        gameBoard.makeMove(new Position(6, 5, COLORS.WHITE));
        Position black = new Position(5, 5, COLORS.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(1, liberties);
    }

    @Test
    public void surrounded() {
        gameBoard.makeMove(new Position(4, 5, COLORS.WHITE));
        gameBoard.makeMove(new Position(5, 4, COLORS.WHITE));
        gameBoard.makeMove(new Position(6, 5, COLORS.WHITE));
        gameBoard.makeMove(new Position(5, 6, COLORS.WHITE));
        Position black = new Position(5, 5, COLORS.BLACK);
        gameBoard.makeMove(black);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, black);
        assertEquals(0, liberties);
    }

    @Test
    public void twoXConnectedLiberties() {
        gameBoard.makeMove(new Position(4, 5, COLORS.WHITE));
        Position white = new Position(5, 5, COLORS.WHITE);
        gameBoard.makeMove(white);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, white);
        assertEquals(6, liberties);
    }

    @Test
    public void twoYConnectedStones() {
        gameBoard.makeMove(new Position(5, 4, COLORS.WHITE));
        Position white = new Position(5, 5, COLORS.WHITE);
        gameBoard.makeMove(white);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, white);
        assertEquals(6, liberties);
    }

    @Test
    public void threeConnectedStones() {
        gameBoard.makeMove(new Position(4, 5, COLORS.WHITE));
        gameBoard.makeMove(new Position(5, 5, COLORS.WHITE));
        Position white = new Position(6, 5, COLORS.WHITE);
        gameBoard.makeMove(white);
        int liberties = LibertyCounter.getNumberOfLiberties(gameBoard, white);
        assertEquals(8, liberties);
    }

}
