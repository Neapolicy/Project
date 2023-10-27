import java.util.Random;

public class Enemy2 extends Character {
    private Random rand = new Random();

    public Enemy2(int health, int stamina) {
        super(health, stamina);
    }

    public void enemyChoice() {
        if (stamina >= 70)
        {
            if (moves >= 5)
            {
                choice = 1;
            }
            else {
                choice = rand.nextInt(1, 11);
            }
        } else
        {
            choice = 3;
        }
        if (dmgBoost)
        {
            choice = 2;
        }

        switch (choice) {
            case 1:
                if (moves >= 5)
                {
                    System.out.println("Your opponent sharpens her axe!");
                    moves = 0;
                    dmgBoost = true;
                }
                break;
            case 2:
                desc = attackDesc();
                damage = moveOne(desc, 35);
                if (dmgBoost)
                {
                    damage *= 2;
                    dmgBoost = false;
                }
                stamina -= 70;
                moves ++;
                break;
            case 3:
                if (staminaLimit(20, 100)) {
                    stamina = 40;
                    System.out.println("Your opponent starts doing some calisthenics");
                } else {
                    System.out.println("Your opponent takes a moment to recover");
                    stamina += 40;
                }
                damage = 0;
                break;
            default:
                moves++;
                moveTwo("Your opponent chuckles in confidence");
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
                return "The enemy swings at you with an axe!";
            case 2:
                return "The enemy shows you the power of her Timberlands!";
            default:
                return "The enemy attacks!";
        }
    }
}