import Combat.Combat;
import GameHelper.InputHelper;
import Inventory.Shop;
import Player.Player;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ==============================
        // GAME TITLE
        // ==============================

        System.out.println();
        System.out.println("========================================");
        System.out.println("        ⚔️  DUNGEON ESCAPE ⚔️");
        System.out.println("========================================");
        System.out.println();

        // ==============================
        // PLAYER CREATION
        // ==============================
        // System.out.print("Enter your warrior name: ");
        // String playerName = scanner.nextLine();
        String playerName = InputHelper.getValidName(scanner);
        Player player = Player.createPlayer(playerName);

        // Player player = new Player(playerName);
        // dummy name not able to enter every time name this is for Dev.
        // String playerName="Shehbaz";
        // Player player = Player.createPlayer(playerName);

        System.out.println();
        System.out.println("Welcome, " + playerName + "!");

        // Create Combat once
        Combat combat = new Combat();
        // ==============================
        // MAIN GAME LOOP
        // ==============================

        boolean gameRunning = true;
        while (gameRunning && player.isAlive()) {

            player.printStatsSummary();

            System.out.println();
            System.out.println("What do you want to do?");

            System.out.println(
                    "1. Explore Dungeon\n"
                            + "2. Check Character\n"
                            + "3. Inventory\n"
                            + "4. Rest\n"
                            + "5. Exit");

            int choice = InputHelper.getValidChoice(scanner, 1, 5);

            // ==============================
            // MAIN MENU
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
                    player.printDetailedCharacter();
                    break;

                case 3:
                    System.out.println();
                    Shop.showInventoryList(scanner, player);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("💤 You rest...");
                    int health = 50;
                    player.heal(health);
                    System.out.println("❤️ Healed 50 HP!");
                    System.out.println("Your HP is now: " + player.getHealth());
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
