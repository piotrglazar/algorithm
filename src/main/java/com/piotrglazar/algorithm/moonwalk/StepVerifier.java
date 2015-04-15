package com.piotrglazar.algorithm.moonwalk;

public class StepVerifier {

    private final PositionCalculator positionCalculator;

    public StepVerifier(PositionCalculator positionCalculator) {
        this.positionCalculator = positionCalculator;
    }

    public String canStepOnField(long x, long y, String rawMoves) {
        DancePositions dancePositions = positionCalculator.calculatePosition(rawMoves);

        boolean result = dancePositions.getPositions().stream()
                .map(position -> canReachPosition(x, y, position, dancePositions.getX(), dancePositions.getY()))
                .anyMatch(Boolean::booleanValue);

        return convertResultToString(result);
    }

    private String convertResultToString(boolean result) {
        return result ? "TAK" : "NIE";
    }

    private boolean canReachPosition(long x, long y, Position position, long deltaX, long deltaY) {
        long positionX = position.getX();
        long xDiff = x - positionX;
        long positionY = position.getY();
        long yDiff = y - positionY;

        return canReach(x, positionX, xDiff, deltaX)
                && canReach(y, positionY, yDiff, deltaY)
                && numberOfStepsRequiredIsEqual(numberOfStepsRequired(xDiff, deltaX), numberOfStepsRequired(yDiff, deltaY));
    }

    private boolean numberOfStepsRequiredIsEqual(double s1, double s2) {
        return s1 == 0.0 || s2 == 0.0 || s1 == s2;
    }

    private boolean canReach(long left, long right, long difference, long delta) {
        if (delta == 0) {
            return left == right;
        } else {
            return difference % delta == 0;
        }
    }

    private long numberOfStepsRequired(long expected, long actual) {
        return actual == 0 ? Long.MIN_VALUE : expected / actual;
    }
}
