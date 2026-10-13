/**
 * Week 10 · Part A · Problem 8 Student Grade Assignment
 *
 * A >= 90, B 75-89, C 60-74, D 40-59, F below 40.
 */
public class StudentGrade {
    static String grade(int marks) {
        if (marks >= 90) {
            return "A";
        }
        if (marks >= 75) {
            return "B";
        }
        if (marks >= 60) {
            return "C";
        }
        if (marks >= 40) {
            return "D";
        }
        return "F";
    }

    public static void main(String[] args) {
        for (int marks : new int[] {72, 95, 35}) {
            System.out.println("Grade " + grade(marks));
        }
        if (!grade(72).equals("C") || !grade(95).equals("A") || !grade(35).equals("F")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
