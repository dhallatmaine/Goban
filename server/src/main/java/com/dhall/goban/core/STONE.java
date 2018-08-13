package com.dhall.goban.core;

public enum STONE {
    WHITE, BLACK, E;

    public static STONE opposite(STONE color) {
        if (WHITE.equals(color)) {
            return BLACK;
        } else if (BLACK.equals(color)) {
            return WHITE;
        }
        return E;
    }
}