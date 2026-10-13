/**
 * Week 5 · S5 practice · Problem 2 Duplicate Team Name Finder
 *
 * Nested loops, no Collections. Each name is compared only with names after it.
 * Comparison is case-sensitive.
 */
public class DuplicateTeamFinder {
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String a = findDuplicateTeam(new String[] {"ByteForce", "CodeCrafters", "ByteForce"});
        String b = findDuplicateTeam(new String[] {"ByteForce", "CodeCrafters", "NullPointers"});
        System.out.println(a);
        System.out.println(b);
        if (!a.equals("Duplicate Found: ByteForce") || !b.equals("No Duplicates Found")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
