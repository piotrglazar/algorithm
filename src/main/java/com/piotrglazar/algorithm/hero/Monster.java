package com.piotrglazar.algorithm.hero;

public class Monster {

    private final int serialNumber;
    private final int power;
    private final int lifeBonus;

    public Monster(int serialNumber, int power, int lifeBonus) {
        this.serialNumber = serialNumber;
        this.power = power;
        this.lifeBonus = lifeBonus;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getPower() {
        return power;
    }

    public int getLifeBonus() {
        return lifeBonus;
    }
}
