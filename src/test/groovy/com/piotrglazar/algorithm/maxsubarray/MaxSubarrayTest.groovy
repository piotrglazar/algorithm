package com.piotrglazar.algorithm.maxsubarray

import spock.lang.Specification
import spock.lang.Unroll

class MaxSubarrayTest extends Specification {

    MaxSubarray maxSubarray = new MaxSubarray()

    @Unroll
    def "should count maximum subarray for #ints"() {
        when:
        def calculatedResult = maxSubarray.maximumSubarray(ints)

        then:
        with(calculatedResult) {
            it.sum == result
            it.start == start
            it.end == end
        }

        where:
        result || start | end | ints
        0      || 0     | 0   | []
        2      || 0     | 1   | [2]
        5      || 0     | 3   | [2, 2, 1]
        5      || 0     | 4   | [2, 2, 0, 1]
        5      || 0     | 6   | [2, 2, 0, 1, 0, 0]
        7      || 4     | 7   | [4, 1, -3, -3, 3, -2, 6]
        7      || 1     | 4   | [-3, 3, -2, 6, -8, 1, -3,]
    }
}
