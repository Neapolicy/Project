public class game
{
    public game()
    {
        Player p = new Player();
        p.welcome();
        p.playerPreference();
        wallet w = new wallet();
        int wager = (int) w.getBets();
        int dilla = w.getBalance();
        p.playerGuess();
        p.timesFlip(wager);
        System.out.println("Your balance is now " + w.getBalance() + " dollars");
    }
}
