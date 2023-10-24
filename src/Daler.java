import java.util.Scanner;

public class Daler extends Character
{
    private int health;
    int moves;
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
    public void choice()
    {
        System.out.println("Pick your move");
        System.out.println("Basic Attack (1) \nAt the Ready(2)\nRedbull(3) \nBlock(4) \nMiss Travailer(5)");
        int answer = s.nextInt();
        switch (answer)
        {
            case 1:
                moveOne("lol", 1);
                break;
            case 2:
                moveTwo();
                break;
        }
    }
    public void takeDamage(int dam)
    {
        health -= dam;
    }
    public void missTravailer() // this is your ult
    {

    }
    public void moveTwo()
    {

    }
}
