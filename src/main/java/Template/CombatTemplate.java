package Template;

import Player.Player;

public class CombatTemplate {
    public static void CombatTemp(Player player) {
        System.out.println();
        System.out.println(
                "========== LEVEL -  " + player.getLevel() + " ========================");
        System.out.println();
        System.out.println("==================================");
        System.out.println("⚔️ COMBAT STARTED!");
        System.out.println("==================================");

        if (player.getLevel() == 1 || player.getLevel() == 2) {
            System.out.println();
            System.out.println("You enter a dark room...");
            System.out.println();
            System.out.println("Something is moving in the shadows.");
            System.out.println();
        } else if (player.getLevel() == 3) {
            System.out.println();
            System.out.println("You enter a Magic Mistery room...");
            System.out.println();
            System.out.println("Something is moving in the shadows.");
            System.out.println();
        }
    }
}
