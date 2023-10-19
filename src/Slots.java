import java.util.Random;
import java.util.Arrays;
public class Slots
{
    Random rand = new Random();
    int jackpot = 1000000;
    int[] slotValues = {};
    private int tally;
    public void slotIntro()
    {
        System.out.println("So you picked slots, huh? \nThere will be NO refunds.");
        System.out.println("The winning numbers are : 777");
    }

    //generates a string with 3 random numbers. These will be the result for the slot machine
    public void generateSlot()
    {
        slotValues = new int[]{};
        for(int i = 0; i < 3; i+= 1)
        {
            int random_int = rand.nextInt(6) + 1;
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
        }
        if (tally == slotValues.length)
        {
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
            jackpot = 1000000;
        }
    }
    public int getJackpot()
    {
        return jackpot;
    }
}
