import java.util.Random;
public class Coin
{
    private int heads;
    private int tails;
    private String response;

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
        response = side;
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
        if (response.equals("heads") && proportionOfTails>=60 || response.equals("tails") && proportionOfTails>=45)
        {
            System.out.println("You're off your game, you're better than this, aren't you?");
        }
        else if (response.equals("heads") && proportionOfTails<=45)
        {
            System.out.println("Now that's a gamblers spirit! Keep at it and you'll be rich in no time!");
        }
    }
    public void results()
    {
        System.out.println("The coin has landed on heads " + heads + " times." + "\n" + "The coin has landed on tails " + tails + " times.");
        System.out.println("The coin has landed heads 100 percent of the time.");
    }
}
