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

    /**
     * Constructor to create the BattleDriver. Accepts the Player and Enemy created by the factories
     * instantiated in Main.
     * @param player The Player created by the PlayerFactory in Main
     * @param enemy The Enemy created by the EnemyFactory in Main
     */
    public BattleDriver(Player player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;
    }

    PotionCalculator pc = new PotionCalculator();
    DamageCalculator dc = new DamageCalculator();

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

    /**
     * Calls the PotionCalculator's calculatePotion method to get a random number between 15 and 20, then passes
     * that number to the player's heal method. If Player.healHealth would set player's health above 100, the health
     * is set to 100 instead. To account for this in healPlayer, we subtract the player's new health from the health
     * before healing, so that our potion output accounts for any "flattened" heal values.
     */
    public void healPlayer() {
        int heal = pc.calculatePotion();
        int previousHealth = getPlayerHealth();
        player.healHealth(heal);
        System.out.println("You drink a potion and restore " + (getPlayerHealth() - previousHealth) + " health.");
    }

    /**
     * When an enemy attacks, calls the DamageCalculator's calculateDamage method to get a random number between 5 and 15, then passes
     * that number to the player's damageHealth method. System.out reports on the amount of damage taken and the player's
     * current health.
     */
    public void playerDamage() {
        int damage = dc.calculateDamage();
        System.out.println(player.getName() + " takes " + damage + " damage!");
        player.damageHealth(damage);
        System.out.println(player.getName() + "'s health is now " + player.getHealth() + "!");
    }

    /**
     * When a player attacks, calls the DamageCalculator's calculateDamage method to get a random number between 5 and 15, then passes
     * that number to the enemy's damageHealth method. System.out reports on the attack and the amount of damage taken. The enemy's damageHealth
     * method reduces the enemy's health by the damage value. We do not want the player to know the enemy's health, so we do not use system.out
     * to report enemy health.
     */
    public void enemyDamage() {
        int damage = dc.calculateDamage();
        System.out.println(player.useWeapon());
        System.out.println("The " +enemy.getName() + " takes " + damage + " damage!");
        enemy.damageHealth(damage);
    }
}
