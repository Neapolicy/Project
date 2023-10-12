import java.util.Random;
import java.util.Arrays;
public class Slots
{
    Random rand = new Random();
    int[] slotValues = {};
    int jackpot = 5000;
    private int tally;
    public Slots()
    {
        System.out.println("So you picked slots, huh? \nThere will be NO refunds.");
    }

    //generates a string with 3 random numbers. These will be the result for the slot machine
    public void generateSlot()
    {
        for(int i = 0; i < 3; i+= 1)
        {
            int random_int = rand.nextInt(6) + 1;
            slotValues = Arrays.copyOf(slotValues, slotValues.length + 1);
            slotValues[slotValues.length - 1] = random_int;
        }
        System.out.println("Here are the results: " + Arrays.toString(slotValues));
    }
    //takes the 3 slot values generated from generateSlot():
    //returns 1 if the slot generates 3 of the same number
    //returns 2 if the slot generates 3 numbers that are in a raw
    //returns -1 if the slot generates no winning values
    //uses compareto() function rather then subtraction
    public int slotWinOrLose()
    {
        for(int i = 0; i < slotValues.length; i++)
        {
            if (slotValues[i] == 7)
            {
                tally ++;
            }
        }
        if (tally == 3)
        {
            return 0;
        }
        return 1;
    }
    public int getJackpot()
    {
        return jackpot;
    }
    //the only method that really matters.
    //if the user rolls 3 of the same number in a slot, they win
    //if the user rolls 3 in a row, they also win
    //if the user fails to meet any of the conditions, they lose
    //thinking of adding more win conditions to make the slot more fair
    //the slot hasn't been integrated into the code
    //this can most likely be integrated with player rather than being its own object
}
