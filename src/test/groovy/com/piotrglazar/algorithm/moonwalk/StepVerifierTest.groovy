package com.piotrglazar.algorithm.moonwalk

import spock.lang.Specification
import spock.lang.Unroll

class StepVerifierTest extends Specification {

    StepVerifier stepVerifier = new StepVerifier(new PositionCalculator())

    @Unroll
    def "should verify that position #x #y will be reached for moves #rawMoves: #result for Q1"() {
        when:
        def canStepOnField = stepVerifier.canStepOnField(x, y, rawMoves)

        then:
        canStepOnField == result

        where:
         x  |  y  | rawMoves || result
         6  |  3  | "GGPPD"  || "TAK"
         5  |  3  | "GGPPD"  || "NIE"
         8  |  3  | "GGPPD"  || "NIE"
         1  |  2  | "GGPPD"  || "TAK"
         3  |  4  | "GGPPD"  || "NIE"
         2  |  2  | "GPDL"   || "NIE"
         3  |  2  | "GGPPDD" || "TAK"
    }

    @Unroll
    def "should verify that position #x #y will be reached for moves #rawMoves: #result for Q2"() {
        when:
        def canStepOnField = stepVerifier.canStepOnField(x, y, rawMoves)

        then:
        canStepOnField == result

        where:
         x  |  y  | rawMoves   || result
        -4  |  6  | "LLGGGDL"  || "NIE"
        -5  |  4  | "LLGGGDL"  || "TAK"
    }

    @Unroll
    def "should verify that position #x #y will be reached for moves #rawMoves: #result for Q4"() {
        when:
        def canStepOnField = stepVerifier.canStepOnField(x, y, rawMoves)

        then:
        canStepOnField == result

        where:
         x  |  y  | rawMoves   || result
         5  | -3  | "PPGDDDP"  || "TAK"
         5  | -5  | "LLGGGDL"  || "NIE"
    }

    @Unroll
    def "should verify that position #x #y will be reached for moves #rawMoves: #result for Q3"() {
        when:
        def canStepOnField = stepVerifier.canStepOnField(x, y, rawMoves)

        then:
        canStepOnField == result

        where:
         x  |  y  | rawMoves || result
        -6  | -3  | "DLLPLG" || "NIE"
        -1  | -4  | "DLLPLG" || "NIE"
        -1  | -1  | "GPDL"   || "NIE"
    }

    @Unroll
    def "should verify that position #x #y will be reached for moves #rawMoves: #result for axes"() {
        when:
        def canStepOnField = stepVerifier.canStepOnField(x, y, rawMoves)

        then:
        canStepOnField == result

        where:
         x  |  y  | rawMoves || result
        -4  |  0  | "GLLD"   || "TAK"
        -5  |  0  | "GLLD"   || "NIE"
         0  | -9  | "PDDDL"  || "TAK"
         0  | -5  | "PDDDL"  || "NIE"
         0  |  0  | ""       || "TAK"
         3  |  0  | "GPPDP"  || "TAK"
         0  |  2  | "DPGLGG" || "TAK"
         0  |  0  | "LDGP"   || "TAK"
         0  |  4  | "PPGGLL" || "TAK"
         0  |  5  | "PPGGLL" || "NIE"
         4  |  0  | "GGPPDD" || "TAK"
         5  |  0  | "GGPPDD" || "NIE"
    }

    @Unroll
    def "should verify that position #x #y will be reached for moves #rawMoves: #result for closed moves"() {
        when:
        def canStepOnField = stepVerifier.canStepOnField(x, y, rawMoves)

        then:
        canStepOnField == result

        where:
         x  |  y  | rawMoves       || result
         1  |  1  | "PPPGGGLLLDDD" || "NIE"
         6  |  6  | "PPPGGGLLLDDD" || "NIE"
         3  |  3  | "PPPGGGLLLDDD" || "TAK"
         0  |  0  | "PPPGGGLLLDDD" || "TAK"
        -1  | -1  | "LLLDDDPPPGGG" || "NIE"
        -6  | -6  | "LLLDDDPPPGGG" || "NIE"
        -3  | -3  | "LLLDDDPPPGGG" || "TAK"
         0  |  0  | "LLLDDDPPPGGG" || "TAK"
    }
}
