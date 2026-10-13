/**
 * Week 10 · Part A · Problem 5 Digit Sum and Number Reversal
 */
public class DigitSumReverse {
    static void report(int number) {
        int sum = 0;
        int reverse = 0;
        int remaining = number;
        while (remaining > 0) {
            int digit = remaining % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            remaining /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }

    public static void main(String[] args) {
        report(4721);
    }
}
