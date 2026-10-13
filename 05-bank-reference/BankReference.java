/**
 * Week 2 · S2 · Problem 5 — Bank Transaction Reference Generator & Validator
 *
 * A valid code is 3 letters + 6 date digits (ddMMyy) + 5 sequence digits.
 * No regular expressions: Character.isLetter / isDigit only.
 */
public class BankReference {
    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        String bank = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String seq = reference.substring(9);
        StringBuilder line = new StringBuilder();
        line.append("[").append(bank).append("] DATE: ");
        line.append(date, 0, 2).append("/")
                .append(date, 2, 4).append("/")
                .append(date, 4, 6);
        line.append(" | SEQ: ").append(seq);
        return line.toString();
    }

    public static void main(String[] args) {
        String first = validateAndFormat(normalizeReference("  hdf03022600042  "));
        String second = validateAndFormat(normalizeReference("12F03022600042"));
        System.out.println(first);
        System.out.println(second);
        if (!first.equals("[HDF] DATE: 03/02/26 | SEQ: 00042")
                || !second.equals("Invalid: bank code must be 3 letters")) {
            throw new AssertionError("Sample mismatch: " + first + " | " + second);
        }
        System.out.println("Sample checks passed.");
    }
}
