package com.piotrglazar.algorithm.moonwalk;

public class StepVerifier {

    private final PositionCalculator positionCalculator;

    public StepVerifier(PositionCalculator positionCalculator) {
        this.positionCalculator = positionCalculator;
    }

    public String canStepOnField(int x, int y, String rawMoves) {
        Position position = positionCalculator.calculatePosition(rawMoves);

        boolean result = canReachPosition(x, y, position);

        return convertResultToString(result);
    }

    private String convertResultToString(boolean result) {
        return result ? "TAK" : "NIE";
    }

    private boolean canReachPosition(int x, int y, Position position) {
        int positionX = position.getX();
        int positionY = position.getY();
        return canReach(x, positionX)
                && canReach(y, positionY)
                && numberOfStepsRequiredIsEqual(numberOfStepsRequired(x, positionX), numberOfStepsRequired(y, positionY));
    }

    private boolean numberOfStepsRequiredIsEqual(int s1, int s2) {
        return s1 == 0 || s2 == 0 || s1 == s2;
    }

    private boolean canReach(int expected, int actual) {
        return actual == 0 || expected % actual == 0;
    }

    private int numberOfStepsRequired(int expected, int actual) {
        return actual == 0 ? 0 : expected / actual;
    }
}
