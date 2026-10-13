/**
 * Week 10 · Part A · Problem 9 Leap Year Detector
 *
 * Divisible by 4, but not by 100, unless also divisible by 400.
 */
public class LeapYear {
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    static void report(int year) {
        System.out.println(isLeapYear(year) ? "Leap year" : "Not a leap year");
    }

    public static void main(String[] args) {
        report(2024);
        report(1900);
        report(2000);
        if (!isLeapYear(2024) || isLeapYear(1900) || !isLeapYear(2000)) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
