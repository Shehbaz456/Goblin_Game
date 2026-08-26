package Combat;

import Enemy.*;
import GameHelper.*;
import Player.Player;

import java.util.Scanner;

public class Combat {

    public boolean start(Player player,Scanner scanner) {
        System.out.println();
        System.out.println("========== LEVEL -  "+player.level + " ========================");
        System.out.println();
        System.out.println("==================================");
        System.out.println("⚔️ COMBAT STARTED!");
        System.out.println("==================================");

        if(player.level==1 || player.level==2 ){
        System.out.println();
        System.out.println("You enter a dark room...");
        System.out.println();
        System.out.println("Something is moving in the shadows.");
        System.out.println();
        }else if(player.level==3){
            System.out.println();
            System.out.println("You enter a Magic Mistery room...");
            System.out.println();
            System.out.println("Something is moving in the shadows.");
            System.out.println();
        }else {

        }

        WinnerRewards rewards = new WinnerRewards();
        DungeonCompleted dungeonCompleted = new DungeonCompleted();
        // New enemy for this combat
        Enemy enemy;
        if (player.level == 1 || player.level == 2) {
            enemy = new Goblin();
        } else if (player.level == 3) {
            enemy = new Skeleton();
        } else if (player.level == 4) {
            enemy = new Skeleton();
        } else {
            enemy = new Dragon();
        }

        System.out.println(  " 👹 "+ enemy.getName().toUpperCase() + " APPEARED!");
        int roundCount = 1;
        boolean running = true;
        // =================================
        //          COMBAT LOOP
        // =================================
        while (enemy.isAlive() && player.isAlive() && running ){
            System.out.println();
            System.out.println("========== ROUND " + roundCount + " ==========");
            System.out.println();
            System.out.println("Player HP : " + player.health);
            System.out.println( enemy.getName() + " HP : " + enemy.getHp());

            System.out.println();
            System.out.println("1. Attack");
            System.out.println("2. Use Potion");
            System.out.println("3. Run");

           int choice = InputHelper.getValidChoice(scanner, 1, 3);
            switch (choice){
                case 1:
                    System.out.println();
                    System.out.println("⚔️ You attack the "+ enemy.getName() + "!" );
                    enemy.takeDamage(player.attack);
                    // Goblin attacks back only if still alive
                    if (enemy.isAlive()) {
                        System.out.println("👹 "+ enemy.getName() + " attacks you!");
                        player.takeDamage(enemy.attack);
                        player.health +=player.defense;
                        System.out.println( "💔"+ " You received " + enemy.attack + " damage!" );
                    }
                    if(player.health<enemy.attack){
                        player.health=0;
                    }
                    roundCount++;
                    break;
                case 2:
                    player.useMagicPotion();
                    break;
                case 3:
                    System.out.println("3 : run");
                    running=false;
                    break;
            }
        }
        if(!enemy.isAlive()){
            rewards.getPlayerRewards(enemy,player);

            if (enemy instanceof Dragon) {
                dungeonCompleted.show(player);
                return true;
            }
        }
        if (!player.isAlive()) {
            System.out.println();
            System.out.println("💀 You have been defeated!");
        }
    return false;
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