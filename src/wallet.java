import java.util.Scanner;

public class wallet
{
    private int balance = 100;
    private double bet;
    private boolean picking = true;
    private Scanner s;
    public wallet()
    {
        while (picking)
        {
            System.out.println("How much are you betting?(this is rounded to the nearest integer)");
            s = new Scanner(System.in);
            double betting = s.nextDouble();
            betting = (int)(betting + 0.5);
            if ((betting >=Integer.MAX_VALUE || betting <= 0))
            {
                System.out.println("Invalid, try again");
            }
            else
            {
                bet = betting;
                picking = false;
                s.close();
            }
            }
        }

    public double getBets()
    {
        return bet;
    }

    public int getBalance()
    {
        return balance;
    }
}
