import java.util.Random;

public class Enemy2 extends Character // literally another enemy class
{
    private Random rand = new Random();
    public Enemy2(int health, int stamina)
    {
        super(health, stamina);
    }

    public void enemyChoice() // chooses what enemy does
    {
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
                    System.out.println("\nYour opponent sharpens her axe!");
                    moves = 0;
                    dmgBoost = true;
                }
                break;
            case 2, 5:
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
                if (staminaLimit(40, 100))
                {
                    stamina = 100;
                    System.out.println("\nYour opponent starts doing some calisthenics");
                }
                else
                {
                    System.out.println("\nYour opponent takes a moment to recover");
                    stamina += 40;
                }
                damage = 0;
                break;
            case 4:
                if (health < 200)
                {
                    health += 5;
                    System.out.println("\nYour opponent drinks some water, restoring 5 HP in the process!");
                }
                break;
            default:
                moves++;
                moveTwo("\nYour opponent chuckles in confidence");
                break;
        }
    }

    public int getDamage()
    {
        return damage;
    }

    public String attackDesc()
    {
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