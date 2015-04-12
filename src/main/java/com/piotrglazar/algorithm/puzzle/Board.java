package com.piotrglazar.algorithm.puzzle;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Board {

    private static final int N = 3;

    private final int m;
    private final boolean[][] board;
    private Set<Piece> pieces;
    private int cellsToCover;

    public Board(int m) {
        this.m = m;
        this.board = new boolean[N][];
        for (int i = 0; i < N; ++i) {
            this.board[i] = new boolean[m];
        }
        this.pieces = new HashSet<>();
        this.cellsToCover = N * m;
    }

    public Set<Piece> nextMoves() {
        Set<Piece> nextMoves = new HashSet<>();
        for (int col = 0; col < m; ++col) {
            for (int row = 0; row < N; ++row) {
                if (isFree(row, col)) {
                    goRight(row, col).ifPresent(nextMoves::add);
                    goDownHereOrInNextColumn(row, col).ifPresent(nextMoves::add);
                    return nextMoves;
                }
            }
        }

        return nextMoves;
    }

    private Optional<Piece> goRight(int row, int col) {
        if (col + 1 < m && isFree(row, col + 1)) {
            return Optional.of(new Piece(row, row, col, col + 1));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Piece> goDownHereOrInNextColumn(int row, int col) {
        if (row + 1 < N && isFree(row + 1, col)) {
            return Optional.of(new Piece(row, row + 1, col, col));
        } else if (col + 1 < m && isFree(0, col + 1) && isFree(1, col + 1)) {
            return Optional.of(new Piece(0, 1, col + 1, col + 1));
        } else {
            return Optional.empty();
        }
    }

    private boolean isFree(int row, int col) {
        return !board[row][col];
    }

    public boolean isCovered() {
        return cellsToCover == 0;
    }

    public void makeMove(Piece piece) {
        board[piece.getRow1()][piece.getCol1()] = true;
        board[piece.getRow2()][piece.getCol2()] = true;
        cellsToCover -= 2;
        pieces.add(piece);
    }

    public String boardAsString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < m; ++col) {
                if (isFree(row, col)) {
                    sb.append("F");
                } else {
                    sb.append("N");
                }
            }
            if (row != N - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void undoMove(Piece piece) {
        board[piece.getRow1()][piece.getCol1()] = false;
        board[piece.getRow2()][piece.getCol2()] = false;
        cellsToCover += 2;
        pieces.remove(piece);
    }

    public Set<Piece> getSolutionFingerPrint() {
        return new HashSet<>(pieces);
    }
}
