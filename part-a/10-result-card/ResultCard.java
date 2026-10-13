/**
 * Week 10 · Part A · Problem 10 Student Result Card Generator
 *
 * Average of three marks. Grade B at 75 or above, D from 40 through 59.
 * The remaining bands used here are A (90+), C (60-74), and F (below 40).
 * The name is printed in capitals.
 */
public class ResultCard {
    static class Student {
        private final String name;
        private final int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            int sum = 0;
            for (int mark : marks) {
                sum += mark;
            }
            return (double) sum / marks.length;
        }

        String grade() {
            double average = average();
            if (average >= 90) {
                return "A";
            }
            if (average >= 75) {
                return "B";
            }
            if (average >= 60) {
                return "C";
            }
            if (average >= 40) {
                return "D";
            }
            return "F";
        }

        void printCard() {
            System.out.printf("%s: Average %.1f, Grade %s%n",
                    name.toUpperCase(), average(), grade());
        }
    }

    public static void main(String[] args) {
        new Student("Asha", new int[] {80, 90, 70}).printCard();
        new Student("Ravi", new int[] {60, 55, 50}).printCard();
    }
}
