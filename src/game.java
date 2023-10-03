public class game
{
    private String guess;
    private int tails;
    private int heads;
    private int balance;
    private int wager;
    public game()
    {
        Player p = new Player();
        System.out.println(p);
        p.welcome();
        p.playerPreference();
        wallet w = new wallet();
        p.playerGuess();
        p.timesFlip();
        balance = w.getBalance();
        wager = (int) w.getBets();
        heads = p.getHeads();
        tails = p.getTails();
        guess = p.getResponse();
        loseMoney();
        earnMoney();
        w.setBalance(balance);
        checkDebt();
        System.out.println("Your balance is now " + w.getBalance() + " dollars");
    }
    public void loseMoney()
    {
        if (guess.equals("heads"))
        {
            for(int i = 0; i < tails; i+= 1)
            {
                balance -= wager;
            }
        }
        else
        {
            for(int i = 0; i < heads; i+= 1)
            {
                balance -= wager;
            }
        }
    }
    public void earnMoney()
    {
        if (guess.equals("heads"))
        {
            for(int i = 0; i < heads; i+= 1)
            {
                balance += wager;
            }
        }
        else
        {
            for(int i = 0; i < tails; i+= 1)
            {
                balance += wager;
            }
        }
    }
    public void checkDebt()
    {
        if (balance >= 0)
        {
            System.out.println("No money left :(, you can no longer gamble your life savings");
        }
    }
}
