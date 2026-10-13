/**
 * Week 10 · Part A · Problem 6 Prime Number Checker
 *
 * Trial division stops at sqrt(n).
 */
public class PrimeChecker {
    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int factor = 2; factor * factor <= number; factor++) {
            if (number % factor == 0) {
                return false;
            }
        }
        return true;
    }

    static void report(int number) {
        System.out.println(number + (isPrime(number) ? " is prime" : " is not prime"));
    }

    public static void main(String[] args) {
        report(29);
        report(21);
        if (!isPrime(29) || isPrime(21)) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
