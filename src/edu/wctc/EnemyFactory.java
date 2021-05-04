package edu.wctc;

import java.util.Random;

/**
 * Factory class for creating an enemy. When called, generates a random integer between one and four, and creates
 * one of the four enemy types based on the result. The returned enemy is passed from Main to the BattleDriver.
 */
public class EnemyFactory {

    public EnemyFactory(){}

    /**
     * When called by the BattleDriver, generates a random number between 1 and 4, and returns one of four possible
     * enemy types based on the random number's result.
     * @return an Enemy. Can be a bandit, sorcerer, dragon, or serpent. Each type of enemy implements the Enemy Interface,
     * which in turn implements the Being interface.
     */
    public Enemy create(){
        Random r = new Random();
        int lowerBound = 1;
        int upperBound = 4;
        int result = r.nextInt(upperBound-lowerBound) + lowerBound;

        if (result == 1){
            return new Bandit();
        }
        else if (result == 2){
            return new Sorcerer();
        }
        else if (result == 3 ){
            return new Dragon();
        }
        else {
            return new Serpent();
        }
    }
}
