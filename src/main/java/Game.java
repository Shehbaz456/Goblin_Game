import Combat.Combat;
import GameHelper.InputHelper;
import Player.Player;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ==============================
        //        GAME TITLE
        // ==============================

        System.out.println();
        System.out.println("========================================");
        System.out.println("        ⚔️  DUNGEON ESCAPE ⚔️");
        System.out.println("========================================");
        System.out.println();

        // ==============================
        //        PLAYER CREATION
        // ==============================

        System.out.print("Enter your warrior name: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);

        System.out.println();
        System.out.println("Welcome, " + playerName + "!");

        // Create Combat once
        Combat combat = new Combat();
        // ==============================
        //        MAIN GAME LOOP
        // ==============================

        boolean gameRunning = true;
        while (gameRunning && player.isAlive()) {
            System.out.println();
            System.out.println("----------- YOUR STATS -----------");
            System.out.println("❤️  HP         : " + player.health);
            System.out.println("⚔️  Attack     : " + player.attack);
            System.out.println("🛡️  Defense    : " + player.defense);
            System.out.println("🧪 MagicPotion : " + player.MagicPotion);
            System.out.println("⭐ Level       : " + player.level);
            System.out.println("💰 Gold        : " + player.gold);

            System.out.println("----------------------------------");

            System.out.println();
            System.out.println("What do you want to do?");

            System.out.println(
                    "1. Explore Dungeon\n" +
                            "2. Check Character\n" +
                            "3. Inventory\n" +
                            "4. Rest\n" +
                            "5. Exit"
            );

            int choice = InputHelper.getValidChoice(scanner, 1, 5);

            // ==============================
            //        MAIN MENU
            // ==============================
            switch (choice) {

                case 1:
                    System.out.println();
                    System.out.println("⚔️ Exploring Dungeon...");
                    boolean dungeonCompleted = combat.start(player, scanner);
                    if (dungeonCompleted) {
                        gameRunning = false;
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("----------- CHARACTER -----------");
                    System.out.println("Name    : " + player.name);
                    System.out.println("HP      : " + player.health);
                    System.out.println("Attack  : " + player.attack);
                    System.out.println("Defense : " + player.defense);
                    System.out.println("Level   : " + player.level);
                    System.out.println("Gold    : " + player.gold);

                    System.out.println("---------------------------------");

                    break;

                case 3:
                    System.out.println();
                    System.out.println("🎒 Inventory");
                    System.out.println("Inventory system coming soon...");
                    break;
                case 4:
                    System.out.println();
                    System.out.println("💤 You rest...");
                    player.heal();
                   //  player.health += 10;
                    // Prevent HP from exceeding maximum.
                    if (player.health > player.maxHealth) {
                        player.health = player.maxHealth;
                    }
                    System.out.println( "Your HP is now: " + player.health);
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Thanks for playing!");
                    gameRunning = false;
                    break;
            }
        }
        if (!player.isAlive()) {
            System.out.println();
            System.out.println("💀 YOU DIED!");
            System.out.println("Game Over.");
        }
        scanner.close();
    }
}