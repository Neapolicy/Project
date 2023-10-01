import java.util.Random;
public class Coin
{
    private int heads;
    private int tails;

    public Coin(int times)
    {
        for(int i = 0; i < times; i+= 1)
        {
            ++heads;
        }
        results();
    }
    public Coin(String side, int times)
    {
        Random rand = new Random();
        for(int i = 0; i < times; i+= 1)
        {
            int random_int = rand.nextInt(2);
            if (random_int == 0) {
                ++heads;
            } else {
                ++tails;
            }
        }
        results(heads, tails);
    }
    public void results(int h, int t)
    {
        System.out.println("The coin has landed on heads " + h + " times." + "\n" + "The coin has landed on tails " + t + " times.");
        double proportionOfTails = ((double) t /(t + h));
        System.out.println("The coin has landed tails " + (int)(proportionOfTails * 100)+ " percent of the time.");
    }
    public void results()
    {
        System.out.println("The coin has landed on heads " + heads + " times." + "\n" + "The coin has landed on tails " + tails + " times.");
        System.out.println("The coin has landed tails 0 percent of the time.");
    }
}
