
public class Character
{
    private int health;
    private int stamina;
    private int damage;

    public Character(int health, int stamina)
    {
        this.health = health;
        this.stamina = stamina;
    }
    public int moveOne(String s, int damage)
    {
        System.out.println(s);
        return damage;
    }
    public int moveThree(String s, int recover)
    {
        System.out.println(s);
        return stamina + recover;
    }
    public int loseStamina(int energy)
    {
        stamina -= energy;
        return stamina;
    }

    public int takeDamage(int dam)
    {
        health -= dam;
        return health;
    }
    public int getHealth()
    {
        return health;
    }
    public int getStamina()
    {
        return stamina;
    }
}