package com.dhall.goban.core;

import com.dhall.goban.api.Position;

public class Capture {

    public static void capture(GameBoard gameBoard, Position position) {
        STONE color = position.getColor();
        if (color == STONE.E) {
            return;
        }

        STONE[][] board = gameBoard.getBoard();
        int x = position.getX();
        int y = position.getY();

        board[x][y] = STONE.E;

        if (x > 0 && board[x-1][y].equals(color)) {
            capture(gameBoard, new Position(x-1, y, color));
        }

        if (y < 18 && board[x][y+1].equals(color)) {
            capture(gameBoard, new Position(x, y+1, color));
        }

        if (x < 18 && board[x+1][y].equals(color)) {
            capture(gameBoard, new Position(x+1, y, color));
        }

        if (y > 0 && board[x][y-1].equals(color)) {
            capture(gameBoard, new Position(x, y-1, color));
        }

        int captures = gameBoard.getCaptures().get(color);
        gameBoard.getCaptures().put(color, captures + 1);
    }

}
