package Combat;

import Enemy.*;
import GameHelper.GameException.*;
import GameHelper.InputHelper;
import Player.Player;
import Template.CombatTemplate;
import Template.DungeonCompleted;
import Template.MysteryBox;
import Template.WinnerRewards;

import java.util.Random;
import java.util.Scanner;

public class Combat {
    public boolean start(Player player, Scanner scanner) {
        CombatTemplate.CombatTemp(player);
        Enemy enemy = EnemyFactory.createEnemy(player);
        MysteryBox mysteryBox = new MysteryBox();
        WinnerRewards rewards = new WinnerRewards();
        DungeonCompleted dungeonCompleted = new DungeonCompleted();

        int round = 1;
        boolean running = true;
        // =================================
        // COMBAT LOOP
        // =================================
        while (enemy.isAlive() && player.isAlive() && running) {
            showCombatStatus(player, enemy, round);
            int choice = InputHelper.getValidChoice(scanner, 1, 3);
            switch (choice) {
                case 1:
                    boolean alterFlag = playerAttack(scanner, player, enemy);
                    if (!alterFlag) continue;
                    break;
                case 2:
                    try {
                        player.useMagicPotion();
                    } catch (InsufficientPotionException e) {
                        System.out.println("⚠️ " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("3 : run");
                    running = false;
                    break;
            }
            if (running) round++;
        }
        if (!enemy.isAlive()) {
            rewards.getPlayerRewards(enemy, player);
            if (enemy instanceof Dragon) {
                dungeonCompleted.show(player);
                return true;
            }
            int eventChance = new Random().nextInt(100);
            if (eventChance < 50) {
                mysteryBox.open(player, scanner);
            }
        }
        if (!player.isAlive()) {
            System.out.println();
            System.out.println("💀 You have been defeated!");
        }
        return false;
    }

    public void showCombatStatus(Player player, Enemy enemy, int round) {
        System.out.println();
        System.out.println("========== ROUND " + round + " ==========");
        System.out.println();
        System.out.println("Player HP : " + player.getHealth());
        System.out.println(enemy.getName() + " HP : " + enemy.getHp());
        System.out.println();
        System.out.println("1. Attack");
        System.out.println("2. Use Potion");
        System.out.println("3. Run");
    }

    public boolean playerAttack(Scanner scanner, Player player, Enemy enemy) {
        if (player.getHealth() <= enemy.getAttack()) {
            System.out.println("⚠️ Too dangerous! You don't have enough HP to survive the attack.");
            System.out.print("Do you want to attack? (Y/N): ");
            String attackChoice = scanner.next().trim().toUpperCase();

            if (attackChoice.equals("N")) {
                System.out.println("🏃 You decided to back off.");
                return false;
            }
        }
        System.out.println();
        System.out.println("⚔️ You attack the " + enemy.getName() + "!");
        enemy.takeDamage(player.getAttack());
        if (enemy.isAlive()) {
            System.out.println("👹 " + enemy.getName() + " attacks you!");
            try {
                player.takeDamage(enemy.getAttack());
            } catch (InvalidDamageException e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }
}
