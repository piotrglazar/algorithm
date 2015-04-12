package com.piotrglazar.algorithm.puzzle

import spock.lang.Specification
import spock.lang.Unroll

class PuzzleContextTest extends Specification {

    Puzzle puzzle = new Puzzle()

    @Unroll
    def "should find solutions"() {
        expect:
        puzzle.numberOfOptions(m) == noOptions

        where:
        m || noOptions
        1 || 0
        2 || 3
        3 || 0
        4 || 11
    }
}
