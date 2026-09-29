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
        System.out.println(
                "║          " + enemy.getName().toUpperCase() + " DEFEATED!              ║");
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
        player.collectGold(gold);
        player.gainExperience(xp);
        player.addMagicPotion(potionReward);
        player.recordEnemyDefeated(1);
        // Display rewards
        System.out.println();
        System.out.println("              🎁 REWARDS");
        System.out.println("──────────────────────────────────────────");
        System.out.println("💰 Gold       : +" + gold);
        System.out.println("⭐ XP         : +" + xp);
        System.out.println("🧪 Potions    : +" + potionReward);
        System.out.println("──────────────────────────────────────────");
    }
}
