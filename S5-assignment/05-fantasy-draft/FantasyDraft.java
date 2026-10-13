/**
 * Week 5 · S5 assignment · Problem 5 Fantasy League Auto-Draft Ranking Engine
 *
 * Thresholds chosen to match the sample:
 *   Experience-only: matchesPlayed >= 10 (fitness is ignored)
 *   Combined rule:   matchesPlayed >= 5 and not injured
 * Players are ranked by batting average, descending, via Player.compareTo
 * and Arrays.sort. Sameer (3 matches) is left out.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FantasyDraft {
    static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        List<Player> draftable = new ArrayList<>();
        for (Player player : players) {
            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {
                draftable.add(player);
            }
        }
        Player[] ranked = draftable.toArray(new Player[0]);
        Arrays.sort(ranked);
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < ranked.length; i++) {
            if (i > 0) {
                line.append(" | ");
            }
            line.append(i + 1).append(". ").append(ranked[i].name);
        }
        return line.toString();
    }

    public static void main(String[] args) {
        String result = draftAndRank(new Player[] {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        });
        System.out.println(result);
        if (!result.equals("1. Rahul | 2. Virat | 3. Dev")) {
            throw new AssertionError("Sample mismatch: " + result);
        }
        System.out.println("Sample checks passed.");
    }
}
