package com.dhall.goban.core;

import com.dhall.goban.api.Position;

public class LibertyCounter {

    public static int getNumberOfLiberties(STONE[][] board, Position position) {
        boolean[][] checked = new boolean[19][19];
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[i].length; j++) {
                checked[i][j] = false;
            }
        }

        return checkLiberties(board, position.getX(), position.getY(), position.getColor(), 0, checked);
    }

    private static int checkLiberties(STONE[][] board, int x, int y, STONE color, int liberties, boolean[][] checked) {
        if (x > 0 && Move.isEmptySpace(board,x-1, y)) {
            liberties++;
        }

        if (y < 18 && Move.isEmptySpace(board, x, y+1)) {
            liberties++;
        }

        if (x < 18 && Move.isEmptySpace(board,x+1, y)) {
            liberties++;
        }

        if (y > 0 && Move.isEmptySpace(board, x, y-1)) {
            liberties++;
        }

        checked[x][y] = true;

        if (x > 0 && board[x-1][y].equals(color) && ! checked[x-1][y]) {
            liberties = checkLiberties(board, x-1, y, color, liberties, checked);
        }

        if (y < 18 && board[x][y+1].equals(color) && ! checked[x][y+1]) {
            liberties = checkLiberties(board, x, y+1, color, liberties, checked);
        }

        if (x < 18 && board[x+1][y].equals(color) && ! checked[x+1][y]) {
            liberties = checkLiberties(board, x+1, y, color, liberties, checked);
        }

        if (y > 0 && board[x][y-1].equals(color) && ! checked[x][y-1]) {
            liberties = checkLiberties(board, x, y-1, color, liberties, checked);
        }

        return liberties;
    }

}
