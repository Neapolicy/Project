import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Dice
{
    private int[] sums = {};
    private int prediction;
    private Scanner s = new Scanner(System.in);
    private boolean lose = false;
    private int total = 0;
    public Dice()
    {
        System.out.print("Dice eh? \nWell, here are the rules:");
        System.out.println("Predict the sum of the rolls of 3 dices correctly to win");
        System.out.println("Getting a 3 of the same number will cause you to win, regardless of guess");
        System.out.println("Now, make your prediction \nWill the sum to from 3-10(1), or 11-18(2)?");
        prediction = s.nextInt();
        if (prediction > 2 || prediction < 0)
        {
            System.out.println("Invalid input");
            prediction = s.nextInt();
        }
        roll();
    }
    public void roll()
    {
        Random rand = new Random();
        for(int i = 0; i < 3; i+= 1)
        {
            int random_int = rand.nextInt(6) + 1;
            sums = Arrays.copyOf(sums, sums.length + 1);
            sums[sums.length - 1] = random_int;
        }
        System.out.println("Here are the results: " + Arrays.toString(sums));
        getSum(sums);
    }

    public void getSum(int[] results)
    {
        for(int i = 0; i < sums.length; i++)
        {
            total = sums[i] + total;
        }
        System.out.println("The sum of the dices are: " + total);
        System.out.println(getVictory(total, prediction));
    }
    public boolean getVictory(int sum, int guess)
    {
        if (sum > 10 && guess == 2)
        {
            return true;
        }
        if (sum < 11 && guess == 1)
        {
            return true;
        }
        return false;
    }
}
