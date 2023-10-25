import java.util.Scanner;
import java.util.Random;
public class Wetworks
{
    private int balance;
    Random rand = new Random();
    Daler d = new Daler(100, 30);
    Enemy e = new Enemy(100, 40);
    public Wetworks()
    {
        game();
    }
    public void game()
    {
        while (d.getHealth() > 0)
        {
            if (e.getHealth() <=0)
            {
                System.out.println("You successfully took down your target!");
                getBalance();
                getResults();
                break;
            }
            d.Stats();
            e.health();
            d.choice();
            e.enemyChoice();
            if (d.getdmgBoost())
            {
                e.takeDamage((int) Math.round((d.getDamage() * 2.5)));
                d.resetBoost();
            }
            else {
                e.takeDamage(d.getDamage());
            }
            if (d.getdmgReduce())
            {
                d.takeDamage((int) Math.round(e.getDamage() * .7));
                d.resetReduce();
            }
            else
            {
                d.takeDamage(e.getDamage());
            }
        }
        getResults();
    }
    public boolean getResults()
    {
        if (e.getHealth() <= 0)
        {
            return true;
        }
        return false;
    }
    public int getBalance()
    {
        balance += rand.nextInt(100, 200);
        return balance;
    }
}