import java.util.Scanner;
import java.util.Random;

public class Daler extends Character {
    private int health;
    private int stamina;
    private int damage;
    Random rand = new Random();
    int moves;
    private boolean dmgBoost = false;
    private boolean dmgReduce = false;
    private final Scanner s = new Scanner(System.in);

    public Daler(int health, int stamina) {
        super(health, stamina);
        this.health = health;
        this.stamina = stamina;
    }

    public void Stats() {
        System.out.println("Your hp is " + getHealth());
        System.out.println("Your stamina is " + getStamina());
        choice();
    }

    public void choice()
    {
        System.out.println("\nPick your move");
        System.out.println("(1) British Handshake\n(2) At The Ready\n(3) Redbull\n(4) Block\n(5) ULTIMATE(Miss Travailer)");
        int answer = s.nextInt();
        switch (answer) {
            case 1:
                if (staminaCheck())
                {
                    damage = moveOne("You give your enemy a firm handshake", rand.nextInt(15, 25));
                    stamina = loseStamina(7);
                    moves++;
                }
                break;
            case 2:
                if (staminaCheck())
                {
                    if (dmgBoost)
                    {
                        System.out.println("You've already enhanced your next attack!");
                        damage = 0;
                    } else
                    {
                        moveTwo();
                        stamina -= loseStamina(4);
                        damage = 0;
                    }
                }
                break;
            case 3:
                stamina += moveThree("You crack open a nice cold can of redbull", rand.nextInt(10, 16));
                damage = 0;
                break;
            case 4:
                if (staminaCheck())
                {
                    if (dmgReduce)
                    {
                        System.out.println("You've already raised your guard!");
                        damage = 0;
                    }
                    else
                    {
                        damage = 0;
                        moveFour();
                    }
                }
                break;
            case 5:
                if (moves >= 5)
                {
                    missTravailer();
                    moves = 0;
                }
                else
                {
                    System.out.println("Your hands tremble, you aren't ready yet.");
                }
                break;
        }
    }

    public int missTravailer() // this is your ult
    {
        damage = moveOne("You express your right to the second amendment", 500);
        return damage;
    }

    public void moveTwo() {
        System.out.println("You steady yourself for your next attack");
        dmgBoost = true;
    }

    public boolean staminaCheck() {
        if (stamina > 0)
        {
            return true;
        }
        else
        {
            stamina = 0;
            damage = 0;
            System.out.println("You're exhausted ");
            return false;
        }
    }

    public void moveFour() {
        System.out.println("You raise your guard");
        dmgReduce = true;
    }

    public int getHealth() {
        return health;
    }
    public int getDamage()
    {
        return damage;
    }
    public boolean getdmgReduce()
    {
        return dmgReduce;
    }
    public boolean getdmgBoost()
    {
        return dmgBoost;
    }
}