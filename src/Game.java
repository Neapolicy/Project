import java.util.Scanner;
public class Game
{
    private String guess;
    private int tails;
    private int heads;
    private boolean run = true;
    private int balance;
    private double bets;
    private int victory;
    public Game()
    {
        Player p = new Player();
        p.welcome();
        System.out.println("Dice game, Slots, or Coin flip?");
        Scanner s = new Scanner(System.in);
        String response = s.nextLine();
        while (run)
        {
            if (response.equals("Coin flip"))
            {
                Wallet w = new Wallet();
                balance = w.getBalance();
                bets = w.getBets();
                p.playerPreference();
                p.playerGuess();
                p.timesFlip();
                heads = p.getHeads();
                tails = p.getTails();
                guess = p.getResponse();
                loseMoney();
                earnMoney();
                w.setBalance(balance);
                System.out.println("Your balance is now " + w.getBalance() + " dollars");
                System.out.println("Player Address: " + p);
                run = false;
            }
            if (response.equals("Dice game"))
            {
                Wallet w = new Wallet();
                balance = w.getBalance();
                bets = w.getBets();
                Dice d = new Dice();
                victory = d.getVictory();
                loseDiceMoney();
                earnDiceMoney();
                w.setBalance(balance);
                System.out.println("Your balance is now " + w.getBalance() + " dollars");
                System.out.println("Player Address: " + p);
                run = false;
            }
            if (response.equals("Slots"))
            {
                Slots slot = new Slots();
                System.out.println("The current Jackpot is " + slot.getJackpot());
                slot.generateSlot();
                slot.slotReturn();
                run = false;
            }
            response  = s.nextLine();
        }
    }
    public void loseMoney()
    {
        if (guess.equals("heads"))
        {
            for(int i = 0; i < tails; i+= 1)
            {
                balance -= bets;
            }
        }
        else
        {
            for(int i = 0; i < heads; i+= 1)
            {
                balance -= bets;
            }
        }
    }
    public void earnMoney()
    {
        if (guess.equals("heads"))
        {
            for(int i = 0; i < heads; i+= 1)
            {
                balance += bets;
            }
        }
        else
        {
            for(int i = 0; i < tails; i+= 1)
            {
                balance += bets;
            }
        }
    }
    public void loseDiceMoney()
    {
        if (victory == 1)
        {
            for(int i = 0; i < 1; i+= 1)
            {
                balance -= bets;
            }
        }
    }
    public void earnDiceMoney()
    {
        if (victory == 0)
        {
            for(int i = 0; i < 1; i+= 1)
            {
                balance += bets;
            }
        }
    }
}
