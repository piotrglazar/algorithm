package com.piotrglazar.algorithm.puzzle;

import java.util.Objects;
import java.util.Set;

public class Solution {

    private final Set<Piece> pieces;

    private int cachedHash;

    public Solution(Set<Piece> pieces) {
        this.pieces = pieces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Solution solution = (Solution) o;
        for (Piece piece : pieces) {
            if (!solution.pieces.contains(piece)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (cachedHash == 0) {
            cachedHash = Objects.hash(pieces);
        }
        return cachedHash;
    }
}
