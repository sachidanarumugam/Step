/**
 * Week 2 · S2 · Problem 3 — File Extension Validator
 *
 * Uses lastIndexOf and substring. Accepted types: pdf, docx, zip (any case).
 */
public class FileExtensionValidator {
    static String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot < 0 || dot == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        String extension = filename.substring(dot + 1);
        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println("Assignment1.PDF -> " + validateFileExtension("Assignment1.PDF"));
        System.out.println("notes.txt -> " + validateFileExtension("notes.txt"));
        if (!validateFileExtension("Assignment1.PDF").equals("Accepted")
                || !validateFileExtension("notes.txt").equals("Rejected — invalid file type")) {
            throw new AssertionError("Sample mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
