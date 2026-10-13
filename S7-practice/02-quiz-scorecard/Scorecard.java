/**
 * Week 7 · S7 practice · Problem 2 The Quiz Scorecard
 *
 * Results stay in a private array. Callers only receive the count of correct answers.
 */
public class Scorecard {
    private final boolean[] results;
    private int recorded;

    public Scorecard(int questionCount) {
        this.results = new boolean[questionCount];
        this.recorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recorded >= results.length) {
            return;
        }
        results[recorded] = correct;
        recorded++;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        System.out.println("getScore() -> " + sc.getScore());
        if (sc.getScore() != 3) {
            throw new AssertionError("Score mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
