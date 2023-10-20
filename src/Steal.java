import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Steal
{
    private int riskLevel;
    private int targetValue = 5;
    Map<Integer, String> dictionary = new HashMap<>();
    Map<String, Integer> dictionaryTwo = new HashMap<>();
    private int balance;
    private int rollVal;
    private int targetLevel;
    private String targetType;
    private int eventChance;
    private String eventDesc;
    private final Scanner s = new Scanner(System.in);
    Random rand = new Random();
    public Steal(int balance)
    {
        putValues();
        this.balance = balance;
        System.out.println("Select your risk level, from 1-10");
        riskLevel = s.nextInt();
        while (riskLevel > 10 || riskLevel < 1)
        {
            System.out.println("Invalid risk level");
            System.out.println("Select your risk level, from 1-10");
            riskLevel = s.nextInt();
        }
        stealEvent();
    }
    public void stealEvent()
    {
        targetType = dictionary.get(riskLevel);
        intro();
    }
    public void specialEvents()
    {
        targetValue = dictionaryTwo.get(targetType);
        switch (targetValue)
        {
            case 1:
                eventOne();
                break;
            case 2:
                eventOne();
                break;
            case 3:
                eventOne();
                break;
            case 4:
                eventOne();
                break;
            case 5:
                eventOne();
                break;
            case 6:
                eventOne();
                break;
        }
    }
    public void intro()
    {
        System.out.println("You are trying to rob: " + targetType);
        System.out.println("Would you like to proceed?");
        String answer = s.nextLine(); // Trust me this is absolutely necessary because if this line isn't included it won't take your response
        answer = s.nextLine();
        while (true)
        {
            if (answer.contains("ye"))
            {
                specialEvents();
                break;
            }
            else if (answer.contains("no"))
            {
                System.out.print("You backed out, coward.");
                break;
            }
            System.out.println("Would you like to proceed?\n");
            answer = s.nextLine();
        }
    }
    public void putValues()
    {
        dictionary.put(1,"Homeless Man");
        dictionary.put(2,"Drunk Alcoholic");
        dictionary.put(3,"A Kid");
        dictionary.put(4,"Single Mother of Three");
        dictionary.put(5,"Salary Worker");
        dictionary.put(6,"Elon Musk");
        dictionary.put(7,"Your Landlord");
        dictionary.put(8,"Minimum Wage Worker");
        dictionary.put(9,"Casino Owner");
        dictionary.put(10,"The President");

        dictionaryTwo.put("Homeless Man", 1);
        dictionaryTwo.put("Drunk Alcoholic", 1);
        dictionaryTwo.put("A Kid", 2);
        dictionaryTwo.put("Single Mother of Three", 3);
        dictionaryTwo.put("Salary Worker", 4);
        dictionaryTwo.put("Elon Musk", 4);
        dictionaryTwo.put("Your Landlord", 5);
        dictionaryTwo.put("Minimum Wage Worker", 3);
        dictionaryTwo.put("Casino Owner", 6);
        dictionaryTwo.put("The President", 6);
    }
    public void reroll()
    {
        eventChance = rand.nextInt(3) + 1;
        switch (eventChance)
        {
            case 1:
                eventDesc = "is currently sleeping.";
                targetLevel = 95;
                break;
            case 2:
                eventDesc = "is currently walking the streets.";
                targetLevel = 60;
                break;
            case 3:
                eventDesc = "is currently harassing a pedestrian.";
                targetLevel = 50;
                break;
        }

    }
    public void eventOne()
    {
        reroll();
        System.out.println(targetType + " " + eventDesc);
        System.out.println("Do you wish to rob, wait, or leave?");
        String answer = s.nextLine();
        while (true)
        {
            if (answer.contains("rob"))
            {
                rollVal = rand.nextInt(1, 100) + 1;
                int temp;
                if (rollVal <= targetLevel)
                {
                    temp = rand.nextInt(50, 201) * factorial(targetValue);
                    balance += temp;
                    System.out.println("Congratulations! You successfully robbed: " + targetType);
                    System.out.println("You successfully stole $" + temp + " from " + targetType);

                }
                else
                {
                    temp = rand.nextInt(50, 201) * targetValue;
                    balance -= temp;
                    System.out.println("Wow! You failed to rob " + targetType + " and now have to pay a fine of $" + temp);
                }
                break;
            }
            else if (answer.contains("wait"))
            {
                reroll();
                System.out.println(targetType + " " + eventDesc);
            }
            else if (answer.contains("leave"))
            {
                System.out.println("What a coward. You can't even rob someone.\n");
                break;
            }
            System.out.println("Do you wish to rob em, wait and see, or leave?");
            answer = s.nextLine();
        }
    }
    public static int factorial(int tVal) {
        if (tVal > 0)
        {
            return tVal * (factorial(tVal - 1));
        }
        else
        {
            return 1;
        }
    }
    public int getBalance()
    {
        return balance;
    }
}
