import java.util.Scanner;
public class Game
{
    private String guess;
    private int tails;
    private int heads;
    private boolean run = true;
    public Game()
    {
        Player p = new Player();
        p.welcome();
        Wallet w = new Wallet();
        System.out.println("Dice game, Slots, or Coin flip?");
        Scanner s = new Scanner(System.in);
        String response = s.nextLine();
        while (run)
        {
            if (response.equals("Coin flip"))
            {
                p.playerPreference();
                p.playerGuess();
                p.timesFlip();
                heads = p.getHeads();
                tails = p.getTails();
                guess = p.getResponse();
                loseMoney(w.getBalance(), w.getBets());
                earnMoney(w.getBalance(), w.getBets());
                System.out.println("Your balance is now " + w.getBalance() + " dollars");
                System.out.println("Player ID: " + p);
                run = false;
            }
            if (response.equals("Dice game"))
            {
                Dice d = new Dice();
                loseDiceMoney(w.getBalance(), w.getBets(), d.getVictory());
                earnDiceMoney(w.getBalance(), w.getBets(), d.getVictory());
                System.out.println("Your balance is now " + w.getBalance() + " dollars");
                System.out.println("Player ID: " + p);
                run = false;
            }
            if (response.equals("Slots"))
            {
                Slots slot = new Slots();
                run = false;
            }
        }
    }
    public void loseMoney(int bal, double bets)
    {
        if (guess.equals("heads"))
        {
            for(int i = 0; i < tails; i+= 1)
            {
                bal -= bets;
            }
        }
        else
        {
            for(int i = 0; i < heads; i+= 1)
            {
                bal -= bets;
            }
        }
    }
    public void earnMoney(int bal, double bets)
    {
        if (guess.equals("heads"))
        {
            for(int i = 0; i < heads; i+= 1)
            {
                bal += bets;
            }
        }
        else
        {
            for(int i = 0; i < tails; i+= 1)
            {
                bal += bets;
            }
        }
    }
    public void loseDiceMoney(int bal, double bets, boolean d)
    {
        if (d)
        {
            for(int i = 0; i < 1; i+= 1)
            {
                bal -= bets;
            }
        }
    }
    public void earnDiceMoney(int bal, double bets, boolean d)
    {
        if (d)
        {
            for(int i = 0; i < 1; i+= 1)
            {
                bal += bets;
            }
        }
    }
}
