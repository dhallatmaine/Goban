package com.dhall.goban.core;

import com.dhall.goban.api.Position;
import com.google.inject.Singleton;

@Singleton
public class GameBoard {

    private STONE[][] board = new STONE[19][19];
    private STONE turn; // black goes first

    public GameBoard() {
        clearBoard();
        turn = STONE.BLACK;
    }

    public STONE[][] getBoard() {
        return board;
    }

    public void makeMove(Position position) {
        if (position.getColor().equals(getTurn())) {
            Move.make(board, position);
        } else {
            return;
        }

        if (position.getColor().equals(STONE.WHITE)) {
            turn = STONE.BLACK;
        } else {
            turn = STONE.WHITE;
        }
    }

    public int whiteStoneCount() {
        return getStoneCount(STONE.WHITE);
    }

    public int blackStoneCount() {
        return getStoneCount(STONE.BLACK);
    }

    public int totalStoneCount() {
        return whiteStoneCount() + blackStoneCount();
    }

    public STONE getTurn() {
        return turn;
    }

    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = STONE.E;
            }
        }
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
