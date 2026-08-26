package Player;

public class Player {
  public String name;
  public int health=100;
  public int maxHealth=400;
  public int attack=15;
  public int defense=5;
  public int level=1;
  public int MagicPotion = 0;
  public int experience;
  public int gold=100;

    // Game statistics
    public int enemiesDefeated = 0;
    public int potionsUsed = 0;
    public int goldCollected = 0;

  public Player(String name) {
        this.name=name;
  }

   public void takeDamage(int damage){
      health-=damage;
      if(health<0){
          health=0;
      }
    }


   public void heal(){
      health +=50;
      System.out.println("Heal 50");
    }
    public boolean isAlive() {
        return health > 0;
    }

    public void useMagicPotion() {

        if (MagicPotion <= 0) {
            System.out.println("❌ You don't have any Magic Potions.");
            return;
        }

        if (health >= maxHealth) {
            System.out.println("❤️ Your health is already full.");
            return;
        }

        int healAmount = 100;

        health += healAmount;

        if (health > maxHealth) {
            health = maxHealth;
        }

        MagicPotion--;
        // Statistics
        potionsUsed++;
        System.out.println("🧪 Magic Potion used!");
        System.out.println("❤️ HP: " + health);
        System.out.println("🧪 Potions remaining: " + MagicPotion);
    }
//    gainExperience(){
//
//    }
//    levelUp(){
//
//    }

}
