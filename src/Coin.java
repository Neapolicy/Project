import java.util.Random;
public class Coin
{
    private int heads;
    private int tails;

    public Coin()
    {
        System.out.println("It's heads");
        ++heads;
    }
    public Coin(String side, int times)
    {
        Random rand = new Random();
        for(int i = 0; i < times; i+= 1)
        {
            int random_int = rand.nextInt(2);
            if (random_int == 0) {
                ++heads;
                if (side.equals("heads") || side.equals("head")) {
                    cheer();
                } else {
                    System.out.println("You got it wrong.");
                }
            } else {
                ++tails;
                if (side.equals("tails") || side.equals("tail")) {
                    cheer();
                } else {
                    System.out.println("You got it wrong.");
                }
            }
        }
        results(heads, tails);
    }
    public void cheer()
    {
        System.out.println("You got it!");
    }
    public void results(int h, int t)
    {
        double proportionOfTails = ((double) t /(t + h));
        System.out.println("The coin has landed tails " + (int)(proportionOfTails * 100)+ " percent of the time.");
    }
}
