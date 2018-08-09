package com.dhall.goban.core;

import com.dhall.goban.api.Position;
import com.google.inject.Singleton;

@Singleton
public class GameBoard {

    private COLORS[][] board = new COLORS[19][19];

    public GameBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = COLORS.E;
            }
        }
        board[0][0] = COLORS.WHITE;
        board[18][18] = COLORS.BLACK;
    }

    public COLORS[][] getBoard() {
        return board;
    }

    public void makeMove(Position position) {
        if (board[position.getX()][position.getY()].equals(COLORS.E)) {
            board[position.getX()][position.getY()] = position.getColor();
        }
    }

    public int whiteStoneCount() {
        return getStoneCount(COLORS.WHITE);
    }

    public int blackStoneCount() {
        return getStoneCount(COLORS.BLACK);
    }

    public boolean isEmptySpace(int x, int y) {
        return board[x][y].equals(COLORS.E);
    }

    private int getStoneCount(COLORS color) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(color)) {
                    count++;
                }
            }
        }
        return count;
    }

}
