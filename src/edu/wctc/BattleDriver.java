package edu.wctc;

/**
 * Accepts a player and enemy from the PlayerFactory and EnemyFactory called in main. Uses the player and enemy to show
 * information about the player's/enemy's attacks and health during the battle. Also contains methods for calculating the
 * player's/enemy's health following an attack, and for healing the player if they choose to use a potion. The getters and
 * shower methods allow Main to return information about the Player/Enemy without directly interacting with a player/enemy
 * class.
 */
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

    /**
     * Shows text describing the enemy's name
     * @return A string stating that the player sees a specific type of enemy.
     */
    public String showEnemy() {return "You see a " + enemy.getName() + "!";}

    /**
     * Shows text describing the enemy's attack.
     * @return A string stating that the enemy makes an attack.
     */
    public String showAttack() {return "The " + enemy.getName() + " " + enemy.enemyAttack();}

    /**
     * Returns the player's health
     * @return The player's health
     */
    public int getPlayerHealth() {return player.getHealth();}

    /**
     * Returns the enemy's health
     * @return The enemy's health
     */
    public int getEnemyHealth() {return enemy.getHealth();}

    /**
     * Returns the enemy's name
     * @return The enemy's name
     */
    public String getEnemyName() {return enemy.getName();}

    /**
     * Returns the player's name
     * @return The player's name
     */
    public String getPlayerName() {return player.getName();}

    /**This also needs to be split up.**/
    /**Last line ensures that restored health readout is accurate if player health adjusted to below 100**/
    public void healPlayer() {
        int heal = pc.calculatePotion();
        int previousHealth = getPlayerHealth();
        player.healHealth(heal);
        System.out.println("You drink a potion and restore " + (getPlayerHealth() - previousHealth) + " health.");
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
