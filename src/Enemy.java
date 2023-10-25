public class Enemy extends Character
{
    private int health;
    private int stamina;
    private int damage;
    public Enemy(int health, int stamina)
    {
        super(health, stamina);
        this.health = health;
        this.stamina = stamina;
    }
    public void health()
    {
        System.out.print("The enemy has " + getHealth() + "health");
    }
    public int getHeatlh()
    {
        return health;
    }
    public void enemyChoice()
    {

    }
    public int getDamage()
    {
        return damage;
    }
}