package Inventory;

public class Item {
    private String name;
    private int gold;
    private int power;

    public Item(String name, int gold, int power) {
        this.name = name;
        this.gold = gold;
        this.power = power;
    }

    // Getters for accessing data
    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return name + " (Gold: " + gold + ", Power: " + power + ")";
    }
}
