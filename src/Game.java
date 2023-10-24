import java.util.Scanner;
public class Game
{
    private String guess;
    private int timesGambled = 1;
    private int tails;
    private int heads;
    private int balance;
    private double bets;
    private int victory;
    Slots slot = new Slots();
    Wallet w = new Wallet();
    Advertisements ads = new Advertisements();
    Player p = new Player();
    Lore l = new Lore();
    public Game()
    {
        System.out.println("Your current balance is $" + w.getBalance());
        p.welcome();
        System.out.println("\nWould you like to play Dice game, Slots, Coin flip\nSlots is $10 per try\nType \"quit\" to quit");
        Scanner s = new Scanner(System.in);
        String response = s.nextLine();
        response = response.toLowerCase();
        while (true)
        {
            if (response.contains("coin"))
            {
                coinFlipGame();
                l.loreReveal(timesGambled);
            }
            else if (response.contains("dice"))
            {
                diceGame();
                l.loreReveal(timesGambled);
            }
            else if (response.contains("slot"))
            {
                slotsGame();
                l.loreReveal(timesGambled);
            }
            else if (response.contains("steal") && (timesGambled >= 7))
            {
                Steal steel = new Steal(w.getBalance());
                this.balance = steel.getBalance();
                w.setBalance(balance);
                System.out.println("\nYour balance is now $" + w.getBalance());
                ads.adsPrint();
            }
            else if (response.contains("job") && (timesGambled >= 10))
            {
                System.out.println("a");
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
            System.out.println("\nDice game, Slots, Coin flip\nSlots is $10 per try\nType \"quit\" to quit");
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
                balance += (int) bets;
            }
        }
        else
        {
            for(int i = 0; i < tails; i+= 1)
            {
                balance += (int) bets;
            }
        }
    }
    public void loseDiceMoney()
    {
        if (victory == 1)
        {
            this.balance -= (int) bets;
        }
    }
    public void earnDiceMoney()
    {
        if (victory == 0)
        {
            this.balance += (int) bets;
        }
    }
    public void slotsGame()
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
        timesGambled++;
    }
    public void coinFlipGame()
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
        timesGambled++;
    }
    public void diceGame()
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
        timesGambled++;
    }
}
