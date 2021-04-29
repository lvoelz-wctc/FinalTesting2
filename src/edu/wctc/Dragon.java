package edu.wctc;

public class Dragon implements Enemy{

    private String name = "Dragon";
    private String attack = " breathes fire!";
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
