package com.piotrglazar.algorithm.hero

import spock.lang.Specification
import spock.lang.Unroll

import static com.piotrglazar.algorithm.hero.BattleStatus.LOST
import static com.piotrglazar.algorithm.hero.BattleStatus.WON

class HeroTest extends Specification {

    Hero hero = new Hero()

    @Unroll
    def "should fight monsters"() {
        given:
        def monsters = monsters(rawMonsters)

        when:
        def result = hero.canWinBattle(life, monsters)

        then:
        result.status == status
        result.fightOrder == order

        where:
        status  | order     || life | rawMonsters
        WON     | [2, 3, 1] || 5    | [m(3, 1), m(4, 8), m(8, 3)]
        LOST    | []        || 5    | [m(3, 4), m(7, 2), m(3, 1)]
        LOST    | []        || 6    | [m(4, 4), m(6, 2), m(4, 1)]
        LOST    | []        || 5    | [m(4, 5), m(6, 2), m(1, 0)]
        WON     | [1, 3, 2] || 6    | [m(3, 8), m(5, 7), m(4, 5)]
        LOST    | []        || 7    | [m(4, 2), m(3, 2), m(2, 0), m(2, 0)]
        LOST    | []        || 7    | [m(10, 11)]
    }

    List<Monster> monsters(List<Tuple2> rawMonsters) {
        int sequence = 0
        rawMonsters.collect {
            new Monster(++sequence, it.first, it.second)
        }
    }

    def m(int power, int life) {
        new Tuple2<>(power, life)
    }
}
