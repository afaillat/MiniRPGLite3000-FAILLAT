package com.isep.rpg;

public abstract class Hero extends Combatant {
    private Item[] combatant = new Item[5];

    public Hero(String n, int hp) {
        super(n, 50, 10);
        this.addItem(new Food(), 0);
        this.addItem(new Food(), 1);
        this.addItem(new Food(), 2);
    }

    public Item[] getCeCombant() {
        return this.combatant;
    }

    public void addItem(Item i, int placement) {
        this.combatant[placement] = i;
    }
}