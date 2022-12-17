package com.isep.rpg;

public abstract class SpellCaster extends Hero {
    public SpellCaster(String n, int hp, int mana) {
        super(n, 50);
        super.addItem(new Potion(), 3);
        super.addItem(new Potion(), 4);
    }
}
