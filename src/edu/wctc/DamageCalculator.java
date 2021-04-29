package edu.wctc;

import java.util.Random;

public class DamageCalculator {

    public int calculateDamage(){
        Random r = new Random();
        int lowerBound = 5;
        int upperBound = 15;
        int result = r.nextInt(upperBound-lowerBound) + lowerBound;
        return result;
    }
    //to extend this, we could do a DamageStrategy with subclasses for each monster, if we wanted to
    //customize damage types per monster.
}
