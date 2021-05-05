package edu.wctc;

import static org.junit.Assert.*;
import org.junit.Test;

public class DamageCalculatorTest {

@Test
    public void testDamageCalculator(){
    DamageCalculator dc = new DamageCalculator();
    int damageRange = dc.calculateDamage();
    assertTrue("DamageCalculator returned an out of range value: " + damageRange, 5 <= damageRange && damageRange <=15);
}
}
