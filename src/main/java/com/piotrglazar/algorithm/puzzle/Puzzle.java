package com.piotrglazar.algorithm.puzzle;

import java.util.HashSet;
import java.util.Set;

public class Puzzle {

    private Set<Solution> solutions;

    public int numberOfOptions(int m) {
        solutions = new HashSet<>();
        Board board = new Board(m);

        makeMoves(board, 0);

        return solutions.size();
    }

    private void makeMoves(Board board, int level) {
        if (board.isCovered()) {
            solutions.add(new Solution(board.getSolutionFingerPrint()));
            return;
        }
        Set<Piece> nextMoves = board.nextMoves();

        for (Piece p : nextMoves) {
            board.makeMove(p);
            makeMoves(board, level + 1);
            board.undoMove(p);
        }
    }
}
