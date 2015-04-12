package com.piotrglazar.algorithm.moonwalk

import spock.lang.Specification
import spock.lang.Unroll

class PositionCalculatorTest extends Specification {

    PositionCalculator positionCalculator = new PositionCalculator()

    @Unroll
    def "should calculate total move for #rawMoves"() {
        when:
        def position = positionCalculator.calculatePosition(rawMoves)

        then:
        position.x == expectedX
        position.y == expectedY

        where:
        expectedX | expectedY || rawMoves
        2         | 1         || "GGPPD"
        2         | 1         || "DGPGP"
        -1        | -3        || "GPPDDLDLLD"
    }
}
