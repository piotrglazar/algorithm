package com.piotrglazar.algorithm.moonwalk

import spock.lang.Specification
import spock.lang.Unroll

class StepVerifierTest extends Specification {

    StepVerifier stepVerifier = new StepVerifier(new PositionCalculator())

    @Unroll
    def "should verify that position will be reached"() {
        when:
        def canStepOnField = stepVerifier.canStepOnField(x, y, rawMoves)

        then:
        canStepOnField == result

        where:
        x | y | rawMoves || result
        6 | 3 | "GGPPD"  || "TAK"
        5 | 3 | "GGPPD"  || "NIE"
        8 | 3 | "GGPPD"  || "NIE"
    }
}
