import java.util.Random;
public class Coin
{
    private int heads;
    private int tails;
    private String response;
    private int timed;

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
        timed = times;
        Random rand = new Random();
        for(int i = 0; i < times; i+= 1)
        {
            int random_int = rand.nextInt(2);
            if (random_int == 0){
                ++heads;
            } else {
                ++tails;
            }
        }
        results(heads, tails);
    }
    public void results(int h, int t)
    {
        String time = "time";
        if (timed>1)
        {
            time += "s";
        }
        System.out.println("The coin has landed on heads " + h + " " + time + "\nThe coin has landed on tails " + t + " " + time);
        double proportionOfTails = ((double) t /(t + h));
        System.out.println("The coin has landed tails " + (int)(proportionOfTails * 100)+ " percent of the time.");
        if ((response.contains("head") && proportionOfTails<=60) || (response.contains("tail") && proportionOfTails<=45))
        {
            System.out.println("You're off your game, you're better than this, aren't you?");
        }
        else if ((response.contains("head") && proportionOfTails>=45) || (response.contains("tail") && proportionOfTails>=60))
        {
            System.out.println("Now that's a gamblers spirit! Keep at it and you'll be rich in no time!");
        }
    }
    public void results()
    {
        String time = "time";
        if (timed>1)
        {
            time += "s";
        }
        System.out.println("The coin has landed on heads " + heads + " " + time + "\n" + "The coin has landed on tails " + tails + " time.");
        System.out.println("The coin has landed heads " + 100 + " percent of the time.");
    }
    public int getHeads()
    {
        return heads;
    }
    public int getTails()
    {
        return tails;
    }
}
