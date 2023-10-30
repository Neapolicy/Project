
public class Character
{
    protected int health;
    protected int addOn;
    protected int damage;
    protected String desc;
    protected int stamina;
    protected int choice;
    protected int moves;
    protected boolean dmgBoost = false; // establish character stats and move variables

    public Character(int health, int stamina) // establishes a characters starting health and stamina
    {
        this.health = health;
        this.stamina = stamina;
    }
    public int moveOne(String s, int damage) // establishes move description and the amount of damage it does
    {
        System.out.println(s);
        return damage;
    }
    public void moveTwo(String s) // establishes move2 description
    {
        System.out.println(s);
    }

    public void takeDamage(int dam) // makes the character take damage depending on the int in parameter dam
    {
        health -= dam;
    }
    public boolean staminaCheck(int staminaCost) // checks if the character has enough stamina to perform an action
    {
        if (stamina - staminaCost >= 0) // the check
        {
            return true;
        }
        return false;
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