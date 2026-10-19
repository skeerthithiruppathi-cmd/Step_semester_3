
public class AttendanceTracker {
    static void attendanceSummary(int[] days) {
        int present = 0, streak = 0, max = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;
                if (streak > max)
                    max = streak;
            } else {
                streak = 0;
            }
        }

        System.out.println("Present: " + present + ", Longest streak: " + max);
    }

    public static void main(String[] args) {
        int[] days = {1, 1, 0, 1, 1, 1, 0, 1};
        attendanceSummary(days);
    }
}
