/**
 * Week 1 · S1 · Problem 3 — BMI Calculator for a Team
 *
 * BMI = weight / (height * height). Status bands follow the wellness rules.
 */
public class BmiCalculator {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 25.0) {
            return "Normal";
        }
        if (bmi < 30.0) {
            return "Overweight";
        }
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %d — Height: %.2f m, Weight: %.0f kg%nBMI: %.2f | Status: %s%n",
                    i + 1, heights[i], weights[i], bmi, status);
            System.out.printf("%d | %.2f | %.0f | %.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        // Ten teammates. The first two rows are the published samples.
        double[] heights = {1.75, 1.60, 1.82, 1.55, 1.70, 1.68, 1.90, 1.58, 1.73, 1.65};
        double[] weights = {70, 90, 78, 42, 85, 60, 110, 70, 68, 54};
        printWellnessReport(heights, weights);

        double bmi1 = 70 / (1.75 * 1.75);
        double bmi2 = 90 / (1.60 * 1.60);
        if (!getBmiStatus(bmi1).equals("Normal") || !getBmiStatus(bmi2).equals("Obese")) {
            throw new AssertionError("BMI status mismatch");
        }
        if (!getBmiStatus(18.0).equals("Underweight") || !getBmiStatus(27.0).equals("Overweight")) {
            throw new AssertionError("Band mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
