public class Lore
{
    public void loreReveal(int timesGambled)
    {
        switch (timesGambled)
        {
            case 0:
                System.out.println("\nYou wake up in what is presumably your bedroom. \nYou can't seem to recall anything, and the only thing you know how to do is to gamble.\nYou're not sure how, but you instictively walk to the nearest casino, Ferguson's Casino.\n");
                break;
            case 2:
                System.out.println("\nSuddenly, you faint. \nYou wake up in a cold sweat. \nYou seem to remember having a nightmare about some red liquid (perhaps ketchup?) on the walls of a room. ");
                break;
            case 4:
                System.out.println("\nSuddenly, out of nowhere, you seem to recall the first letter of your name.\nIt starts with the letter \"D\"");
                break;
            case 6:
                System.out.println("\nYour head starts ringing with pain. An important part of your past seems to re-emerge in your memories. \nYou remember being a professional thief, robbing even the most secure banks.\nYou finally remember your full name. You are Daler Muradov.\nStealing has been unlocked! You can now steal from other people.");
                break;
            case 8:
                System.out.println("\nYou finally remember everything after gambling for a while. \nYou are a professional hitman and used to kill people for a living.\nKilling is unlocked! You can now kill other people (don't worry, they don't die).");
                break;
        }
    }
}
