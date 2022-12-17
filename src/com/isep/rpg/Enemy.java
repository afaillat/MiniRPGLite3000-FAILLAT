package com.isep.rpg;

public abstract class Enemy extends Combatant {
    public Enemy(String n, int hp) {
        super(n, 50, 10);
    }

    public abstract void lostHp1(int var1);
}