import java.util.Scanner;
import java.util.Random;
public class Wetworks
{
    private int balance;
    Random rand = new Random();
    Daler d = new Daler(100, 100);
    Enemy e = new Enemy(100, 100);
    public Wetworks()
    {
        game();
    }
    public void game()
    {
        while (d.getHealth() > 0)
        {
            d.Stats();
            e.health();
            if (e.getHealth() <=0)
            {
                System.out.println("You successfully took down your target!");
                getBalance();
                getResults();
                break;
            }
            d.choice();
            if (d.getdmgBoost())
            {
                e.takeDamage((int) Math.round((d.getDamage() * 2.5)));
            }
            else {
                e.takeDamage(d.getDamage());
            }
            e.enemyChoice();
            if (d.getdmgReduce())
            {
                d.takeDamage(e.getDamage());
            }
            d.takeDamage(e.getDamage());
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

//