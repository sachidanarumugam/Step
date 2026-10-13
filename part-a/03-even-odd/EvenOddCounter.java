/**
 * Week 10 · Part A · Problem 3 Even and Odd Numbers in a List
 */
public class EvenOddCounter {
    static void count(int[] numbers) {
        int even = 0;
        int odd = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }

    public static void main(String[] args) {
        count(new int[] {3, 8, 12, 5, 7, 10});
    }
}
