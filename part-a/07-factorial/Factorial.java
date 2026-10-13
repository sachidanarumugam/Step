/**
 * Week 10 · Part A · Problem 7 Factorial Calculation
 *
 * 0! is 1. The product runs from 1 through n.
 */
public class Factorial {
    static long factorial(int n) {
        long product = 1;
        for (int i = 2; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(0));
        if (factorial(5) != 120 || factorial(0) != 1) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
