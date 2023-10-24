import java.util.Scanner;
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
        System.out.print(s);
        return damage;
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