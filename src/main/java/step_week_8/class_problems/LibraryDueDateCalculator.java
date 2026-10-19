import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;
    LibraryItem(String title) { this.title = title; }
    abstract int borrowDays();
    String dueDate(LocalDate today) { return today.plusDays(borrowDays()).toString(); }
    String getTitle() { return title; }
}

class Book extends LibraryItem {
    Book(String title) { super(title); }
    int borrowDays() { return 14; }
}

class Dvd extends LibraryItem {
    Dvd(String title) { super(title); }
    int borrowDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    int borrowDays() { return 3; }
}

class LibraryDueDateCalculator {
    static LibraryItem create(String type, String title) {
        switch (type) {
            case "BOOK": return new Book(title);
            case "DVD": return new Dvd(title);
            default: return new Magazine(title);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate today = LocalDate.of(2023, 10, 26);
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
            items.add(create(type, title));
        }
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.dueDate(today));
        }
    }
}