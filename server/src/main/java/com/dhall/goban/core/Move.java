package com.dhall.goban.core;

import com.dhall.goban.api.Position;

/**
 * Encapsulates logic for making a move, assumes the move is valid in terms of turn order and does not rotate turn
 * order. That logic needs to be completed by the client of this API.
 */
public class Move {

    public static void make(STONE[][] board, Position position) {
        int x = position.getX();
        int y = position.getY();
        STONE color = position.getColor();

        if (isEmptySpace(board, x, y)) {
            board[x][y] = color;
        }
    }

    public static boolean isEmptySpace(STONE[][] board, int x, int y) {
        return board[x][y].equals(STONE.E);
    }

}
