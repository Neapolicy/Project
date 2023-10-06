import java.util.Scanner;
import java.util.Random;
public class Dice
{
    private int[] sums = {0};
    private int prediction;
    private Scanner s = new Scanner(System.in);
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
    }
    public void roll()
    {
        Random rand = new Random();
        for(int i = 0; i < 3; i+= 1)
        {
            Integer random_int = rand.nextInt(6) + 1;
        }
    }
}
