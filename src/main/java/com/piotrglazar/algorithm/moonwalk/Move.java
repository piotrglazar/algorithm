package com.piotrglazar.algorithm.moonwalk;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public enum Move {

    UP('G', Position::moveUp),
    DOWN('D', Position::moveDown),
    RIGHT('P', Position::moveRight),
    LEFT('L', Position::moveLeft);

    private static final Map<Integer, Move> movesByLetter = buildMovesMap();

    private static Map<Integer, Move> buildMovesMap() {
        return Arrays.stream(Move.values()).collect(toMap(Move::getLetterAsInt, Function.<Move>identity()));
    }

    public static Move getMove(Integer letter) {
        return movesByLetter.get(letter);
    }

    private final Character letter;
    private final Movement movement;

    Move(Character letter, Movement movement) {
        this.letter = letter;
        this.movement = movement;
    }

    public Integer getLetterAsInt() {
        return (int) letter;
    }

    public Movement getMovement() {
        return movement;
    }
}
