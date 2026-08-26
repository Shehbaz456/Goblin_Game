package Combat;

import Enemy.*;
import Player.Player;

import java.util.Scanner;




public class Combat {

    public void start(Player player) {
        System.out.println(" ");
        System.out.println("Combat started!");

        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println(" ");
        System.out.println("----------------------------------");
        System.out.println(" ");
        System.out.println("You enter a dark room...");
        System.out.println(" ");
        System.out.println("Something is moving in the shadows.");
        System.out.println(" ");

        // getIntoRoom();
        Enemy goblin = new Goblin();

        System.out.println("\uD83D\uDC79 GOBLIN APPEARED!");
        System.out.println( goblin.getName() + " HP: " + goblin.getHp());
        System.out.println(" ");

        System.out.println("1. Attack\n" +
                "2. Use Potion\n" +
                "3. Run");



        while (true) {

            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice >= 1 && choice <= 3) {
                    break;
                }

                System.out.println("Please choose between 1 and 3.");

            } else {
                System.out.println("Please enter a number.");
                scanner.next(); // remove invalid input
            }
        }

        switch (choice){
            case 1:

                int roundcount = 1;
                if(goblin.isAlive() || player.isAlive() ){
                System.out.println(" ");
                System.out.println(" Round :" + roundcount);
                System.out.println(" goblin.attack " + goblin.attack);
                System.out.println(" player.attack " + player.attack);
                goblin.takeDamage(player.attack);
                player.takeDamage(goblin.attack);
                System.out.println(" ");
                System.out.println("=========== Health status ============");
                System.out.println("Goblin HP : " + goblin.getHp());
                System.out.println("player HP : " +player.health);
                roundcount++;
                }

                System.out.println(" ");
                System.out.println(" Round 2 ");


                break;
            case 2:
                System.out.println("2 : Use Potion");
                break;
            case 3:
                System.out.println("3 : run");
                break;
        }

    }
}



//        Enemy goblin = new Goblin();
//        Enemy skeleton = new Skeleton();
//        Enemy dragon = new Dragon();
//
//        System.out.println(goblin.getName());
//        System.out.println("HP: " + goblin.getHp());
//
//        System.out.println(skeleton.getName());
//        System.out.println("HP: " + skeleton.getHp());
//
//        goblin.takeDamage(30);
//        System.out.println("HP: " + goblin.getHp());
//        System.out.println("is Alive: " + goblin.isAlive());