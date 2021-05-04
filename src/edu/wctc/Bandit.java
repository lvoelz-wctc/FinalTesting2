package edu.wctc;

/**
 * One of the four enemy types.
 */
public class Bandit implements Enemy {

    private String name = "Bandit";
    private String attack = "fires its crossbow!";
    private int health = 100;

    /**
     * Reduces the bandit's health.
     * @param damage An integer passed from the randomly-generated value created by DamageCalculator.
     */
    @Override
    public void damageHealth(int damage) {
        health = health-damage;
    }

    /**
     * Returns the bandit's health.
     * @return The bandit's health.
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Returns the bandit's name.
     * @return The bandit's name.
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
