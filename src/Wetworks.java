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
        d.Stats();
        game();
    }
    public void game()
    {
        while (d.getHealth() > 0)
        {
            if (e.getHealth() <=0)
            {
                getBalance();
                getResults();
                break;
            }
            d.choice();
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