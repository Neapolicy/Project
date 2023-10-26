import java.util.Random;

public class Wetworks {
    private int balance;
    Random rand = new Random();
    Daler d = new Daler(100, 30);
    Enemy e = new Enemy(100, 40);

    public Wetworks() {
        game();
    }

    public void game() {
        while (d.getHealth() > 0) {
            if (e.getHealth() <= 0) {
                System.out.println("You successfully took down your target!");
                getBalance();
                getResults();
                break;
            }

            int dalerChoice = d.choice(); // Store the player's choice
            e.enemyChoice();

            if (d.getdmgBoost() && (dalerChoice == 1) && d.staminaCheck(7)) {
                e.takeDamage((d.getDamage() * 2));
                d.resetBoost();
            }
            else if (dalerChoice == 1 && d.staminaCheck(7)) {
                e.takeDamage(d.getDamage());
            }

            if (d.getdmgReduce()) {
                d.takeDamage((int) (e.getDamage() * 0.5));
                d.resetReduce();
            } else {
                d.takeDamage(e.getDamage());
            }
            getInfo(); // Display stats at the end of the turn
        }
        getResults();
    }

    public boolean getResults() {
        return e.getHealth() <= 0;
    }

    public int getBalance() {
        balance += rand.nextInt(100, 200);
        System.out.println("Balance: " + balance); // Print the updated balance
        return balance;
    }

    public void getInfo() {
        System.out.println("Daler's stats: " + d.health + " health, " + d.stamina + " stamina");
        System.out.println("Enemy's stats: " + e.health + " health, " + e.stamina + " stamina");
    }
}