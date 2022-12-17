package com.isep.rpg;

public class Potion extends Consumable {
    private int pointsPotion = 5;

    public Potion(String name) {
        super(name);
    }

    public Potion() {
        super("Potion");
    }

    public int getPtspotion() {
        return this.pointsPotion;
    }
}