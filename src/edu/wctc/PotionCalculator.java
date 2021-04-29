package edu.wctc;

import java.util.Random;

public class PotionCalculator {

    public int calculatePotion(){
        Random r = new Random();
        int lowerBound = 5;
        int upperBound = 15;
        int result = r.nextInt(upperBound-lowerBound) + lowerBound;
        return result;
    }

}
