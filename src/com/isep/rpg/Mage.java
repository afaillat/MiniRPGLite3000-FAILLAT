package com.isep.rpg;

public class Mage extends SpellCaster {
    private Weapon weapon = new Weapon("Magie", 10);

    public Mage(String n, int hp, int mana) {
        super(n, 50, 10);
        this.name = this.name;
        this.mana = 10;
    }

    public void lostHp1(int damage) {
    }

    public void fight(Combatant combatant) {
        combatant.lostHp1(this.weapon.getDamagePts());
    }

    public void addMana(int n) {
        this.mana += n;
    }

    public int getMana() {
        return this.mana;
    }

    public int getDamagePoints() {
        return this.weapon.getDamagePts();
    }
}
