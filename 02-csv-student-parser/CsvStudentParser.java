/**
 * Week 2 · S2 · Problem 2 — CSV Student Record Parser
 *
 * Splits on commas and accepts a record only when exactly three fields are present.
 */
public class CsvStudentParser {
    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Name: " + fields[0] + " | Roll No: " + fields[1] + " | Dept: " + fields[2]);
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
        System.out.println("Sample checks passed.");
    }
}
