import java.util.Random;
public class Slots
{
    Random rand = new Random();
    String slotValues;
    int jackpot = 5000;
    public Slots()
    {
        System.out.println("So you picked slots, huh? \nThere will be NO refunds.");
    }

    //generates a string with 3 random numbers. These will be the result for the slot machine
    public String generateSlot()
    {
        while(slotValues.length() < 3)
        {
            slotValues += rand.nextInt();
        }
        System.out.println("Your 3 values are: " + slotValues);
        return slotValues;
    }
    //takes the 3 slot values generated from generateSlot():
    //returns 1 if the slot generates 3 of the same number
    //returns 2 if the slot generates 3 numbers that are in a raw
    //returns -1 if the slot generates no winning values
    //uses compareto() function rather then subtraction
    public int slotWinOrLose()
    {
        slotValues = generateSlot();
        String firstSlot = slotValues.substring(0,1);
        String secondSlot = slotValues.substring(1,2);
        String thirdSlot = slotValues.substring(2,3);
        if(firstSlot.compareTo(secondSlot) == 0 && secondSlot.compareTo(thirdSlot) == 0)
        {
            return 1;
        }
        else if(firstSlot.compareTo(secondSlot) == 1 && secondSlot.compareTo(thirdSlot) == 1)
        {
            return 2;
        }
        else if(firstSlot.compareTo(secondSlot) == -1 && secondSlot.compareTo(thirdSlot) == -1)
        {
            return 2;
        }
        else
        {
            return -1;
        }
    }
    public void slotReturn()
    {
        int winLoseResult = slotWinOrLose();
        if(winLoseResult == 1)
        {
            System.out.println("Wow... 3 of the same kind. That's impressive!");
        }
        if(winLoseResult == 2)
        {
            System.out.println("3 in a row! You have unrivaled luck!");
        }
        if(winLoseResult == -1)
        {
            System.out.println("You tried your best and failed. There are no refunds :(");
        }
    }
    //the only method that really matters.
    //if the user rolls 3 of the same number in a slot, they win
    //if the user rolls 3 in a row, they also win
    //if the user fails to meet any of the conditions, they lose
    //thinking of adding more win conditions to make the slot more fair
    //the slot hasn't been integrated into the code
    //this can most likely be integrated with player rather than being its own object
}
