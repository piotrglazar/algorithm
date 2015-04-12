package com.piotrglazar.algorithm.puzzle

import spock.lang.Specification
import spock.lang.Unroll

class BoardTest extends Specification {

    @Unroll
    def "should find moves for empty board"() {
        given:
        Board board = new Board(m)

        when:
        def moves = board.nextMoves()

        then:
        moves == expectedMoves

        where:
        m || expectedMoves
        1 || [new Piece(0, 1, 0, 0)] as Set
        2 || [new Piece(0, 1, 0, 0), new Piece(0, 0, 0, 1)] as Set
    }

    def "should find move in the next column"() {
        given:
        Board board = new Board(2)
        board.makeMove(new Piece(0, 1, 0, 0))

        when:
        def moves = board.nextMoves()

        then:
        moves == [new Piece(2, 2, 0, 1), new Piece(0, 1, 1, 1)] as Set
    }

    def "should not find move"() {
        given:
        Board board = new Board(1)
        board.makeMove(new Piece(0, 1, 0, 0))

        when:
        def moves = board.nextMoves()

        then:
        moves == [] as Set
        board.boardAsString() == "N\nN\nF"
    }

    def "should be covered after moves"() {
        given:
        def moves = [
                new Piece(0, 0, 0, 1),
                new Piece(1, 1, 0, 1),
                new Piece(2, 2, 0, 1)
        ]
        Board board = new Board(2)

        when:
        moves.collect {
            board.makeMove(it)
        }

        then:
        board.isCovered()
        board.boardAsString() == "NN\nNN\nNN"
    }

    def "should properly make first move"() {
        given:
        Board board = new Board(2)

        when:
        board.makeMove(new Piece(0, 1, 0, 0))

        then:
        board.boardAsString() == "NF\nNF\nFF"
    }

    def "should be covered after moves found by itself"() {
        given:
        Board board = new Board(2)

        when:
        for (int i = 0; i < 3; ++i) {
            def moves = board.nextMoves()
            board.makeMove(moves.iterator().next())
        }

        then:
        board.isCovered()
        board.boardAsString() == "NN\nNN\nNN"
    }

    def "should undo move"() {
        given:
        Board board = new Board(2)
        Piece piece = new Piece(1, 2, 1, 1)
        board.makeMove(piece)

        when:
        board.undoMove(piece)

        then:
        board.boardAsString() == "FF\nFF\nFF"
    }
}
