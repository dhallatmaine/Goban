package com.dhall.goban.core;

import com.dhall.goban.api.Position;

public class Move {

    public static void make(GameBoard gameBoard, Position position) {
        if (position.getColor().equals(gameBoard.getTurn())) {
            move(gameBoard, position);
        } else {
            return;
        }

        if (position.getColor().equals(STONE.WHITE)) {
            gameBoard.setTurn(STONE.BLACK);
        } else {
            gameBoard.setTurn(STONE.WHITE);
        }
    }

    private static void move(GameBoard gameBoard, Position position) {
        STONE[][] board = gameBoard.getBoard();
        int x = position.getX();
        int y = position.getY();
        STONE color = position.getColor();

        if (! isEmptySpace(board, x, y)) {
            return;
        }

        board[x][y] = color;

        if (x > 0) {
            Position left = new Position(x - 1, y, board[x - 1][y]);
            if (LibertyCounter.getNumberOfLiberties(board, left) == 0) {
                Capture.capture(gameBoard, left);
            }
        }

        if (y < 18) {
            Position below = new Position(x, y + 1, board[x][y + 1]);
            if (LibertyCounter.getNumberOfLiberties(board, below) == 0) {
                Capture.capture(gameBoard, below);
            }
        }

        if (x < 18) {
            Position right = new Position(x + 1, y, board[x + 1][y]);
            if (LibertyCounter.getNumberOfLiberties(board, right) == 0) {
                Capture.capture(gameBoard, right);
            }
        }

        if (y > 0) {
            Position above = new Position(x, y - 1, board[x][y - 1]);
            if (LibertyCounter.getNumberOfLiberties(board, above) == 0) {
                Capture.capture(gameBoard, above);
            }
        }
    }

    public static boolean isEmptySpace(STONE[][] board, int x, int y) {
        return board[x][y].equals(STONE.E);
    }

}
