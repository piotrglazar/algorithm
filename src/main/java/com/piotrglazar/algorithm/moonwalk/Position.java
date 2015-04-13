package com.piotrglazar.algorithm.moonwalk;

public class Position {

    private int x;
    private int y;

    public void moveUp() {
        ++y;
    }

    public void moveDown() {
        --y;
    }

    public void moveRight() {
        ++x;
    }

    public void moveLeft() {
        --x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
