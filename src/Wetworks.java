import java.util.Random;
import java.util.Scanner;
public class Wetworks
{
    private int balance;
    private final Scanner s = new Scanner(System.in);
    Random rand = new Random();
    Daler d = new Daler(100, 30);
    Enemy2 ex = new Enemy2(200, 100);

    public Wetworks(int balance) //initiates the shop and the game
    {
        this.balance = balance;
        shop();
        game();
    }
    public void game()
    {
        while (d.getHealth() > 0) {
            getInfo();

            int dalerChoice = d.choice();
            ex.enemyChoice();

            if (dalerChoice == 1 && d.stamina >= 7) {
                ex.takeDamage(d.getDamage());
                d.stamina -= 7; // Deduct stamina after the action is performed
            }
            else if (dalerChoice == 5 && d.moves >= 5)
            {
                d.moves = 0;
                ex.takeDamage(500);
            }

            if (d.getdmgReduce()) {
                d.takeDamage((int) (ex.getDamage() * 0.5));
                d.resetReduce();
            } else {
                d.takeDamage(ex.getDamage());
            }
            if (ex.health <= 0) {
                ex.health = 0; // sets enemy health to zero
                System.out.println("You successfully took down your target!");
                getBalance();
                getResults();
                break;
            }
            else if (d.health <= 0) {
                d.health = 0; // Set player's health to zero
                getBalance();
                getResults();
                break;
            }
             // Display stats at the end of the turn
        }
    }

    public boolean getResults() {
        return ex.getHealth() <= 0;
    }

    public int getBalance() {
        balance += rand.nextInt(1500, 2001);
        return balance;
    }

    public void getInfo() {
        System.out.println("Daler's stats: " + d.health + " health, " + d.stamina + " stamina");
        System.out.println("Enemy's stats: " + ex.getHealth() + " health, " + ex.getStamina() + " stamina");
    }
    public void shop() //creates a shop. Can be used to improve player stats like health and damage
    {
        System.out.println("Would you like to purchase some equipment before you begin?");
        System.out.println("You currently have $" + balance);
        String answer = s.nextLine();
        if (answer.equals("yes"))
        {
            System.out.println("Alright! Here's what's in the shop:\n(1) $50 - A Very Cool Hat (gives more health)\n(2) $50 - Some Very Interesting Sugar (gives more attack power)\n(3) $90 - Both Items (10% Discount!!)\n(4) Neither (leave shop)");
            answer = s.nextLine();
            switch (answer)
            {
                case "1":
                {
                    if (balance > 50)
                    {
                        System.out.println("You have successfully purchased A Very Cool Hat!\nYou have gained 20 more health.\n");
                        d.health += 20;
                        balance -= 50;
                    }
                    else
                    {
                        System.out.println("You're too poor!! This cool hat is too cool for you!! Get out of my shop!!!\n");
                    }
                    break;
                }
                case "2":
                {
                    if (balance > 50)
                    {
                        System.out.println("You have successfully purchased Some Very Interesting Sugar!\nYou have gained 10 more attack power.\n");
                        d.addOn += 10;
                        balance -= 50;
                    }
                    else
                    {
                        System.out.println("If you can afford my co- *cough* sugar then get out!!!\n");
                    }
                    break;
                }
                case "3":
                {
                    if (balance > 90)
                    {
                        System.out.println("You decided to buy both items.\nHealth has increased by 20! \nAttack power has increased by 10!\n");
                        d.addOn += 10;
                        d.health += 20;
                        balance -= 90;
                    }
                    else
                    {
                        System.out.println("What do you mean buy both? You're too broke for that! Get out of here!");
                    }
                    break;
                }
                default:
                    System.out.println("You bought nothing and left.\n");
                    break;
            }
        }
    }
}