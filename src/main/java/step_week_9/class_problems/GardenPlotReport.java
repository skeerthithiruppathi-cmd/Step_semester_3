import java.util.*;

abstract class GardenPlot {
    protected String owner;
    protected String shape;
    GardenPlot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }
    abstract double area();
    String label() { return owner + " (" + shape + ")"; }
}

class CirclePlot extends GardenPlot {
    private double radius;
    CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }
    double area() { return Math.PI * radius * radius; }
}

class RectanglePlot extends GardenPlot {
    private double length, width;
    RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }
    double area() { return length * width; }
}

class TrianglePlot extends GardenPlot {
    private double base, height;
    TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }
    double area() { return 0.5 * base * height; }
}

class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<GardenPlot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            if (shape.equals("CIRCLE")) plots.add(new CirclePlot(owner, sc.nextDouble()));
            else if (shape.equals("RECTANGLE")) plots.add(new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble()));
            else plots.add(new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble()));
        }
        double total = 0;
        for (GardenPlot p : plots) {
            double a = p.area();
            total += a;
            System.out.println(p.label() + ": " + String.format("%.2f", a));
        }
        System.out.println("Total Area: " + String.format("%.2f", total));
    }
}