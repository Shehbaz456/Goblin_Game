import Combat.*;
import Enemy.*;
import Player.Player;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
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

        // ==============================
        //        PLAYER STATS
        // ==============================

        System.out.println();
        System.out.println("----------- YOUR STATS -----------");

        System.out.println("❤️  HP      : " + player.health);
        System.out.println("⚔️  Attack  : " + player.attack);
        System.out.println("🛡️  Defense : " + player.defense);
        System.out.println("⭐ Level    : " + player.level);
        System.out.println("💰 Gold     : " + player.gold);

        System.out.println("----------------------------------");

        System.out.println("What do you want to do?");

        System.out.println(" ");
        System.out.println("1. Explore Dungeon\n" +
                "2. Check Character\n" +
                "3. Inventory\n" +
                "4. Rest\n" +
                "5. Exit");

        while (true) {
            System.out.print("Choose an option: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 5)  break;
                System.out.println("Please choose between 1 and 5.");
            } else {
                System.out.println("Please enter a number.");
                scanner.next(); // remove invalid input
            }
        }

        switch (choice){
            case 1:
                System.out.println("1. Explore Dungeon");
                Combat combat = new Combat();
                combat.start(player);
                break;
            case 2:
                System.out.println("2. Check Character");
                break;
            case 3:
                System.out.println("3 Inventory");
                break;
            case 4:
                System.out.println("4. Rest");
                break;
            case 5:
                System.out.println("Gave exit.");
                break;
            default:
                System.out.println("Invalid choice. Choose 1-5.");
        }

        scanner.close();

    }


}
