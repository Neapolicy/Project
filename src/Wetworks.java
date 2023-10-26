import java.util.Random;
public class Wetworks
{
    private int balance;
    Random rand = new Random();
    private int turns = 0;
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
            if (turns % 2 == 1)
            {
                d.choice();
                getInfo();
                turns ++;
            }
            else
            {
                e.enemyChoice();
                getInfo();
                turns ++;
            }
            if (d.getdmgBoost() && (d.choice() == 1) && d.staminaCheck(7))
            {
                e.takeDamage((d.getDamage() * 2));
                d.resetBoost();
            }
            else if (d.choice() == 1 && d.staminaCheck(7)) {
                e.takeDamage(d.getDamage());
            }
            if (d.getdmgReduce())
            {
                d.takeDamage((int)(e.getDamage() * .5));
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

    public void getInfo()
    {
        System.out.println("Daler's stats: ");
        d.health();
        System.out.println("Enemy's stats: ");
        e.health();
    }
}