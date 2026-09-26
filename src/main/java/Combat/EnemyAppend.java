package Combat;

import Enemy.*;
import Player.Player;

public class EnemyAppend {
    public static Enemy createEnemy(Player player) {
        System.out.println();
        System.out.println(
                "========== LEVEL -  " + player.getLevel() + " ========================");
        System.out.println();
        System.out.println("==================================");
        System.out.println("⚔️ COMBAT STARTED!");
        System.out.println("==================================");

        if (player.getLevel() == 1 || player.getLevel() == 2) {
            System.out.println();
            System.out.println("You enter a dark room...");
            System.out.println();
            System.out.println("Something is moving in the shadows.");
            System.out.println();
        } else if (player.getLevel() == 3) {
            System.out.println();
            System.out.println("You enter a Magic Mistery room...");
            System.out.println();
            System.out.println("Something is moving in the shadows.");
            System.out.println();
        }
        Enemy enemy;
        if (player.getLevel() == 1 || player.getLevel() == 2) {
            enemy = new Goblin();
            System.out.println(" 👹 " + enemy.getName().toUpperCase() + " APPEARED!");
            return enemy;
        } else if (player.getLevel() == 3) {
            enemy = new Skeleton();
            System.out.println(" 👹 " + enemy.getName().toUpperCase() + " APPEARED!");
            return enemy;
        } else {
            enemy = new Dragon();
            System.out.println(" 👹 " + enemy.getName().toUpperCase() + " APPEARED!");
            return enemy;
        }
    }
}
