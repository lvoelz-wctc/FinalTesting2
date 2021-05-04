package edu.wctc;

/**
 * One of the four enemy types.
 */
public class Dragon implements Enemy{

    private String name = "Dragon";
    private String attack = "breathes fire!";
    private int health = 100;

    /**
     * Reduces the dragon's health.
     * @param damage An integer passed from the randomly-generated value created by DamageCalculator.
     */
    @Override
    public void damageHealth(int damage) {
        health = health-damage;
    }

    /**
     * Returns the dragon's health.
     * @return The dragon's health.
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Returns the dragon's name.
     * @return The dragon's name.
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
