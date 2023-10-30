import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class Dice
{
    private int[] sums = {};
    private int prediction;
    private Scanner s = new Scanner(System.in);
    private int total;
    public Dice() // constructor for dice
    {
        System.out.print("Dice eh? \nWell, here are the rules:\n");
        System.out.println("  -Predict the sum of the rolls of 3 dices correctly to win");
        System.out.println("  -Getting a 3 of the same number will cause you to win, regardless of guess\n"); // explains rules
        System.out.println("Now, make your prediction \nWill the sum be from 3-10(1), or 11-18(2)?"); // asks for user prediction
        prediction = s.nextInt();
        if (prediction > 2 || prediction < 0) // checks for an invalid input
        {
            System.out.println("Invalid input, try again");
            prediction = s.nextInt();
        }
        roll();
    }
    public void roll() // rolls "dice"
    {
        Random rand = new Random();
        for(int i = 0; i < 3; i+= 1)
        {
            int random_int = rand.nextInt(6) + 1;
            sums = Arrays.copyOf(sums, sums.length + 1);
            sums[sums.length - 1] = random_int;
        }
        System.out.println("Here are the results: " + Arrays.toString(sums));
        getSum();
    }
    public void getSum() // determines sum of the dice rolls
    {
        for(int i = 0; i < sums.length; i++)
        {
            total = sums[i] + total;
        }
        System.out.println("The sum of the dices are: " + total);
        getVictory();
    }
    public int getVictory() // checks if user has won
    {
        if (sums[0] == sums[1] && sums [1] == sums[2])
        {
            return 0;
        }
        if (total > 10 && prediction == 2)
        {
            return 0;
        }
        if (total < 11 && prediction == 1)
        {
            return 0;
        }
        return 1;
    }
}
