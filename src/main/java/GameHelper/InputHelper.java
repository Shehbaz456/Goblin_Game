package GameHelper;
import java.util.Scanner;

public class InputHelper {
    public static int getValidChoice( Scanner scanner, int min, int max ) {
        while (true) {
            System.out.print("Choose an option: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Please choose between " + min+ " and "+ max);
            } else {
                System.out.println("Invalid menu selection. ");
                // Remove invalid input
                scanner.next();
            }
        }
    }
}