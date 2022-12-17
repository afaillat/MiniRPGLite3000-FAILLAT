package com.isep.rpg;

public abstract class Combatant {
    String name;
    private int healthPoint;
    private Weapon weapon;
    int mana;

    public Combatant(String nm, int hp, int mana) {
        this.name = nm;
        this.healthPoint = hp;
        this.mana = mana;
    }

    public void lostHp(int damage) {
        this.healthPoint -= damage;
    }

    public abstract void lostHp1(int var1);

    public abstract void fight(Combatant var1);

    public abstract int getDamagePoints();

    public String getName() {
        return this.name;
    }

    public int getHealthPoints() {
        return this.healthPoint;
    }

    public int getMana() {
        return this.mana;
    }

    public void addMana(int nm) {
        this.mana = nm;
    }

    public void win(int hp) {
        this.healthPoint += 6;
    }

    public void def(int pointsdevie) {
        this.healthPoint = 2 + pointsdevie;
    }

    public void consu(int pointsdevie) {
        this.healthPoint = 5 + pointsdevie;
    }

    public void Damage(int nm) {
        this.healthPoint -= nm;
        if (this.healthPoint <= 0) {
            int rest = 0 - this.healthPoint;
            this.healthPoint = 0;
            this.healthPoint -= rest;
            if (this.healthPoint <= 0) {
                this.healthPoint = 0;
            }
        }

    }
}
