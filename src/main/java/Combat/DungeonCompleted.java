package Combat;

import Player.Player;

public class DungeonCompleted {

    public void show(Player player) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       🏆 DUNGEON COMPLETED!");
        System.out.println("========================================");

        System.out.println();

        System.out.println("Warrior: " + player.name);
        System.out.println("Level: " + player.level);
        System.out.println("Enemies defeated: " + player.enemiesDefeated);
        System.out.println("Gold collected: " + player.goldCollected);
        System.out.println("Potions used: " + player.potionsUsed);

        System.out.println();

        System.out.println("You escaped the dungeon!");

        System.out.println();

        System.out.println("🏆 VICTORY");

        System.out.println("========================================");
    }
}