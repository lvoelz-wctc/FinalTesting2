package edu.wctc;

import java.util.Random;

public class EnemyFactory {

    public EnemyFactory(){}

    public Enemy create(){
        Random r = new Random();
        int lowerBound = 1;
        int upperBound = 3;
        int result = r.nextInt(upperBound-lowerBound) + lowerBound;

        if (result == 1){
            return new Dragon();
        }
        else {
            return new Sorcerer();
        }
    }
}
