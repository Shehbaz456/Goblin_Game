package Inventory;

import GameHelper.GameException;
import GameHelper.InputHelper;
import Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    public static List<Item> createDefaultInventory() {
        List<Item> inventory = new ArrayList<>();
        inventory.add(new Item("Health Potion", 100, 100));
        inventory.add(new Item("Sword ⚔️", 200, 50));
        inventory.add(new Item("Shield", 200, 20));
        return inventory;
    }

    // Public Final String NOT_ ENOUGH_GOLD_TO_BUY;
    public static List<Item> inventoryItems() {
        List<Item> inventory = new ArrayList<>();
        inventory.add(new Item("Health Potion", 100, 100));
        inventory.add(new Item("Sword ⚔️", 200, 50));
        inventory.add(new Item("Shield", 200, 20));
        return inventory; // Shop.showInventoryList(List list);
    }

    // Show shop inventory
    // 1. Health Potion
    // 2. Sword
    // 3. Shield
    public static void showInventoryList(Scanner sc, Player player) {
        try {
            List<Item> inventoryItemsList = inventoryItems();
            // inventoryItemsList.clear();
            if (inventoryItemsList.isEmpty()) {
                throw new GameException.ItemNotFoundException("Shop Item Not found.");
            }

            System.out.println("first Inventory : " + inventoryItemsList.get(0));
            System.out.println("You Have gold : " + player.getGold());
            System.out.println();
            boolean itemloop = true;
            while (itemloop) {
                System.out.println("\n================ SHOP ================");
                System.out.println("You Have Gold: 💰 " + player.getGold());
                System.out.println("--------------------------------------");
                System.out.printf("%-4s %-20s %-10s %-10s\n", "No.", "Item", "Gold", "Power");
                System.out.println("--------------------------------------");

                // Dynamically prints every item inside your list with clean alignment
                for (int i = 0; i < inventoryItemsList.size(); i++) {
                    Item item = inventoryItemsList.get(i);
                    System.out.printf(
                            "%d.   %-20s %-10d %-10d\n",
                            (i + 1), item.getName(), item.getGold(), item.getPower());
                }
                int exitChoice = inventoryItemsList.size() + 1;
                System.out.printf("%d.   %-20s\n", (inventoryItemsList.size() + 1), "Exit Shop");
                System.out.println("--------------------------------------");
                System.out.println();
                System.out.println("Enter you wanted to buy Defence item ");
                int choose = InputHelper.getValidChoice(sc, 1, exitChoice);
                if (choose == exitChoice) {
                    // itemloop = false;
                    System.out.println("Exiting shop menu...");
                    break;
                }
                Item selectedItem = inventoryItemsList.get(choose - 1);
                System.out.println("\nYou selected: " + selectedItem.getName());

                if (player.getGold() >= selectedItem.getGold()) {
                    player.decreaseGold(selectedItem.getGold());
                    switch (choose) {
                        case 1: // Health Potion
                            player.addHealth(selectedItem.getPower());
                            System.out.println(
                                    "✨ Drank potion! Restored " + selectedItem.getPower() + " HP.");
                            break;
                        case 2:
                            player.increaseAttack(selectedItem.getPower());
                            System.out.println(
                                    "⚔️ Equipped Sword! Attack increased by "
                                            + selectedItem.getPower()
                                            + ".");
                            break;
                        case 3:
                            player.increaseDefence(selectedItem.getPower());
                            System.out.println(
                                    "🛡️ Equipped Shield! Defense increased by "
                                            + selectedItem.getPower()
                                            + ".");
                            break;
                    }
                    System.out.println(
                            "Purchase successful! Remaining Gold: 💰 " + player.getGold());
                } else {
                    System.out.println("❌ Not enough gold to buy " + selectedItem.getName());
                }
            }
        } catch (GameException.ItemNotFoundException e) {
            // Handle the crash gracefully here
            System.out.println("\n[⚠️ SHOP ERROR]: " + e.getMessage());
            System.out.println("The shopkeeper is currently out of stock. Come back later!");
        }
    }
}
