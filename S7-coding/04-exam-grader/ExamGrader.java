/**
 * Week 7 · S7 coding · Problem 4 Examination Question Grader
 *
 * MCQ and true/false award full points only on an exact answer match.
 * Essays award 75% for two or more keywords, 50% for one, otherwise 0.
 * The grader loop calls score() on every question the same way.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExamGrader {
    interface Question {
        String type();
        double score();
    }

    static final class Mcq implements Question {
        private final String correct;
        private final String student;
        private final int points;

        Mcq(String correct, String student, int points) {
            this.correct = correct;
            this.student = student;
            this.points = points;
        }

        public String type() {
            return "MCQ";
        }

        public double score() {
            return correct.equals(student) ? points : 0;
        }
    }

    static final class TrueFalse implements Question {
        private final String correct;
        private final String student;
        private final int points;

        TrueFalse(String correct, String student, int points) {
            this.correct = correct;
            this.student = student;
            this.points = points;
        }

        public String type() {
            return "TF";
        }

        public double score() {
            return correct.equals(student) ? points : 0;
        }
    }

    static final class Essay implements Question {
        private final String keywords;
        private final String student;
        private final int points;

        Essay(String keywords, String student, int points) {
            this.keywords = keywords;
            this.student = student;
            this.points = points;
        }

        public String type() {
            return "ESSAY";
        }

        public double score() {
            String answer = student.toLowerCase();
            int hits = 0;
            for (String keyword : keywords.split(",")) {
                String word = keyword.trim().toLowerCase();
                if (!word.isEmpty() && answer.contains(word)) {
                    hits++;
                }
            }
            if (hits >= 2) {
                return points * 0.75;
            }
            if (hits == 1) {
                return points * 0.50;
            }
            return 0;
        }
    }

    static List<String> quoted(String line) {
        List<String> parts = new ArrayList<>();
        int i = 0;
        while (i < line.length()) {
            if (line.charAt(i) == '"') {
                int end = line.indexOf('"', i + 1);
                parts.add(line.substring(i + 1, end));
                i = end + 1;
            } else {
                i++;
            }
        }
        return parts;
    }

    static String process(String input) {
        String[] lines = input.strip().split("\\R");
        int n = Integer.parseInt(lines[0].trim());
        List<Question> questions = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String line = lines[i].trim();
            String type = line.substring(0, line.indexOf(' '));
            List<String> fields = quoted(line);
            int points = Integer.parseInt(line.substring(line.lastIndexOf(' ') + 1).trim());
            questions.add(switch (type) {
                case "MCQ" -> new Mcq(fields.get(1), fields.get(2), points);
                case "TF" -> new TrueFalse(fields.get(1), fields.get(2), points);
                case "ESSAY" -> new Essay(fields.get(1), fields.get(2), points);
                default -> throw new IllegalArgumentException(type);
            });
        }
        StringBuilder out = new StringBuilder();
        double total = 0;
        for (Question question : questions) {
            double score = question.score();
            total += score;
            out.append(String.format(Locale.US, "%s: %.2f%n", question.type(), score));
        }
        out.append(String.format(Locale.US, "Total Score: %.2f%n", total));
        return out.toString();
    }

    public static void main(String[] args) {
        String sample = """
                4
                MCQ "What is the capital of France?" "Paris" "Paris" 10
                TF "The Earth is flat?" "False" "True" 5
                ESSAY "Name two primary OOP principles." "Inheritance, Polymorphism, Encapsulation" "Polymorphism is one." 20
                ESSAY "Describe abstraction and composition." "Abstraction, Composition" "I talked about abstraction." 15
                """;
        String output = process(sample);
        System.out.print(output);
        String expected = """
                MCQ: 10.00
                TF: 0.00
                ESSAY: 10.00
                ESSAY: 7.50
                Total Score: 27.50
                """;
        if (!output.equals(expected)) {
            throw new AssertionError("Sample mismatch:\n" + output);
        }
        System.out.println("Sample checks passed.");
    }
}
