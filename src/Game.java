import java.util.Scanner;
public class Game
{
    private String guess;
    private int tails;
    private int heads;
    private int balance;
    private double bets;
    private int victory;
    public Game()
    {
        Advertisements ads = new Advertisements();
        Slots slot = new Slots();
        System.out.println("Your current balance is $100");
        Player p = new Player();
        Wallet w = new Wallet();
        p.welcome();
        System.out.println("\nDice game, Slots, or Coin flip?\nSlots is $10 per try\nType \"quit\" to quit");
        Scanner s = new Scanner(System.in);
        String response = s.nextLine();
        while (true)
        {
            if (response.equalsIgnoreCase("Coin flip"))
            {
                w.rebet();
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
                System.out.println("\nYour balance is now $" + w.getBalance());
                ads.adsPrint();
            }
            else if (response.equalsIgnoreCase("Dice game"))
            {
                w.rebet();
                balance = w.getBalance();
                bets = w.getBets();
                Dice d = new Dice();
                victory = d.getVictory();
                loseDiceMoney();
                earnDiceMoney();
                w.setBalance(balance);
                System.out.println("\nYour balance is now $" + w.getBalance());
                ads.adsPrint();
            }
            else if (response.equalsIgnoreCase("Slots"))
            {
                slot.slotIntro();
                bets = 10;
                victory = 1;
                balance = w.getBalance();
                loseDiceMoney();
                bets = slot.getJackpot();
                System.out.println("The current Jackpot is " + slot.getJackpot());
                System.out.println("You pay $10 to spin the slot machine.");
                slot.generateSlot();
                victory = slot.slotWinOrLose();
                slot.setJackpot(victory);
                earnDiceMoney();
                w.setBalance(balance);
                System.out.println("\nYour balance is now $" + w.getBalance());
                System.out.println("The Jackpot is now $" + slot.getJackpot() + "\nKeep trying!");
                ads.adsPrint();
            }
            else if (response.equalsIgnoreCase("steal"))
            {
                Steal steel = new Steal(w.getBalance());
                this.balance = steel.getBalance();
                w.setBalance(balance);
                System.out.print(balance);
            }
            if (response.equals("quit"))
            {
                System.out.println("Have a nice day!");
                System.out.println("Player Address: " + p);
                break;
            }
            if(w.checkDebt())
            {
                System.out.println("\nYou're in debt! What a loser! Get out!");
                break;
            }
            System.out.println("\nDice game, Slots, or Coin flip?\nSlots is $10 per try\nType \"quit\" to quit");
            response  = s.nextLine();
        }
    }
    public void loseMoney()
    {
        if (guess.contains("head"))
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
        if (guess.contains("head"))
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
            this.balance -= bets;
        }
    }
    public void earnDiceMoney()
    {
        if (victory == 0)
        {
            this.balance += bets;
        }
    }
}
