package com.piotrglazar.algorithm.maxsubarray;

public class MaxSubarrayResult {

    private final int start;
    private final int end;
    private final int sum;

    public MaxSubarrayResult(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getSum() {
        return sum;
    }
}
