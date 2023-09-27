import java.util.Scanner;

public class wallet
{
    private double balance;
    private double bet;
    private boolean picking = true;
    public wallet()
    {
        Scanner s = new Scanner(System.in);
        while (picking)
        {
            System.out.println("How much are you betting?");
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

    }