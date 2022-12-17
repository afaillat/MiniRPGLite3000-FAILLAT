package com.isep.rpg;

public class Warrior extends Hero {
    private Weapon weapon = new Weapon("Hâche", 10);

    public Warrior(String n, int hp) {
        super(n, hp);
    }

    public void lostHp1(int damage) {
    }

    public void fight(Combatant combatant) {
        combatant.lostHp1(this.weapon.getDamagePts());
    }

    public int getDamagePoints() {
        return this.weapon.getDamagePts();
    }
}