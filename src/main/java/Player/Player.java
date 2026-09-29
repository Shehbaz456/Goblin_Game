package Player;

import GameHelper.GameException.*;

public final class Player {
    private final String name;
    private int health = 100;
    private final int XPthreshold = 500;
    private static final int MAX_HEALTH = 400;
    private int attack = 30;
    private int defense = 5;
    private int level = 1;
    private int magicPotion = 1;
    private int experience;
    private int gold = 100;
    // Game statistics
    private int enemiesDefeated = 0;
    private int potionsUsed = 0;
    private int goldCollected = 0;

    private Player(String name) {
        this.name = name;
    }

    public static Player createPlayer(String name) {
        return new Player(name);
    }

    // --- GETTERS ---
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getLevel() {
        return level;
    }

    public int getMagicPotion() {
        return magicPotion;
    }

    public int getGold() {
        return gold;
    }

    public int getGoldCollected() {
        return goldCollected;
    }

    public int getPotionsUsed() {
        return potionsUsed;
    }

    public int getEnemiesDefeated() {
        return enemiesDefeated;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void increaseAttack(int attack) {
        this.attack += attack;
    }

    public void gainExperience(int xp) {
        if (xp < 0) {
            throw new IllegalArgumentException("XP cannot be negative.");
        }
        experience += xp;
        while (experience >= requiredXPtoLevelup()) {
            levelUp();
        }
    }

    private int requiredXPtoLevelup() {
        return getLevel() * 100;
    }

    public void collectGold(int gold) {
        if (gold < 0) {
            throw new IllegalArgumentException("Gold cannot be negative.");
        }
        this.gold += gold;
        goldCollected += gold;
    }

    public boolean spendGold(int gold) {
        if (gold <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (gold > this.gold) {
            return false;
        }
        this.gold -= gold;
        return true;
    }

    public void setHealth(int health) {
        this.health = clampHealth(health);
    }

    private int clampHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        if (this.MAX_HEALTH < health) {
            health = this.MAX_HEALTH;
            System.out.println("❤️ Your health is already full.");
        }
        return health;
    }

    // --- GAME MECHANICS ---
    public void takeDamage(int damage) throws InvalidDamageException {
        if (damage < 0) {
            throw new InvalidDamageException("Damage cannot be negative.");
        }
        int actualDamage = Math.max(0, damage - getDefense());
        this.health = clampHealth(health - actualDamage);
    }

    public void heal(int health) {
        this.health = clampHealth(this.health + health);
    }

    public void useMagicPotion() {
        if (magicPotion <= 0) {
            throw new InsufficientPotionException("You don't have any Magic Potions.");
        }

        heal(100);
        magicPotion--;
        potionsUsed++;
        System.out.println("🧪 Magic Potion used!");
        System.out.println("❤️ HP: " + health);
        System.out.println("🧪 Potions remaining: " + magicPotion);
    }

    public void addMagicPotion(int potion) {
        if (potion < 0) {
            throw new InsufficientPotionException("Magic Potion can not be negative");
        }
        this.magicPotion += potion;
    }

    public void recordEnemyDefeated(int enemyDefeatedCount) {
        enemiesDefeated += enemyDefeatedCount;
    }

    public void increaseDefense(int defense) {
        if (defense < 0) {
            throw new IllegalArgumentException("Defense can not be Negative.");
        }
        if (defense > MAX_HEALTH) {
            throw new IllegalArgumentException("Defense can not exceed maxHealth.");
        }
        this.defense += defense;
    }

    public void levelUp() {
        level++;
        increaseAttack(5);
        increaseDefense(2);
        heal(20);
        System.out.println();
        System.out.println("──────────────────────────────────────────");
        System.out.println("              📈 LEVEL UP!");
        System.out.println("──────────────────────────────────────────");
        System.out.println("⭐ Level      : " + getLevel());
        System.out.println("❤️ HP         : +20");
        System.out.println("⚔️ Attack     : +5");
        System.out.println("🛡️ Defense    : +2");
        System.out.println("──────────────────────────────────────────");
        System.out.println();
        System.out.println("✨ Your character has become stronger!");
        System.out.println();
    }

    // Add this inside Player.java
    public void printStatsSummary() {
        System.out.println("\n----------- YOUR STATS -----------");
        System.out.println("❤️  HP         : " + this.health);
        System.out.println("⚔️  Attack     : " + this.attack);
        System.out.println("🛡️  Defense    : " + this.defense);
        System.out.println("🧪 MagicPotion : " + this.magicPotion);
        System.out.println("🔬 Experience  : " + this.experience);
        System.out.println("⭐ Level       : " + this.level);
        System.out.println("💰 Gold        : " + this.gold);
        System.out.println("----------------------------------");
    }

    // Add this inside Player.java
    public void printDetailedCharacter() {
        System.out.println("\n----------- CHARACTER -----------");
        System.out.println("Name            : " + this.name);
        System.out.println("HP              : " + this.health + "/" + this.MAX_HEALTH);
        System.out.println("Attack          : " + this.attack);
        System.out.println("Defense         : " + this.defense);
        System.out.println("Level           : " + this.level);
        System.out.println("Experience      : " + this.experience);
        System.out.println("Gold            : " + this.gold);
        System.out.println("Gold Collected  : " + this.goldCollected);
        System.out.println("Enemies Defeated: " + this.enemiesDefeated);
        System.out.println("---------------------------------");
    }
}
