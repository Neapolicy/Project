import java.util.Scanner;
public class Wallet
{
    private int balance = 100;
    private double bet;
    private boolean picking = true;
    private final Scanner s = new Scanner(System.in);
    private int times;
    public boolean checkDebt()
    {
        if (balance <= 0)
        {
            return true;
        }
        return false;
    }
    public void rebet()
    {
        times = 0;
        picking = true;
        System.out.println("\nSo, how much are you betting? (this is rounded to the nearest integer)");
        double betting = s.nextDouble();
        betting = Math.round(betting);
        while ((Math.abs(betting) >= Integer.MAX_VALUE) || Math.abs(betting) > balance)
        {
            times += 1;
            if (times <= 10)
            {
                System.out.println("You can't bet that! Try again. ");
            }
            else
            {
                System.out.println("By any chance, do you suffer from brainrot? Cause' you can't bet that!");
            }
            betting = s.nextDouble();
        }
        bet = Math.abs(betting);
        picking = false;
    }
    public double getBets()
    {
        return bet;
    }

    public int getBalance()
    {
        return balance;
    }
    public void setBalance(int money)
    {
        balance = money;
    }
}
