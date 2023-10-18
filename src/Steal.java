import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Steal
{
    private int stealAmount;
    Map<Integer, String> dictionary = new HashMap<>();
    Map<String, Integer> dictionaryTwo = new HashMap<>();
    private int balance;
    private String targetType;
    private final Scanner s = new Scanner(System.in);
    Random rand = new Random();
    public Steal(int balance)
    {
        putValues();
        this.balance = balance;
        System.out.println("How much do you want to steal? (Max is 10x your current balance)\nKeep in mind that you may get caught stealing and have to pay a fine for stealing!");
        stealAmount = s.nextInt();
        while (stealAmount > (10 * balance))
        {
            System.out.println("You can't steal that much money!!");
            System.out.println("How much do you want to steal?");
            stealAmount = s.nextInt();
        }
        stealEvent();
    }
    public void stealEvent()
    {
        int target = rand.nextInt(10) + 1;
        targetType = dictionary.get(target);
        specialEvents();
    }
    public void specialEvents()
    {
        intro();
        int targetValue = dictionaryTwo.get(targetType);
        switch (targetValue)
        {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
    public void intro()
    {
        System.out.println("You are trying to rob: " + targetType);
    }
    public void putValues()
    {
        dictionary.put(1,"Homeless Man");
        dictionary.put(2,"Drunk Alcoholic");
        dictionary.put(3,"A Kid");
        dictionary.put(4,"Single Mother of Three");
        dictionary.put(5,"Nintendo CEO");
        dictionary.put(6,"Elon Musk");
        dictionary.put(7,"Your Landlord");
        dictionary.put(8,"Minimum Wage Worker");
        dictionary.put(9,"Casino Owner");
        dictionary.put(10,"The President");

        dictionaryTwo.put("Homeless Man", 1);
        dictionaryTwo.put("Drunk Alcoholic", 1);
        dictionaryTwo.put("A Kid", 3);
        dictionaryTwo.put("Single Mother of Three", 4);
        dictionaryTwo.put("Nintendo CEO", 2);
        dictionaryTwo.put("Elon Musk", 2);
        dictionaryTwo.put("Your Landlord", 5);
        dictionaryTwo.put("Minimum Wage Worker", 6);
        dictionaryTwo.put("Casino Owner", 2);
        dictionaryTwo.put("The President", 2);
    }
}
