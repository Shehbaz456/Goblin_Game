package Dungeon;

import GameHelper.InputHelper;
import Player.Player;

import java.util.Random;
import java.util.Scanner;

public class MysteryBox {

    private final Random random = new Random();

    public void open(Player player, Scanner scanner) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("        🎁 MYSTERIOUS CHEST");
        System.out.println("========================================");

        System.out.println();
        System.out.println("You discover a mysterious chest...");
        System.out.println();
        System.out.println("Something valuable might be inside.");
        System.out.println();

        System.out.println("1. Open the chest");
        System.out.println("2. Ignore it");

        int choice = InputHelper.getValidChoice(scanner, 1, 2);

        if (choice == 2) {
            System.out.println();
            System.out.println("🏃 You decided to leave the chest alone.");
            return;
        }

        System.out.println();
        System.out.println("🔓 You opened the chest!");
        System.out.println();

        giveRandomGift(player);
    }

    private void giveRandomGift(Player player) {

        int gift = random.nextInt(5) + 1;

        switch (gift) {

            case 1:
                giveGold(player);
                break;

            case 2:
                givePotion(player);
                break;

            case 3:
                healPlayer(player);
                break;

            case 4:
                increaseAttack(player);
                break;

            case 5:
                trap(player);
                break;
        }
    }

    private void giveGold(Player player) {

        int gold = random.nextInt(76) + 25;

        player.gold += gold;
        player.goldCollected += gold;

        System.out.println("💰 You found " + gold + " gold!");
        System.out.println("💰 Current Gold: " + player.gold);
    }

    private void givePotion(Player player) {

        int potions = random.nextInt(2) + 1;

        player.magicPotion  += potions;

        System.out.println("🧪 You found " + potions + " Magic Potion(s)!");
        System.out.println("🧪 Total Potions: " + player.magicPotion );
    }

    private void healPlayer(Player player) {

        int heal = random.nextInt(51) + 25;

        int oldHealth = player.health;

        player.health += heal;

        if (player.health > player.maxHealth) {
            player.health = player.maxHealth;
        }

        int actualHeal = player.health - oldHealth;

        System.out.println("❤️ You found a Healing Crystal!");
        System.out.println("❤️ HP restored: +" + actualHeal);
        System.out.println("❤️ Current HP: " + player.health);
    }

    private void increaseAttack(Player player) {

        int attack = random.nextInt(6) + 2;

        player.attack += attack;

        System.out.println("⚔️ You found a legendary weapon!");
        System.out.println("⚔️ Attack increased by +" + attack);
        System.out.println("⚔️ Current Attack: " + player.attack);
    }

    private void trap(Player player) {

        int damage = random.nextInt(21) + 10;

        player.health -= damage;

        if (player.health < 0) {
            player.health = 0;
        }

        System.out.println("💀 TRAP!");
        System.out.println("🔥 You lost " + damage + " HP!");
        System.out.println("❤️ Current HP: " + player.health);
    }
}