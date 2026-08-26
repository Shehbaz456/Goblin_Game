package Enemy;

public abstract class Enemy{
    // have hp // have atack
    protected String name;
    protected int hp;
    public int attack;

    public Enemy(String name,int hp,int attack){
        this.name=name;
        this.hp=hp;
        this.attack=attack;
    }

    public void takeDamage(int damage){
        hp -=damage;
        if(hp<0){
            hp=0;
        }
    }
    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackPower() {
        return attack;
    }
}
