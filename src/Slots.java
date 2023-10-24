import java.util.Random;
import java.util.Arrays;
public class Slots
{
    Random rand = new Random();
    int jackpot = 100000;
    int[] slotValues = {};
    private int tally;
    public void slotIntro()
    {
        System.out.println("\nSo you picked slots, huh? \nThere will be NO refunds.");
        System.out.println("The winning numbers are : 777");
    }

    //generates a string with 3 random numbers. These will be the result for the slot machine
    public void generateSlot()
    {
        slotValues = new int[]{};
        for(int i = 0; i < 3; i+= 1)
        {
            int random_int = rand.nextInt(10);
            slotValues = Arrays.copyOf(slotValues, slotValues.length + 1);
            slotValues[slotValues.length - 1] = random_int;
        }
        System.out.println("Here are the results: " + Arrays.toString(slotValues));
    }
    public int slotWinOrLose()
    {
        for(int i = 0; i < slotValues.length; i++)
        {
            if (slotValues[i] == 7)
            {
                tally ++;
            }
            else
            {
                tally = 0; // resets the counter everytime you roll, so you don't win when you're not supposed to
            }
        }
        if (tally == slotValues.length)
        {
            tally = 0;
            return 0;
        }
        return 1;
    }
    public void setJackpot(int value)
    {
        if (value == 1)
        {
            jackpot += 1000;
        }
        if (value == 0)
        {
            jackpot = 100000;
        }
    }
    public int getJackpot()
    {
        return jackpot;
    }
}
