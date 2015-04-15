package com.piotrglazar.algorithm.moonwalk

import spock.lang.Specification
import spock.lang.Unroll

class StepVerifierTest extends Specification {

    StepVerifier stepVerifier = new StepVerifier(new PositionCalculator())

    @Unroll
    def "should verify that position #x #y will be reached for moves #rawMoves: #result"() {
        when:
        def canStepOnField = stepVerifier.canStepOnField(x, y, rawMoves)

        then:
        canStepOnField == result

        where:
         x  |  y  | rawMoves || result
         6  |  3  | "GGPPD"  || "TAK"
         5  |  3  | "GGPPD"  || "NIE"
         8  |  3  | "GGPPD"  || "NIE"
         0  |  0  | ""       || "TAK"
         3  |  0  | "GPPDP"  || "TAK"
         0  |  2  | "DPGLGG" || "TAK"
        -6  | -3  | "DLLPLG" || "NIE"
        -1  | -4  | "DLLPLG" || "NIE"
         1  |  2  | "GGPPD"  || "TAK"
         3  |  4  | "GGPPD"  || "NIE"
         0  |  0  | "GPDL"   || "TAK"
         0  |  4  | "PPGGLL" || "TAK"
         0  |  5  | "PPGGLL" || "NIE"
         4  |  0  | "GGPPDD" || "TAK"
         5  |  0  | "GGPPDD" || "NIE"
    }
}
