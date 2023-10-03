import java.util.Scanner;
public class Player
{
    private final String name;
    private String preference;
    private String guess;
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
    public void timesFlip(int bets)
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

    public void welcome()
    {
        System.out.println("Welcome to the gambling den, " + name + "!" );
    }
}
