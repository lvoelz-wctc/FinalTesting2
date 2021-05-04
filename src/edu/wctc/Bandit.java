package edu.wctc;

public class Bandit implements Enemy {

    private String name = "Bandit";
    private String attack = "fires its crossbow!";
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
