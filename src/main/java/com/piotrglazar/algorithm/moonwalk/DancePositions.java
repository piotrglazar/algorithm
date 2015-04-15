package com.piotrglazar.algorithm.moonwalk;

import java.util.List;

public class DancePositions {

    private final long x;
    private final long y;
    private final List<Position> positions;

    public DancePositions(long x, long y, List<Position> positions) {
        this.x = x;
        this.y = y;
        this.positions = positions;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public List<Position> getPositions() {
        return positions;
    }
}
