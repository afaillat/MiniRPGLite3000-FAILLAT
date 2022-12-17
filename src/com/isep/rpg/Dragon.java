package com.isep.rpg;

public class Dragon extends Enemy {
    private Weapon weapon = new Weapon("Crache du feu", 5);

    public Dragon(String n, int hp) {
        super(n, hp);
    }

    public void lostHp1(int damage) {
    }

    public void fight(Combatant combatant) {
        combatant.lostHp(this.weapon.getDamagePts());
    }

    public int getDamagePoints() {
        return this.weapon.getDamagePts();
    }
}
