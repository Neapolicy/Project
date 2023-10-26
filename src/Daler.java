import java.util.Scanner;
import java.util.Random;

public class Daler extends Character {
    private int damage;
    Random rand = new Random();
    int moves;
    private boolean dmgBoost = false;
    private boolean dmgReduce = false;
    private final Scanner s = new Scanner(System.in);

    public Daler(int health, int stamina) {
        super(health, stamina);
    }

    public int choice() {
        System.out.println("\nPick your move");
        System.out.println("(1) British Handshake\n(2) At The Ready\n(3) Redbull\n(4) Block\n(5) ULTIMATE(Miss Travailer)");
        int answer = s.nextInt();
        switch (answer) {
            case 1:
                if (staminaCheck(7)) {
                    damage = moveOne("You give your enemy a firm handshake", rand.nextInt(15, 25));
                    stamina = loseStamina(7);
                    moves++;
                }
                break;
            case 2:
                if (staminaCheck(4)) {
                    if (dmgBoost) {
                        System.out.println("You've already enhanced your next attack!");
                    } else {
                        moveTwo();
                        moves++;
                    }
                }
                break;
            case 3:
                if (stamina + 7 >= 30) {
                    System.out.println("What are you doing?! You're fully energized!");
                    stamina = 30;
                } else {
                    stamina += moveThree("You crack open a nice cold can of redbull", 7);
                }
                break;
            case 4:
                if (dmgReduce) {
                    System.out.println("You've already raised your guard!");
                } else {
                    moveFour();
                    moves++;
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
        return answer;
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

    public boolean staminaCheck(int staminaCost) {
        if (stamina - staminaCost > 0) {
            return true;
        } else {
            System.out.println("You're exhausted ");
            return false;
        }
    }

    public void moveFour() {
        System.out.println("You raise your guard");
        dmgReduce = true;
    }

    public int getDamage() {
        return damage;
    }

    public boolean getdmgReduce() {
        return dmgReduce;
    }

    public boolean getdmgBoost() {
        return dmgBoost;
    }

    public void resetReduce() {
        dmgReduce = false;
    }

    public void resetBoost() {
        dmgBoost = false;
    }
}