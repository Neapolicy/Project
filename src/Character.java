
public class Character
{
    protected int health;
    protected int damage;
    protected String desc;
    protected int stamina;
    protected int choice;
    protected int moves;
    protected boolean dmgBoost = false;

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

    public void takeDamage(int dam)
    {
        health -= dam;
    }
    public boolean staminaCheck(int staminaCost) {
        if (stamina - staminaCost >= 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean staminaLimit(int recover, int cap)
    {
        return stamina + recover >= cap;
    }
    public int getHealth()
    {
        return health;
    }
    public int getStamina() { return stamina; }
}