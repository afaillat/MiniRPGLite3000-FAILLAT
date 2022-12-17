package com.isep.rpg;

public class Weapon extends Item {
    String name;
    int hparme;
    int munition;
    String nameMun;

    public Weapon(String name, int hparme) {
        super(name, 10);
        this.name = name;
        this.hparme = hparme;
        this.munition = this.munition;
        this.nameMun = this.nameMun;
    }

    public int getDamagePts() {
        return this.hparme;
    }
}