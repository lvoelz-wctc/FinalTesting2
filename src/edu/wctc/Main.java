package edu.wctc;

import java.util.Scanner;

/**
 * Asks for the user's name and weapon choice, then uses the result to create a player from the PlayerFactory. Then,
 * creates an enemy from the EnemyFactory. A BattleDriver is constructed with the Player and Enemy as the parameters.
 * A do-while loop uses the BattleDriver to run a cycle where the enemy attacks, and then the player can attack the enemy
 * or drink a potion to restore health. This loop continues until either the player or enemy's health is zero. If the enemy's
 * health is zero, the player receives a score that decreases based on the number of turns it took to defeat the enemy. If
 * the player dies, they don't receive a score.
 */
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
        PlayerFactory pf = PlayerFactory.getInstance();
        Player p = pf.create(weapon, name);

        /**Create an enemy and the BattleDriver, show enemy once before starting loop**/
        EnemyFactory ef = EnemyFactory.getInstance();
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
            System.out.println("The " + bd.getEnemyName() + " defeated you!");
        }
    }
}