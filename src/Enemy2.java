import java.util.Random;

public class Enemy2 extends Character {
    private int choice;
    private int damage;
    private int pity;
    private String desc;
    private Random rand = new Random();

    public Enemy2(int health, int stamina) {
        super(health, stamina);
    }

    public void enemyChoice() {
        if (stamina >= 70) {
            if (pity == 5)
            {
                choice = 2;
                pity = 0;
            }
            else
            {
                choice = rand.nextInt(1, 11);
            }
        } else {
            choice = 3;
        }
        switch (choice) {
            case 1:
                if (moves >= 3)
                {
                    System.out.println("Your opponent sharpens her axe!");
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
                pity++;
                moveTwo("Your opponents swings her axe around");
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
                return "The enemy gives you the power of her boot!";
            default:
                return "The enemy attacks!";
        }
    }
}