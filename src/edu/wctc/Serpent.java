package edu.wctc;

/**
 * One of the four enemy types.
 */
public class Serpent implements Enemy{
    private String name = "Serpent";
    private String attack = "summons lightning!";
    private int health = 100;

    /**
     * Reduces the serpent's health.
     * @param damage An integer passed from the randomly-generated value created by DamageCalculator.
     */
    @Override
    public void damageHealth(int damage) {
        health = health-damage;
    }

    /**
     * Returns the serpent's health.
     * @return The serpent's health.
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Returns the serpent's name.
     * @return The serpent's name.
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
