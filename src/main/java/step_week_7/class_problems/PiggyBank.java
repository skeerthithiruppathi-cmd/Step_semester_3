package step_week_7.class_problems;
import java.util.Scanner;
public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
            return true;
        }
        return false;
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}