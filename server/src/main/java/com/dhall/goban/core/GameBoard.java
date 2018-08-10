package com.dhall.goban.core;

import com.dhall.goban.api.Position;
import com.google.inject.Singleton;

@Singleton
public class GameBoard {

    private STONE[][] board = new STONE[19][19];
    private STONE turn; // black goes first

    public GameBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = STONE.E;
            }
        }
        board[0][0] = STONE.WHITE;
        board[18][18] = STONE.BLACK;
        turn = STONE.BLACK;
    }

    public STONE[][] getBoard() {
        return board;
    }

    public void makeMove(Position position) {
        if (board[position.getX()][position.getY()].equals(STONE.E)) {
            board[position.getX()][position.getY()] = position.getColor();
        }
    }

    public int whiteStoneCount() {
        return getStoneCount(STONE.WHITE);
    }

    public int blackStoneCount() {
        return getStoneCount(STONE.BLACK);
    }

    public boolean isEmptySpace(int x, int y) {
        return board[x][y].equals(STONE.E);
    }

    public STONE getTurn() {
        return turn;
    }

    private int getStoneCount(STONE color) {
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
