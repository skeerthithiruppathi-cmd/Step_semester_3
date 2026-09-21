package step_week_7.assignment_problems;
public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount < 0) {
            return;
        }
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        if (amount < 0) {
            return;
        }
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }
}