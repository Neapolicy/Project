import java.util.Scanner;
public class Player
{
    private final String name;
    private String preference;
    private String guess;
    private boolean run = true;
    private final Scanner s = new Scanner(System.in);
    private int heads;
    private int tails;

    public Player()
    {
        System.out.println("What's your name?");
        name = s.nextLine();
    }

    public void playerPreference()
    {
        System.out.println("Do you want a rigged coin flip or fair one?");
        final String res = s.nextLine();
        if (res.equals("rigged"))
        {
            System.out.println("Coins will be rigged.");
        }
        else
        {
            System.out.println("Coins will be fair.");
        }
        preference = res;
    }
    public void playerGuess()
    {
        System.out.println("Heads or tails?");
        String answer = s.nextLine();
        while (run)
        {
            if (answer.contains("head") || (answer.contains("tail")))
            {
                run = false;
            }
            else
            {
                System.out.println(name.toString() + ", please put a valid input"); // added tostring to this
                answer = s.nextLine();
            }
        }
        guess = answer;
    }
    public void timesFlip()
    {
        System.out.println("How many times do you want to flip the coin?");
        int times = s.nextInt();
        if (preference.equals("rigged"))
        {
            Coin coin = new Coin(times);
            heads = coin.getHeads();
        }
        else
        {
            Coin coin_two = new Coin(guess, times);
            heads = coin_two.getHeads();
            tails = coin_two.getTails();
        }
    }

    public void welcome()
    {
        System.out.println("Welcome to Ferguson's Casino, " + name + "!" );
    }
    public int getHeads()
    {
        return heads;
    }
    public int getTails()
    {
        return tails;
    }
    public String getResponse()
    {
        return guess;
    }
}
