/**
 * Week 7 · S7 practice · Problem 4 The Locker Code
 *
 * combination is private and has no getter. A change is applied only after the
 * current code matches. lockerNumber is final.
 */
public class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!combination.equals(currentCode)) {
            System.out.println("changeCode rejected, code is still \"" + combination + "\"");
            return false;
        }
        combination = newCode;
        System.out.println("changeCode success");
        return true;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        if (!locker.changeCode("1234", "5678")) {
            throw new AssertionError("Valid change rejected");
        }
        if (locker.changeCode("0000", "9999")) {
            throw new AssertionError("Invalid change accepted");
        }
        System.out.println("Sample checks passed.");
    }
}
