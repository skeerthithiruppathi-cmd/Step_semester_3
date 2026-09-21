package step_week_7.assignment_problems;
public class TrafficLight {
    private static final String[] COLORS = {"RED", "GREEN", "YELLOW"};
    private final String id;
    private int index;

    public TrafficLight(String id) {
        this.id = id;
        this.index = 0;
    }

    public String next() {
        index = (index + 1) % COLORS.length;
        return COLORS[index];
    }

    public String getColor() {
        return COLORS[index];
    }

    public String getId() {
        return id;
    }
}