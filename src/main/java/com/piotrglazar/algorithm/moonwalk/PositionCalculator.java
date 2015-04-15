package com.piotrglazar.algorithm.moonwalk;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static java.util.stream.Collectors.toList;

public class PositionCalculator {

    public DancePositions calculatePosition(String rawMoves) {
        Position position = new Position();
        List<Position> allPositions = new LinkedList<>();
        allPositions.add(position);

        List<Movement> movements = rawMoves.chars().mapToObj(Move::getMove).map(Move::getMovement).collect(toList());
        for (Movement movement : movements) {
            position = movement.move(position);
            allPositions.add(position);
        }

        Position lastPosition = getLastPosition(allPositions);

        return new DancePositions(lastPosition.getX(), lastPosition.getY(), allPositions);
    }

    private Position getLastPosition(List<Position> allPositions) {
        ListIterator<Position> iterator = allPositions.listIterator(allPositions.size());
        return iterator.previous();
    }
}
