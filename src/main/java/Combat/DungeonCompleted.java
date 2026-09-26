package Combat;

import Player.Player;

public class DungeonCompleted {
    public void show(Player player) {
        System.out.println();
        System.out.println("========================================");
        System.out.println("       🏆 DUNGEON COMPLETED!");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Warrior: " + player.getName());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Enemies defeated: " + player.getEnemiesDefeated());
        System.out.println("Gold collected: " + player.getGoldCollected());
        System.out.println("Potions used: " + player.getPotionsUsed());
        System.out.println();
        System.out.println("You escaped the dungeon!");
        System.out.println();
        System.out.println("🏆 VICTORY");
        System.out.println("========================================");
    }
}