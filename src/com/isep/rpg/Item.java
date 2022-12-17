package com.isep.rpg;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int i) {
    }

    public String getName() {
        return this.name;
    }
}