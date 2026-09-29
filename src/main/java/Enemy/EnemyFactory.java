package Enemy;

import Player.Player;

public class EnemyFactory {
    public static Enemy createEnemy(Player player) {
        Enemy enemy = null;
        if (player.getLevel() <= 2) {
            enemy = new Goblin();
        } else if (player.getLevel() == 3) {
            enemy = new Skeleton();
        } else {
            enemy = new Dragon();
        }
        System.out.println(" 👹 " + enemy.getName().toUpperCase() + " APPEARED!");
        return enemy;
    }
}
