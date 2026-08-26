package Player;

public class Player {
  public String name;
  public int health=100;
  public int maxHealth=100;
  public int attack=15;
  public int defense=5;
  public int level=1;
 // public int experience;
  public int gold=50;

  public Player(String name) {
        this.name=name;
  }

  public int AttackEnemy(int attack){
      return attack;
  }

   public void takeDamage(int damage){
      health-=damage;
      if(health<0){
          health=0;
      }
      System.out.println(name + " takes " + damage + " damage.");
    }


   public void heal(){
      health +=50;
       System.out.println("Heal 50");
    }
    public boolean isAlive() {
        return health > 0;
    }
//    gainExperience(){
//
//    }
//    levelUp(){
//
//    }

}
