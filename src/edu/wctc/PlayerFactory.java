package edu.wctc;

public class PlayerFactory {

    public PlayerFactory(){}

    /**
     * Returns a Player to be used by the BattleDriver.
     * @param weapon A string based on what the user entered at the start of Main. Determines the narration for the
     *               player's attack.
     * @param name   A string based on the what user entered for the name entry prompt in main.
     * @return a Player, which is then passed to the BattleDriver.
     */

    public Player create(String weapon, String name){
        if (weapon.equals("S")){
            return new Player(new WeaponSword(), name);
        }
        else if (weapon.equals("A")){
            return new Player(new WeaponAxe(), name);
        }
        else {
            return new Player(new WeaponSpear(), name);
        }
    }
}