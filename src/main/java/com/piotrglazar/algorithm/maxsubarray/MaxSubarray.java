package com.piotrglazar.algorithm.maxsubarray;

import java.util.List;

public class MaxSubarray {

    private int currentMax;
    private int maxStart;
    private int maxEnd;
    private int currentSum = 0;
    private int currentStart = 0;

    public MaxSubarrayResult maximumSubarray(List<Integer> ints) {
        resetCounters();

        for (int i = 0; i < ints.size(); ++i) {
            int value = ints.get(i);
            if (value >= 0) {
                if (currentSum < 0) {
                    currentSum = value;
                    currentStart = i;
                } else {
                    currentSum += value;
                }
            } else {
                // save the end of current max if it is the greatest max
                if (currentSum > currentMax) {
                    maxEnd = i;
                    currentMax = currentSum;
                    maxStart = currentStart;
                }
                // continue, maybe it pays off to eat current negative value
                currentSum += value;
            }
        }

        confrontCurrentMaxWithAbsoluteMax(ints.size());

        return new MaxSubarrayResult(maxStart, maxEnd, currentMax);
    }

    private void confrontCurrentMaxWithAbsoluteMax(int size) {
        if (currentSum > currentMax) {
            currentMax = currentSum;
            maxStart = currentStart;
            maxEnd = size;
        }
    }

    private void resetCounters() {
        currentMax = 0;
        maxStart = 0;
        maxEnd = 0;
        currentSum = 0;
        currentStart = 0;
    }
}
