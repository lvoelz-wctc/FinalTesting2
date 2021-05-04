package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int score = 100;
        int turns = 0;
        int turnMult = 3;

	Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Fantasy Battle! Enter your name.");
        String name = scanner.nextLine();
        System.out.println("Pick up a Sword (S), Axe (A), or Spear (P).");
        String weapon = scanner.nextLine();

        /**Create a player**/
        PlayerFactory pf = new PlayerFactory();
        Player p = pf.create(weapon, name);

        /**Create an enemy and the BattleDriver, show enemy once before starting loop**/
        EnemyFactory ef = new EnemyFactory();
        Enemy e = ef.create();
        BattleDriver bd = new BattleDriver(p, e);
        System.out.println(bd.showEnemy());

        /**Do-While Battle Loop**/
        do {
            /**Enemy attacks**/
            System.out.println(bd.showAttack());
            bd.playerDamage();

            /**Test if attack killed player, if so break loop**/
            if (bd.getPlayerHealth() <= 0){
                turns++;
                break;
            }

            /**Player chooses to fight or drink potion**/
            System.out.println("Your turn! Enter A to attack or P to drink a potion.");
            String playerAction = scanner.nextLine();

            if (playerAction.equals("A")){
                bd.enemyDamage();
            }
            else if (playerAction.equals("P")){
                bd.healPlayer();
            }
            turns++;
        } while (bd.getEnemyHealth() > 0 && bd.getPlayerHealth() > 0);

        /**Determine whether player or enemy won; calculate and show score if player won**/
        if (bd.getEnemyHealth() <= 0) {
            score = score - (turns * turnMult);
            System.out.println(bd.getPlayerName() + " defeated the " + bd.getEnemyName() + "!");
            System.out.println("Your score is " + score +".");
        }
        if (bd.getPlayerHealth() <= 0){
            System.out.println("The " + e.getName() + " defeated you!");
        }
    }
}