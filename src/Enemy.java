import java.util.Random;
public class Enemy extends Character
{
    private int choice;
    private int stamina;
    private int damage;
    private String desc;
    private
    Random rand = new Random();

    public Enemy(int health, int stamina)
    {
        super(health, stamina);
        this.stamina = stamina;
    }
    public void health()
    {
        if (getHealth() > 0)
        {
            System.out.println("The enemy has " + getHealth() + " health");
        }
    }
    public void enemyChoice()
    {
        if (staminaCheck())
        {
            choice = rand.nextInt(1, 4);
        }
        else
        {
            choice = 3;
        }
        switch (choice)
        {
            case 1:
                attackDesc();
                damage = moveOne(desc, rand.nextInt(15, 21));
                stamina -= loseStamina(rand.nextInt(7,11));
                break;
            case 2:
                moveTwo("he shoots you with a nerf dart but it doesn't do anything");
                damage = 0;
                break;
            case 3:
                stamina += moveThree("Your opponent downs a jack daniels", rand.nextInt(10,16));
                damage = 0;
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