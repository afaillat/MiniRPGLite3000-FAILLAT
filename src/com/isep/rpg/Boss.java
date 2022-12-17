package com.isep.rpg;

public class Boss extends Enemy {
    private Weapon weapon = new Weapon("Utilisation de sa force très puissante ", 10);
    private int hp;

    public Boss(String name, int hp) {
        super("Boss", 100);
    }

    public void lostHp1(int damage) {
        this.hp -= damage;
    }

    public void fight(Combatant combatant) {
    }

    public void win(int hp) {
        this.hp += 6;
    }

    public int getDamagePoints() {
        return this.weapon.getDamagePts();
    }
}

