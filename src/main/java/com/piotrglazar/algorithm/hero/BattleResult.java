package com.piotrglazar.algorithm.hero;

import java.util.List;

public class BattleResult {

    private final BattleStatus status;
    private final List<Integer> fightOrder;

    public BattleResult(BattleStatus status, List<Integer> fightOrder) {
        this.status = status;
        this.fightOrder = fightOrder;
    }

    public BattleStatus getStatus() {
        return status;
    }

    public List<Integer> getFightOrder() {
        return fightOrder;
    }
}
