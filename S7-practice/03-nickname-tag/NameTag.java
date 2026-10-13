/**
 * Week 7 · S7 practice · Problem 3 The Nickname Tag
 *
 * The full name is split once in the constructor. Both parts are final.
 */
public class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        NameTag twin = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
        if (!tag.getNickname().equals("Maria G.") || tag == twin) {
            throw new AssertionError("Nickname mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
