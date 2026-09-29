package Combat;

import Enemy.*;
import Player.Player;

public class EnemyFactory {
    public static Enemy createEnemy(Player player) {
        if (player.getLevel() <= 2) {
            return new Goblin();
        } else if (player.getLevel() == 3) {
            return new Skeleton();
        }
        return new Dragon();
    }
}
