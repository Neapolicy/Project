
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
        this.damage = damage;
        return damage;
    }
    public void moveTwo(String s)
    {
        System.out.println(s);
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

    public void takeDamage(int dam)
    {
        health -= dam;
    }
    public boolean staminaCheck(int staminaCost) {
        if (stamina - staminaCost > 0) {
            return true;
        } else {
            damage = 0;
            System.out.println("You're exhausted ");
            return false;
        }
    }    public int getHealth()
    {
        return health;
    }
    public void health()
    {
        if (getHealth() > 0)
        {
            System.out.println(getHealth() + " health");
            System.out.println(getStamina() + " stamina");
        }
    }
    public int getStamina()
    {
        return stamina;
    }
}