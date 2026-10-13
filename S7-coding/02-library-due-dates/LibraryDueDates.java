/**
 * Week 7 · S7 coding · Problem 2 Library Item Due Date Calculator
 *
 * Current date is fixed at 2023-10-26. Each item type knows its own loan length.
 * The printer calls dueDate() without checking the item type.
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryDueDates {
    static final LocalDate TODAY = LocalDate.of(2023, 10, 26);

    interface LibraryItem {
        String title();
        LocalDate dueDate();
    }

    static final class Book implements LibraryItem {
        private final String title;

        Book(String title) {
            this.title = title;
        }

        public String title() {
            return title;
        }

        public LocalDate dueDate() {
            return TODAY.plusDays(14);
        }
    }

    static final class Dvd implements LibraryItem {
        private final String title;

        Dvd(String title) {
            this.title = title;
        }

        public String title() {
            return title;
        }

        public LocalDate dueDate() {
            return TODAY.plusDays(7);
        }
    }

    static final class Magazine implements LibraryItem {
        private final String title;

        Magazine(String title) {
            this.title = title;
        }

        public String title() {
            return title;
        }

        public LocalDate dueDate() {
            return TODAY.plusDays(3);
        }
    }

    static LibraryItem create(String type, String title) {
        return switch (type) {
            case "BOOK" -> new Book(title);
            case "DVD" -> new Dvd(title);
            case "MAGAZINE" -> new Magazine(title);
            default -> throw new IllegalArgumentException(type);
        };
    }

    static String titleOf(String line) {
        int first = line.indexOf('"');
        int last = line.lastIndexOf('"');
        if (first >= 0 && last > first) {
            return line.substring(first + 1, last);
        }
        return line.substring(line.indexOf(' ') + 1).trim();
    }

    static String process(String input) {
        String[] lines = input.strip().split("\\R");
        int n = Integer.parseInt(lines[0].trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String line = lines[i].trim();
            String type = line.substring(0, line.indexOf(' '));
            items.add(create(type, titleOf(line)));
        }
        StringBuilder out = new StringBuilder();
        for (LibraryItem item : items) {
            out.append(item.title()).append(": ").append(item.dueDate()).append('\n');
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String sample = """
                3
                BOOK "1984"
                DVD "The Matrix"
                MAGAZINE "Forbes Issue 500"
                """;
        String output = process(sample);
        System.out.print(output);
        String expected = """
                1984: 2023-11-09
                The Matrix: 2023-11-02
                Forbes Issue 500: 2023-10-29
                """;
        if (!output.equals(expected)) {
            throw new AssertionError("Sample mismatch:\n" + output);
        }
        System.out.println("Sample checks passed.");
    }
}
