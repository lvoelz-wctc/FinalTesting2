package edu.wctc;

import java.util.Random;

public class BattleDriver {

    private Player player;
    private Enemy enemy;
    //private Integer damage;

    public BattleDriver(Player player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;
    }

    DamageCalculator dc = new DamageCalculator();

    public String showEnemy() {return "You see a " + enemy.getName() + "!";}

    public String showAttack() {return "The " + enemy.getName() + " " + enemy.enemyAttack();}

    public int getPlayerHealth() {return player.getHealth();}

    public int getEnemyHealth() {return enemy.getHealth();}

    public String getEnemyName() {return enemy.getName();}

    public String getPlayerName() {return player.getName();}

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
        enemy.damageHealth(damage);
        System.out.println(enemy.getName() + "'s health is now " + enemy.getHealth() + "!");
    }
}