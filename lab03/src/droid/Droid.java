package droid;
import java.util.Random;

public class Droid {

    Random random = new Random();
    protected String droidType;
    protected int amountDroids;
    protected int health;
    protected int damage;
    protected String name;

    public Droid() { }

    public String getDroidType() {
        return droidType;
    }

    public void setDroidType(String droidType) {
        this.droidType = droidType;
    }

    public int getAmountDroids() {
        return amountDroids;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public void setAmountDroids(int amountDroids) {
        this.amountDroids = amountDroids;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void toDamage(Droid secondDroid) {
        secondDroid.setHealth(secondDroid.getHealth() - random.nextInt(this.damage + 1));
    }

}
