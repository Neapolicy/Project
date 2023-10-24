import java.util.Scanner;

public class Daler extends Character
{
    private final Scanner s = new Scanner(System.in);
    public Daler(int health, int stamina)
    {
        super(health, stamina);
    }
    public void Stats()
    {
        System.out.print("Your hp is " + getHealth());
        System.out.print("Your stamina is " + getStamina());
    }
}
