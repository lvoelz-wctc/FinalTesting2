package edu.wctc;

import java.util.Random;

/**
 * Singleton class that generates a random integer between 5 and 15 and returns the result. This integer is used by
 * both Player and Enemy to determine the amount of damage dealt to the opposite entity's health.
 */
public class DamageCalculator {

    private static DamageCalculator instance = new DamageCalculator();

    private DamageCalculator(){}

    /**
     * Returns a singleton instance of DamageCalculator for use in the BattleDriver
     * @return a singleton instance of DamageCalculator
     */
    public static DamageCalculator getInstance(){
        return instance;
    }

    /**
     * Generates a random integer between 5 and 15. When a player or enemy attacks, the BattleDriver takes this number
     * and subtracts it from the target's health.
     * @return a random number between 5 and 15.
     */
    public int calculateDamage(){
        Random r = new Random();
        int lowerBound = 5;
        int upperBound = 15;
        int result = r.nextInt(upperBound-lowerBound) + lowerBound;
        return result;
    }
}
