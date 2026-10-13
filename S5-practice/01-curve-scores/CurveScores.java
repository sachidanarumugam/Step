/**
 * Week 5 · S5 practice · Problem 1 Hackathon Score Curve Booster
 *
 * The array parameter is the same object the caller holds, so adding the bonus
 * in place is visible without a return value.
 */
import java.util.Arrays;

public class CurveScores {
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scores[i] + bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores));
        if (!Arrays.toString(scores).equals("[80, 95, 70]")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
