/**
 * Week 5 · S5 practice · Problem 5 Placement Drive Shortlisting & Ranking Engine
 *
 * Thresholds chosen to match the sample:
 *   CGPA-only eligibility: CGPA >= 7.5
 *   Combined eligibility:  CGPA >= 6.5 and coding score >= 60
 * Composite score = cgpa * 10 + codingScore / 2.0
 *   Aisha 8.2 / 40 -> 102.0, Rohit 6.8 / 65 -> 100.5, Karan 7.5 / 20 -> 85.0
 * Meena (6.0, 90) fails both checks.
 * Ranking uses Candidate.compareTo and Arrays.sort only.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlacementShortlist {
    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double composite() {
            return cgpa * 10.0 + codingScore / 2.0;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.composite(), this.composite());
        }
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa) || isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted.add(candidate);
            }
        }
        Candidate[] ranked = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(ranked);
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < ranked.length; i++) {
            if (i > 0) {
                line.append(" | ");
            }
            line.append(i + 1).append(". ")
                    .append(ranked[i].name)
                    .append(" (")
                    .append(String.format("%.1f", ranked[i].composite()))
                    .append(")");
        }
        return line.toString();
    }

    public static void main(String[] args) {
        String result = shortlistAndRank(new Candidate[] {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        });
        System.out.println(result);
        if (!result.equals("1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)")) {
            throw new AssertionError("Sample mismatch: " + result);
        }
        System.out.println("Sample checks passed.");
    }
}
