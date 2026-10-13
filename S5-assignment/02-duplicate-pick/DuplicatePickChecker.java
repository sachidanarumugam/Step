/**
 * Week 5 · S5 assignment · Problem 2 Duplicate Player Pick Checker
 *
 * Nested loops only. Case-sensitive. First duplicate in scan order is reported.
 */
public class DuplicatePickChecker {
    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String a = findDuplicatePick(new String[] {"Kohli", "Bumrah", "Kohli", "Rohit"});
        String b = findDuplicatePick(new String[] {"Kohli", "Bumrah", "Rohit"});
        System.out.println(a);
        System.out.println(b);
        if (!a.equals("Duplicate Found: Kohli") || !b.equals("No Duplicates Found")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
