package edu.wctc;

import java.util.Random;

//Try this as a singleton? Because we don't need multiple potionCalculators.

public class PotionCalculator {

    private static PotionCalculator instance = new PotionCalculator();
    private PotionCalculator(){}

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
