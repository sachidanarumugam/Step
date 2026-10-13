/**
 * Week 1 · S1 · Problem 1 — Rock-Paper-Scissors Game
 *
 * Plays N rounds, records every result, and prints a scoreboard.
 * Computer moves are random unless a fixed list is supplied (used here so the
 * sample scoreboard is reproducible).
 */
import java.util.Random;

public class RockPaperScissors {
    static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    /** Returns "Player Wins", "Computer Wins", or "Draw". */
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                        || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                        || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    static String randomMove(Random random) {
        return MOVES[random.nextInt(MOVES.length)];
    }

    static void playMatch(String[] playerMoves, String[] computerMoves) {
        int n = playerMoves.length;
        String[] results = new String[n];
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < n; i++) {
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            System.out.printf("Round %d — Player: %s, Computer: %s%n%s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
            System.out.printf("%d | %s | %s | %s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercent = n == 0 ? 0.0 : (wins * 100.0) / n;
        System.out.printf("Final Summary (after %d rounds)%n", n);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercent);
    }

    public static void main(String[] args) {
        // Fixed demo that matches the published sample (2 wins, 2 losses, 1 draw).
        String[] player = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computer = {"Scissors", "Paper", "Rock", "Paper", "Rock"};
        playMatch(player, computer);

        if (!playRound("Rock", "Scissors").equals("Player Wins")
                || !playRound("Paper", "Paper").equals("Draw")
                || !playRound("Scissors", "Rock").equals("Computer Wins")) {
            throw new AssertionError("playRound rules failed");
        }
        System.out.println("Sample checks passed.");
    }
}
