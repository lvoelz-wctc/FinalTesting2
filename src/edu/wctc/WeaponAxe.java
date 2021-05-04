package edu.wctc;

public class WeaponAxe implements WeaponStrategy{

    /**
     * Shows the player attacking with an axe. Part of the WeaponStrategy strategy pattern.
     * Defined on Player if the user chooses an axe. at the start of the program in Main.
     * @return Text showing the player attacking with an axe.
     */
    @Override
    public String useWeapon() {
        return "You attack with your axe!";
    }
}
