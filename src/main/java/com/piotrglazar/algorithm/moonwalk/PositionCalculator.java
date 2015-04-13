package com.piotrglazar.algorithm.moonwalk;

public class PositionCalculator {

    public Position calculatePosition(String rawMoves) {
        Position position = new Position();

        rawMoves.chars().mapToObj(Move::getMove).map(Move::getMovement).forEach(m -> m.move(position));

        return position;
    }
}
