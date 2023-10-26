
public class Character
{
    protected int health;
    protected int stamina;

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
            return false;
        }
    }
    public boolean staminaLimit(int recover, int cap)
    {
        return stamina + recover > cap;
    }
    public int getHealth()
    {
        return health;
    }}