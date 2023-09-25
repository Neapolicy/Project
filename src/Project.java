import java.util.Scanner;

public class Project
{
    public static void main(String[] args)
    {
        wallet wallet = new wallet();
        wallet.bets();
        System.out.println("Do you want a rigged coin flip or fair one?");
        Scanner s = new Scanner(System.in);
        final String res = s.nextLine();
        if (res.equals("rigged"))
        {
            System.out.println("Coins will be rigged.");
        }
        else
        {
            System.out.println("Coins will be fair.");
        }
        System.out.println("Heads or tails?");
        String answer = s.nextLine();
        System.out.println("How many times do you want to flip the coin?");
        int times = s.nextInt();
        s.close();
        if (res.equals("rigged"))
        {
            Coin coin = new Coin();
        }
        else
        {
            Coin coin_two = new Coin(answer, times);
        }
    }
}
