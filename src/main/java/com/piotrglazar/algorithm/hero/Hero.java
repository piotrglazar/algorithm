package com.piotrglazar.algorithm.hero;

import com.google.common.collect.Lists;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class Hero {

    private int life;

    public BattleResult canWinBattle(int life, List<Monster> monsters) {
        this.life = life;
        PriorityQueue<Monster> goodMonsters = new PriorityQueue<>(Comparator.comparingInt(Monster::getPower));
        PriorityQueue<Monster> badMonsters = new PriorityQueue<>(Comparator.comparingInt(Monster::getPower).reversed());
        List<Integer> fightOrder = Lists.newLinkedList();

        setupMonsters(monsters, goodMonsters, badMonsters);

        boolean canWinWithGoodMonsters = canFightMonsters(goodMonsters, fightOrder);
        if (!canWinWithGoodMonsters) {
            return new BattleResult(BattleStatus.LOST, Collections.emptyList());
        }

        boolean canWinWithBadMonsters = canFightMonsters(badMonsters, fightOrder);
        if (!canWinWithBadMonsters) {
            return new BattleResult(BattleStatus.LOST, Collections.emptyList());
        }

        return new BattleResult(BattleStatus.WON, fightOrder);
    }

    private void setupMonsters(List<Monster> monsters, PriorityQueue<Monster> goodMonsters, PriorityQueue<Monster> badMonsters) {
        Map<Boolean, List<Monster>> monsterClassification = monsters.stream().collect(groupingBy(this::isGoodMonster));
        goodMonsters.addAll(monsterClassification.getOrDefault(Boolean.TRUE, Collections.emptyList()));
        badMonsters.addAll(monsterClassification.getOrDefault(Boolean.FALSE, Collections.emptyList()));
    }

    public boolean canFightMonsters(PriorityQueue<Monster> monsters, List<Integer> fightOrder) {
        while (!monsters.isEmpty()) {
            Monster m = monsters.poll();
            if (m.getPower() >= life) {
                return false;
            } else {
                fightOrder.add(m.getSerialNumber());
                life = life - m.getPower() + m.getLifeBonus();
            }
        }
        return true;
    }

    private boolean isGoodMonster(Monster monster) {
        return monster.getLifeBonus() > monster.getPower();
    }
}
