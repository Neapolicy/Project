import java.util.Scanner;
public class Player
{
    private final String name;
    private int preference;
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
    public void response()
    {
        System.out.println("Do you want a rigged (1) coin flip or fair one (2)? (Please note that you are only allowed to rig it once)");
        preference = s.nextInt();
        playerPreference();
    }
    public void playerPreference()
    {
        if (preference == 1)
        {
            System.out.println("Coins will be rigged.");
        }
        else
        {
            System.out.println("Coins will be fair.");
        }
    }
    public void playerGuess()
    {
        System.out.println("Heads (1) or tails? (2)");
        int answer = s.nextInt();
        while (run)
        {
            if (answer == 1 || (answer == 2))
            {
                run = false;
            }
            else
            {
                System.out.println(name + ", please put a valid input"); // added tostring to this
                answer = s.nextInt();
            }
        }
        guess = Integer.toString(answer);;
    }
    public void timesFlip()
    {
        System.out.println("How many times do you want to flip the coin?");
        int times = s.nextInt();
        if (preference == 1)
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