package com.isep.rpg;

public class Food extends Consumable {
    private int getPointLife = 10;

    public Food(String name) {
        super(name);
    }

    public Food() {
        super("Potion");
    }

    public int getGetPointLife() {
        return this.getPointLife;
    }
}
