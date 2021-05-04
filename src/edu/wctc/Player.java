package edu.wctc;

public class Player implements Being, WeaponStrategy{

    private String name;
    private int health = 100;
    private WeaponStrategy weaponStrategy;

    public Player(WeaponStrategy weaponStrategy, String name){
        this.name=name;
        this.weaponStrategy = weaponStrategy;
    }

    public void healHealth(int heal) {
        int newHealth = health + heal;

        if (newHealth > 100){
            health = 100;
        }
        else {
            health = health+heal;
        }
        }



    @Override
    public void damageHealth(int damage) {
        health = health-damage;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String useWeapon() {
        return weaponStrategy.useWeapon();
    }
}
