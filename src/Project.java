import java.util.Scanner;

public class Project
{
    public static void main(String[] args)
    {
        System.out.println("You're in debt");
        System.out.println("You love coins");
        System.out.println("And you LOVE to gamble");
        System.out.println("You know what to do.");
        Player p = new Player();
        p.playerPreference();
        p.playerGuess();
        wallet w = new wallet();
        System.out.println("Your balance is " + w.getBalance() + " dollars.");
        p.timesFlip();
    }
}
