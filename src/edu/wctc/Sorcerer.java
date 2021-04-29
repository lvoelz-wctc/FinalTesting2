package edu.wctc;

public class Sorcerer implements Enemy{

    private String name = "Sorcerer";
    private String attack = "casts lightning!";
    private int health = 100;

    @Override
    public void damageHealth(int damage) {
        health = health-damage;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String enemyAttack() {
        return attack;
    }
}
