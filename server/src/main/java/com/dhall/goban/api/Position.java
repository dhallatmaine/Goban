package com.dhall.goban.api;

import com.dhall.goban.core.COLORS;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Position {

    private int x;
    private int y;
    private COLORS color;

    public Position() { }

    public Position(int x, int y, COLORS color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @JsonProperty
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @JsonProperty
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @JsonProperty
    public COLORS getColor() {
        return color;
    }

    public void setColor(COLORS color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object that) {
        Position t = (Position) that;
        return this.x == t.x && this.y == t.y;
    }

}
