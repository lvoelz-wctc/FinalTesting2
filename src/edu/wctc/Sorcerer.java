package edu.wctc;

public class Sorcerer implements Enemy{

    private String name = "Sorcerer";
    private String attack = "casts lightning!";
    private int health = 100;

    /**
     * Reduces the sorcerer's health.
     * @param damage An integer passed from the randomly-generated value created by DamageCalculator.
     */
    @Override
    public void damageHealth(int damage) {
        health = health-damage;
    }

    /**
     * Returns the sorcerer's health.
     * @return The sorcerer's health.
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Returns the sorcerer's name.
     * @return The sorcerer's name.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns a string containing the enemy's attack. The BattleDriver combines this with getName() and additional text
     * to determine the overall attack narration.
     * @return
     */
    @Override
    public String enemyAttack() {
        return attack;
    }
}
