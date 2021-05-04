package edu.wctc;

import java.util.Random;

public class BattleDriver {

    private Player player;
    private Enemy enemy;

    public BattleDriver(Player player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;
    }

    //Call the singleton PotionCalculator
    PotionCalculator pc = PotionCalculator.getInstance();

    //Call the singleton DamageCalculator
    DamageCalculator dc = DamageCalculator.getInstance();

    public String showEnemy() {return "You see a " + enemy.getName() + "!";}

    public String showAttack() {return "The " + enemy.getName() + " " + enemy.enemyAttack();}

    public int getPlayerHealth() {return player.getHealth();}

    public int getEnemyHealth() {return enemy.getHealth();}

    public String getEnemyName() {return enemy.getName();}

    public String getPlayerName() {return player.getName();}

    /**This also needs to be split up.**/
    public void healPlayer() {
        int heal = pc.calculatePotion();
        System.out.println("You drink a potion and restore " + heal + " health.");
        player.healHealth(heal);
    }

    /**Guessing we need to split this up somehow**/
    /**Define a local damage variable and use that for both screen output and adjusting player's health**/
    public void playerDamage() {
        int damage = dc.calculateDamage();
        System.out.println(player.getName() + " takes " + damage + " damage!");
        player.damageHealth(damage);
        System.out.println(player.getName() + "'s health is now " + player.getHealth() + "!");
    }

    /**This also needs to be split up**/
    public void enemyDamage() {
        int damage = dc.calculateDamage();
        System.out.println(player.useWeapon());
        System.out.println("The " +enemy.getName() + " takes " + damage + " damage!");
        enemy.damageHealth(damage);
        //For testing only. Delete before finalizing.
        System.out.println(enemy.getName() + "'s health is now " + enemy.getHealth() + "!");
    }
}
