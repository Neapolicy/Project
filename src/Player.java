import java.util.Scanner;
public class Player
{
    private String name = null;
    private String preference;
    private String guess;
    private int energy = 100;
    private int times;
    private boolean run = true;
    private final Scanner s = new Scanner(System.in);

    public Player()
    {
        System.out.println("What's your name?");
        String res = s.nextLine();
        name = res;
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
        wallet w = new wallet();
    }
    public void playerGuess()
    {
        System.out.println("Heads or tails?");
        String answer = s.nextLine();
        while (run)
        {
            if (answer.equals("heads") || (answer.equals("tails")))
            {
                run = false;
            }
            else
            {
                System.out.println("Invalid input.");
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
        }
        else
        {
            Coin coin_two = new Coin(guess, times);
        }
    }

    public void sleep()
    {
        System.out.println("You go to sleep. You feel energized and refreshed!");
        energy = 100;
    }
    public String getName()
    {
        return name;
    }
}
