package GameHelper;

import java.util.Scanner;

public class InputHelper {
    public static int getValidChoice(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print("Choose an option: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Please choose between " + min + " and " + max);
            } else {
                System.out.println("Invalid menu selection. ");
                System.out.println("Please choose between " + min + " and " + max);
                // Remove invalid input
                scanner.next();
            }
        }
    }
    public static String getValidName(Scanner sc){
        String playerName ="";
        while (true){
            System.out.print("Enter your warrior name: ");
            if(sc.hasNextLine()){
                playerName = sc.nextLine().trim();
                if(!playerName.isEmpty()){
                playerName = playerName.trim().toUpperCase();
                }
                if(playerName.isEmpty() || !playerName.matches("^[a-zA-Z\\s]+$")){
                    System.out.println("❌ Invalid name! Please use letters only (spaces are allowed).");
                    continue;
                }
                if(playerName.length() < 3 || playerName.length() > 30){
                    System.out.println("❌ Player name must be between 3 and 30 characters.");
                    continue;
                }
                break;
            }
            else {
                sc.next();
            }
        }
        return playerName;
    }
}