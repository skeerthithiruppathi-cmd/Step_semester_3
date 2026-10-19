import java.util.*;

abstract class BorrowedItem {
    protected String title;
    protected int daysLate;
    BorrowedItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }
    abstract double fine();
    String getTitle() { return title; }
}

class BookItem extends BorrowedItem {
    BookItem(String t, int d) { super(t, d); }
    double fine() { return 2.0 * daysLate; }
}

class DvdItem extends BorrowedItem {
    DvdItem(String t, int d) { super(t, d); }
    double fine() { return Math.min(5.0 * daysLate, 50.0); }
}

class MagazineItem extends BorrowedItem {
    MagazineItem(String t, int d) { super(t, d); }
    double fine() { return 1.0 * daysLate; }
}

class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<BorrowedItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            if (type.equals("BOOK")) items.add(new BookItem(title, days));
            else if (type.equals("DVD")) items.add(new DvdItem(title, days));
            else items.add(new MagazineItem(title, days));
        }
        double total = 0;
        for (BorrowedItem item : items) {
            double f = item.fine();
            total += f;
            System.out.println(item.getTitle() + ": " + String.format("%.2f", f));
        }
        System.out.println("Total Fines: " + String.format("%.2f", total));
    }
}