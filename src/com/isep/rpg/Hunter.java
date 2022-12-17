package com.isep.rpg;

public class Hunter extends Hero {
    private Weapon sword = new Weapon("Epée", 10);
    private Weapon arrow = new Weapon("Flèche", 5);

    public Hunter(String n, int hp) {
        super(n, 50);
        this.name = n;
    }

    public void lostHp1(int damage) {
    }

    public void fight(Combatant combatant) {
        combatant.lostHp1(this.sword.getDamagePts());
    }

    public void throwArrow(Combatant combatant) {
        combatant.lostHp1(this.arrow.getDamagePts());
    }

    public int getDamagePoints() {
        return this.sword.getDamagePts();
    }
}


