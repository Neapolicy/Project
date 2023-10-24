public class Enemy extends Character
{
    public Enemy(int health, int stamina)
    {
        super(health, stamina);
    }
    public void health()
    {
        System.out.print("The enemy has " + getHealth() + "health");
    }
}