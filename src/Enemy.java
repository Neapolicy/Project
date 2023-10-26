import java.util.Random;
public class Enemy extends Character
{
    private int choice;
    private int damage;
    private String desc;
    private Random rand = new Random();

    public Enemy(int health, int stamina)
    {
        super(health, stamina);
    }
    public void enemyChoice()
    {
        if (staminaCheck(7))
        {
            choice = rand.nextInt(1, 11);
        }
        else
        {
            choice = 3;
        }
        switch (choice)
        {
            case 2:
                moveTwo("he shoots you with a nerf dart but it doesn't do anything");
                damage = 0;
                break;
            case 3:
                if (staminaLimit(20, 40))
                {
                    stamina = 40;
                }
                else
                {
                    stamina += moveThree("Your opponent downs a jack daniels", 20);
                }
                damage = 0;
                break;
            default:
                attackDesc();
                damage = moveOne(desc, rand.nextInt(15, 21));
                stamina = loseStamina(7);
                break;
        }
    }
    public int getDamage()
    {
        return damage;
    }
    public void attackDesc()
    {
        int i = rand.nextInt(1, 3);
        switch (i)
        {
            case 1:
                desc = "The enemy throws out a punch!";
                break;
            case 2:
            {
                desc = "The enemy tries to kick you!";
                break;
            }
        }
    }
}