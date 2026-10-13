/**
 * Week 5 · S5 assignment · Problem 1 Fantasy Team Score Multiplier
 *
 * Captain scores are doubled. Vice-captain scores are multiplied by 1.5.
 * The caller's array is updated in place. Other positions stay unchanged.
 */
import java.util.Arrays;

public class FantasyMultipliers {
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * 2.0;
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
        if (!Arrays.toString(scores).equals("[40.0, 110.0, 30.0, 93.0]")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
