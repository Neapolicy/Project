import java.util.Scanner;

public class wallet
{
    private double balance;
    private double bet;
    private boolean picking = true;
    public void bets()
    {
        Scanner s = new Scanner(System.in);
        while (picking == true)
        {
            System.out.println("How much money do you have?");
            double answer = s.nextDouble();
            System.out.println("How much are you betting?");
            double betting = s.nextDouble();
            if ((answer >= Integer.MAX_VALUE || answer<=0) || (betting >=Integer.MAX_VALUE || betting <= 0))
            {
                System.out.println("Invalid, try again");
            }
            else
            {
                balance = answer;
                bet = betting;
                picking = false;
                s.close();
            }
            }
        }

    }