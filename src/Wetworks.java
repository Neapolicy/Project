import java.util.Random;

public class Wetworks {
    private int balance;
    private final Scanner s = new Scanner(System.in);
    Random rand = new Random();
    Daler d = new Daler(100, 30);
    Enemy2 ex = new Enemy2(200, 100);

    public Wetworks() {
        game();
    }
    public void game() {
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
        balance += rand.nextInt(100, 200);
        return balance;
    }

    public void getInfo() {
        System.out.println("Daler's stats: " + d.health + " health, " + d.stamina + " stamina");
        System.out.println("Enemy's stats: " + ex.getHealth() + " health, " + ex.getStamina() + " stamina");
    }
}