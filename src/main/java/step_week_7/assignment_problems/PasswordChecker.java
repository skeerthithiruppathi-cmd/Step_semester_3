package step_week_7.assignment_problems;
public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        }
        if (length < 10) {
            return "Medium";
        }
        return "Strong";
    }
}