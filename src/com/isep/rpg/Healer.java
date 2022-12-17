package com.isep.rpg;

public class Healer extends SpellCaster {
    private Weapon weapon = new Weapon("Sort qui guéri", 9);

    public Healer(String nm, int hp, int mana) {
        super(nm, 50, 10);
        this.name = nm;
        this.mana = 10;
    }

    public void lostHp1(int damage) {
    }

    public void fight(Combatant combatant) {
        combatant.lostHp1(this.weapon.getDamagePts());
    }

    public int getDamagePoints() {
        return this.weapon.getDamagePts();
    }

    public void addMana(int n) {
        this.mana += n;
    }

    public int getMana() {
        return this.mana;
    }
}
