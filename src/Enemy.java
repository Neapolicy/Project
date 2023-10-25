public class Enemy extends Character
{
    private int health;
    public Enemy(int health, int stamina)
    {
        super(health, stamina);
        this.health = health;
    }
    public void health()
    {
        System.out.print("The enemy has " + getHealth() + "health");
    }
    public int getHeatlh()
    {
        return health;
    }
}