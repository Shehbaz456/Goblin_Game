package Combat;

import Enemy.Enemy;
import Player.Player;

public class WinnerRewards {

    public void getPlayerRewards(Enemy enemy, Player player) {

        System.out.println();
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║                                          ║");
        System.out.println("║              🏆 VICTORY!                 ║");
        System.out.println("║                                          ║");
        System.out.println("║          " + enemy.getName().toUpperCase() + " DEFEATED!              ║");
        System.out.println("║                                          ║");
        System.out.println("╚══════════════════════════════════════════╝");

        int gold = 0;
        int xp = 0;
        int potionReward = 0;

        switch (enemy.getName().toUpperCase()) {

            case "GOBLIN":
                gold = 25;
                xp = 20;
                potionReward = 1;
                break;

            case "SKELETON":
                gold = 50;
                xp = 40;
                potionReward = 2;
                break;

            case "DRAGON":
                gold = 250;
                xp = 200;
                potionReward = 3;
                break;

            default:
                System.out.println("Unknown enemy reward.");
        }

        // Give rewards
        player.gold += gold;
        player.goldCollected += gold;

        player.experience += xp;
        player.MagicPotion += potionReward;
        
        player.enemiesDefeated++;

        // Display rewards
        System.out.println();
        System.out.println("              🎁 REWARDS");
        System.out.println("──────────────────────────────────────────");
        System.out.println("💰 Gold       : +" + gold);
        System.out.println("⭐ XP         : +" + xp);
        System.out.println("🧪 Potions    : +" + player.MagicPotion);
        System.out.println("──────────────────────────────────────────");

        System.out.println();
        System.out.println("              📈 LEVEL UP!");
        System.out.println("──────────────────────────────────────────");

        player.level++;
        player.health += 20;
        if (player.health > player.maxHealth) {
            player.health = player.maxHealth;
        }
        player.attack += 5;
        player.defense += 2;

        System.out.println("⭐ Level      : " + player.level);
        System.out.println("❤️ HP         : +20");
        System.out.println("⚔️ Attack     : +5");
        System.out.println("🛡️ Defense    : +2");

        System.out.println("──────────────────────────────────────────");

        System.out.println();
        System.out.println("✨ Your character has become stronger!");
        System.out.println();
    }
}