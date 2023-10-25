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

    public void choice() {
        Stats();
        System.out.println("Pick your move");
        System.out.println("British Handshake (1) \nAt The Ready (2)\nRedbull (3) \nBlock (4) \nMiss Travailer (5)");
        int answer = s.nextInt();
        switch (answer) {
            case 1:
                if (staminaCheck()) {
                    moveOne("You give your enemy a firm handshake", rand.nextInt(15, 25));
                    loseStamina(10);
                    moves++;
                }
                break;
            case 2:
                if (staminaCheck()) {
                    if (dmgBoost) {
                        System.out.println("You've already enhanced your next attack!");
                    } else {
                        moveTwo();
                        stamina -= loseStamina(5);
                    }
                }
                break;
            case 3:
                stamina += moveThree("You crack open a nice cold can of redbull", rand.nextInt(10, 16));
                break;
            case 4:
                if (staminaCheck()) {
                    if (dmgReduce) {
                        System.out.println("You've already raised your guard!");
                    } else {
                        moveFour();
                        stamina -= loseStamina(5);
                    }
                }
                break;
            case 5:
                if (moves >= 5) {
                    missTravailer();
                    moves = 0;
                } else {
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
        if (stamina > 0) {
            return true;
        } else {
            System.out.print("You're exhausted");
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
}