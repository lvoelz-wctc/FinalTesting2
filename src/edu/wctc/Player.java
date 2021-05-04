package edu.wctc;

/**
 * Controlled by the user of the game. A PlayerFactory creates a Player and passes the name and weapon strategy defined in
 * main. The weapon strategy calls the WeaponStrategy strategy pattern, which returns a different attack type based on
 * whether the user chose to use a sword, axe, or spear in Main. The Player can also restore health.
 */
public class Player implements Being, WeaponStrategy{

    private String name;
    private int health = 100;
    private WeaponStrategy weaponStrategy;

    /**
     * Constructor to build a Player based on the name and weapon strategy defined in main and then passed to the
     * PlayerFactory
     * @param weaponStrategy Used to determine which of the WeaponStrategy patterns the Player returns when they attack.
     * @param name The player's name. Used in output when the Player wins or loses.
     */
    public Player(WeaponStrategy weaponStrategy, String name){
        this.name=name;
        this.weaponStrategy = weaponStrategy;
    }

    /**
     * Called by the BattleDriver when the Player chooses to use a potion. Restores the player's health by a number
     * equal to the heal parameter, which is passed from the PotionCalculator called in BattleDriver. To prevent players
     * from increasing their health infinitely, we reduce the player's health to 100 if the addition of the heal parameter
     * would set it over 100.
     * @param heal The result of BattleDriver calling PotionCalculator.calculatePotion().
     */
    public void healHealth(int heal) {
        int newHealth = health + heal;

        if (newHealth > 100){
            health = 100;
        }
        else {
            health = health+heal;
        }
        }


    /**
     * Called by the BattleDriver to reduce the player's health based on the damage dealt by an enemy attack.
     * @param damage The result of BattleDriver calling DamageCalculator.calculateDamage().
     */
    @Override
    public void damageHealth(int damage) {
        health = health-damage;
    }

    /**
     * Gets the player's health
     * @return The player's health
     */
    @Override
    public int getHealth() {
        return health;
    }

    /**
     * Gets the player's name
     * @return The player's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Shows the player's attack text, which will call either WeaponAxe, WeaponSpear, or WeaponSword based on the
     * input defined in Main and passed to the PlayerFactory.
     * @return
     */
    @Override
    public String useWeapon() {
        return weaponStrategy.useWeapon();
    }
}
