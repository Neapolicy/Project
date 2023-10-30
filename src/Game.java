import java.util.Scanner;
public class Game
{
    private String guess;
    private int timesGambled;
    private String txt = "\nWould you like to play Dice game, Slots, Coin flip";
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
    public Game() throws InterruptedException
    { // This is where the game is run, where you can make terrible life choices
        System.out.println("Your current balance is $" + w.getBalance());
        p.welcome();
        System.out.println(txt + "\nOr leave?\nSlots is $10 per spin");
        Scanner s = new Scanner(System.in);
        String response = s.nextLine();
        response = response.toLowerCase();
        while (true)
        {
            if (response.contains("coin"))
            {
                coinFlipGame();
            }
            else if (response.contains("dice"))
            {
                diceGame();
            }
            else if (response.contains("slot"))
            {
                slotsGame();
            }
            else if (response.contains("steal") && (timesGambled >= 6))
            {
                Steal steel = new Steal(w.getBalance());
                this.balance = steel.getBalance();
                w.setBalance(balance);
                System.out.println("\nYour balance is now $" + w.getBalance());
                ads.adsPrint();
            }
            else if (response.contains("job") && (timesGambled >= 8))
            {
                Wetworks wet = new Wetworks(w.getBalance());
                if (wet.getResults())
                {
                    balance = wet.getBalance();
                    w.setBalance(balance);
                    System.out.println("\nYour balance is now $" + w.getBalance());
                }
                else {
                    System.out.println("Unfortunately, you have been sent to the depths, good luck getting out of there you sorry sod");
                    break;
                }
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
            l.loreReveal(timesGambled);
            if(timesGambled == 8)
            {
                txt += ", or job?";
            }
            if (timesGambled == 6)
            {
                txt += ", Steal";
            }
            System.out.println(txt + "\nOr leave?\nSlots is $10 per spin");
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
