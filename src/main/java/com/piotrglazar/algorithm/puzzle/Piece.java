package com.piotrglazar.algorithm.puzzle;

import java.util.Objects;

public class Piece {

    private final int row1;
    private final int row2;
    private final int col1;
    private final int col2;

    private int cachedHash = 0;

    public Piece(int row1, int row2, int col1, int col2) {
        this.row1 = row1;
        this.row2 = row2;
        this.col1 = col1;
        this.col2 = col2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Piece piece = (Piece) o;
        return Objects.equals(row1, piece.row1) &&
                Objects.equals(row2, piece.row2) &&
                Objects.equals(col1, piece.col1) &&
                Objects.equals(col2, piece.col2);
    }

    @Override
    public int hashCode() {
        if (cachedHash == 0) {
            cachedHash = Objects.hash(row1, row2, col1, col2);
        }
        return cachedHash;
    }

    public int getRow1() {
        return row1;
    }

    public int getRow2() {
        return row2;
    }

    public int getCol1() {
        return col1;
    }

    public int getCol2() {
        return col2;
    }
}
