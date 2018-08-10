package com.dhall.goban.core;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class GameBoard {

    private STONE[][] board = new STONE[19][19];
    private STONE turn;
    private Map<STONE, Integer> captures = new HashMap<>();

    public GameBoard() {
        clearBoard();

        // black goes first
        turn = STONE.BLACK;
        captures.put(STONE.WHITE, 0);
        captures.put(STONE.BLACK, 0);
    }

    public STONE[][] getBoard() {
        return board;
    }

    public STONE getTurn() {
        return turn;
    }

    public void setTurn(STONE turn) {
        this.turn = turn;
    }

    public Map<STONE, Integer> getCaptures() {
        return captures;
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
