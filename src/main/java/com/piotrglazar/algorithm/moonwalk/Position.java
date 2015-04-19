package com.piotrglazar.algorithm.moonwalk;

public class Position {

    private final long x;
    private final long y;

    public Position() {
        this(0, 0);
    }

    public Position(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public Position moveUp() {
        return new Position(x, y + 1);
    }

    public Position moveDown() {
        return new Position(x, y - 1);
    }

    public Position moveRight() {
        return new Position(x + 1, y);
    }

    public Position moveLeft() {
        return new Position(x - 1, y);
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
