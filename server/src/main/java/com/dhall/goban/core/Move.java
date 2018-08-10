package com.dhall.goban.core;

import com.dhall.goban.api.Position;

public class Move {

    public static void make(GameBoard gameBoard, Position position) {
        if (position.getColor().equals(gameBoard.getTurn())) {
            make(gameBoard, position.getX(), position.getY(), position.getColor());
        } else {
            return;
        }

        if (position.getColor().equals(STONE.WHITE)) {
            gameBoard.setTurn(STONE.BLACK);
        } else {
            gameBoard.setTurn(STONE.WHITE);
        }
    }

    private static void make(GameBoard gameBoard, int x, int y, STONE color) {
        STONE[][] board = gameBoard.getBoard();

        if (isEmptySpace(board, x, y)) {
            board[x][y] = color;
        }
    }

    public static boolean isEmptySpace(STONE[][] board, int x, int y) {
        return board[x][y].equals(STONE.E);
    }

}
