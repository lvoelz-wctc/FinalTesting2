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
        Player p = new Player(new WeaponSword(), name);

        /**
        if (weapon.equals("S")){
            Player p = new Player(new WeaponSword(), name);
        }
        else if (weapon.equals("A")){
            Player p = new Player(new WeaponAxe(), name);
        }
        else {
            Player p = new Player(new WeaponSpear(), name);
        }**/

        EnemyFactory ef = new EnemyFactory();
        Enemy e = ef.create();
        BattleDriver bd = new BattleDriver(p, e);

        //do {
            System.out.println(bd.showEnemy());
            System.out.println(bd.showAttack());
            bd.playerDamage();

            bd.enemyDamage();


        /**} while (bd.getEnemyHealth() > 0 && bd.getPlayerHealth() >0);
        score = score - (turns * turnMult);
        if (bd.getEnemyHealth() <= 0) {
            System.out.println("You defeated the " +e.getName() + "!");
            System.out.println("Your score is " + score +".");
        }
        if (bd.getPlayerHealth() <= 0){
            System.out.println("The " + e.getName() + " defeated you!");
        }**/
    }
}
