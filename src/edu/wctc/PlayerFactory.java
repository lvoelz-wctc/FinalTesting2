package edu.wctc;

public class PlayerFactory {

    public PlayerFactory(){}

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