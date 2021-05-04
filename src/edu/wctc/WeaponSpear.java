package edu.wctc;

public class WeaponSpear implements WeaponStrategy{

    /**
     * Shows the player attacking with a spear. Part of the WeaponStrategy strategy pattern.
     * Defined on Player if the user chooses a spear at the start of the program in Main.
     * @return Text showing the player attacking with a spear.
     */
    @Override
    public String useWeapon() {
        return "You attack with your spear!";
    }
}
