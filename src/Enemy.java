public class Enemy extends Character
{
    private int health;
    private int stamina;
    private int damage;
    public Enemy(int health, int stamina)
    {
        super(health, stamina);
        this.stamina = stamina;
    }
    public void health()
    {
        if (getHealth() > 0)
        {
            System.out.println("The enemy has " + getHealth() + " health");
        }
    }
    public void enemyChoice()
    {

    }
    public int getDamage()
    {
        return damage;
    }
}