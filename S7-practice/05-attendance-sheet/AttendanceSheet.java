/**
 * Week 7 · S7 practice · Problem 5 The Attendance Sheet
 *
 * Names live in a private array. Callers can ask for a count or a yes/no lookup.
 * Marking the same name twice does not increase the count.
 */
public class AttendanceSheet {
    private final String[] present;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.present = new String[maxClassSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name) || count == present.length) {
            return;
        }
        present[count] = name;
        count++;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (present[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("isPresent(Ben) -> " + sheet.isPresent("Ben"));
        System.out.println("isPresent(Chen) -> " + sheet.isPresent("Chen"));
        if (sheet.getPresentCount() != 2 || !sheet.isPresent("Ben") || sheet.isPresent("Chen")) {
            throw new AssertionError("Attendance mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
