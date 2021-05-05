package edu.wctc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class PotionCalculatorTest {

    @Test
    public void testPotionCalculator(){
        PotionCalculator pc = new PotionCalculator();
        int potionRange = pc.calculatePotion();
        assertTrue("PotionCalculator returned an out of range value: " + potionRange,15 <= potionRange && potionRange <=20);
    }
}