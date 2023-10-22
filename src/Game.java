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
        System.out.println("\nWould you like to play Dice game, Slots, Coin flip, or steal from someone?\nSlots is $10 per try\nType \"quit\" to quit");
        Scanner s = new Scanner(System.in);
        String response = s.nextLine();
        response = response.toLowerCase();
        while (true)
        {
            if (response.contains("coin flip"))
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
            else if (response.contains("dice game"))
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
            else if (response.contains("slots"))
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
            else if (response.contains("steal"))
            {
                Steal steel = new Steal(w.getBalance());
                this.balance = steel.getBalance();
                w.setBalance(balance);
                System.out.println("\nYour balance is now $" + w.getBalance());
                ads.adsPrint();
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
            System.out.println("\nDice game, Slots, Coin flip, or steal from someone?\nSlots is $10 per try\nType \"quit\" to quit");
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
