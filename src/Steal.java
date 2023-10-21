import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Steal
{
    private int riskLevel;
    private int targetValue = 5;
    private int temp;
    Map<Integer, String> dictionary = new HashMap<>();
    Map<String, Integer> dictionaryTwo = new HashMap<>();
    private int balance;
    private int targetLevel;
    private String targetType;
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
        switch (targetValue) {
            case 1, 2, 6, 5, 4, 3 -> eventOne();
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
        dictionary.put(5,"High Salary Worker");
        dictionary.put(6,"Elon Musk");
        dictionary.put(7,"Your Landlord");
        dictionary.put(8,"Minimum Wage Worker");
        dictionary.put(9,"Casino Owner");
        dictionary.put(10,"The President");

        dictionaryTwo.put("Homeless Man", 1);
        dictionaryTwo.put("Drunk Alcoholic", 1);
        dictionaryTwo.put("A Kid", 2);
        dictionaryTwo.put("Single Mother of Three", 3);
        dictionaryTwo.put("Minimum Wage Worker", 3);
        dictionaryTwo.put("High Salary Worker", 4);
        dictionaryTwo.put("Your Landlord", 5);
        dictionaryTwo.put("Casino Owner", 5);
        dictionaryTwo.put("Elon Musk", 6);
        dictionaryTwo.put("The President", 6);
    }
    public void loseMoney()
    {
        temp = rand.nextInt(50, 201) * targetValue;
        balance -= temp;
        System.out.println("Wow! You failed to rob " + targetType + " and now have to pay a fine of $" + temp);
    }
    public void reroll()
    {
        int eventChance = rand.nextInt(3) + 1;
        switch (eventChance)
        {
            case 1 ->
            {
                eventDesc = changeDesc();
                targetLevel = 95 - (15 * (targetValue));
            }
            case 2 ->
            {
                eventDesc = changeDesc();
                targetLevel = 93 - (15 * (targetValue));
            }
            case 3 ->
            {
                eventDesc = changeDesc();
                targetLevel = 91 - (15 * (targetValue));
            }
        }
    }
    public int roll()
    {
        return rand.nextInt(1,4);
    }
    public String personEvent(String string1, String string2, String string3)
    {
        int roll = roll();
        switch (roll)
        {
            case 1:
            {
                return string1;
                break;
            }
            case 2:
            {
                return string2;
                break;
            }
            case 3:
            {
                return string3;
                break;
            }
        }
        return null;
    }
    public String changeDesc()
    {
        switch(targetValue)
        {
            case 1, 2:
            {
                personEvent("is currently singing.","is currently sleeping.","is currently walking the streets.");
                break;
            }
            case 3:
            {
                personEvent("is currently returning home from work.","is currently walking home with groceries.","is currently sleeping.");
                break;
            }
            case 4:
            {
                personEvent("is getting that thong out they bussy, play'a.","is currently working.","is currently out partying with friends.");
                break;
            }
            case 5:
            {
                personEvent("is collecting money from their patrons.", "is gambling.", "is currently collecting their obligated tip");
                break;

            }
            case 6:
            {
                personEvent("is buying their fifth yacht.", "is partying out on a private cruise ship", "is in an important meeting");
                break;
            }
        }
    }
    public void eventOne()
    {
        reroll();
        System.out.println(targetType + " " + eventDesc);
        System.out.println("Do you wish to rob, wait and see, or leave?");
        String answer = s.nextLine();
        boolean times = true;
        while (true)
        {
            if (answer.contains("rob"))
            {
                int rollVal = rand.nextInt(1, 100) + 1;
                if (rollVal <= targetLevel)
                {
                    temp = rand.nextInt(50, 201) * factorial(targetValue);
                    balance += temp;
                    System.out.println("Congratulations! You successfully robbed: " + targetType);
                    System.out.println("You successfully stole $" + temp + " from " + targetType);

                }
                else
                {
                    loseMoney();
                }
                break;
            }
            else if (answer.contains("wait"))
            {
                if (!times)
                {
                    System.out.println("You have lost your target.");
                    loseMoney();
                    break;
                }
                else
                {
                    times = false;
                    reroll();
                    System.out.println(targetType + " " + eventDesc);
                }
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
        return 1;
    }
    public int getBalance()
    {
        return balance;
    }
}