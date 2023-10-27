import java.util.Random;

public class Enemy extends Character {
    private Random rand = new Random();

    public Enemy(int health, int stamina) {
        super(health, stamina);
    }

    public void enemyChoice() {
        if (stamina >= 7) {
            choice = rand.nextInt(1, 11);
        } else {
            choice = 3;
        }
        switch (choice) {
            case 2:
                moveTwo("he shoots you with a nerf dart but it doesn't do anything");
                damage = 0;
                break;
            case 3:
                if (staminaLimit(20, 40)) {
                    stamina = 40;
                    System.out.println("Your opponent is hungover");
                } else {
                    System.out.println("Your opponent downs a jack daniels");
                    stamina += 20;
                }
                damage = 0;
                break;
            default:
                desc = attackDesc();
                damage = moveOne(desc, rand.nextInt(15, 21));
                stamina -= 7;
                break;
        }
    }

    public int getDamage() {
        return damage;
    }

    public String attackDesc() {
        int i = rand.nextInt(1, 3);
        switch (i) {
            case 1:
                return "The enemy throws out a punch!";
            case 2:
                return "The enemy tries to kick you!";
            default:
                return "The enemy attacks!";
        }
    }
}