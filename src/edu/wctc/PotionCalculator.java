package edu.wctc;

import java.util.Random;

/**
 * Singleton class that generates a random integer between 10 and 15 and returns the result. This integer is used by
 * Player to determine the amount of health restored when a player chooses to drink a potion on their turn.
 */
public class PotionCalculator {

    private static PotionCalculator instance = new PotionCalculator();
    private PotionCalculator(){}

    /**
     * Returns a singleton instance of PotionCalculator for use in the BattleDriver
     * @return a singleton instance of PotionCalculator
     */
    public static PotionCalculator getInstance(){
        return instance;
    }

    /**
     * Generates a random integer between 15 and 20. When a player chooses to drink a potion, the BattleDriver
     * takes this number and adds it to the player's health.
     * @return a random integer between 15 and 20.
     */
    public int calculatePotion(){
        Random r = new Random();
        int lowerBound = 15;
        int upperBound = 20;
        int result = r.nextInt(upperBound-lowerBound) + lowerBound;
        return result;
    }

}
