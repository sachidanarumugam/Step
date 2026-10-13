/**
 * Week 6 · S6 assignment · M4 Exam Hall Ticket Reference Management
 *
 * copy and priya name the same object. separate is a different object
 * even when the field values match.
 */
public class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;
        copy.seatNumber = 45;
        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
        if (priya.seatNumber != 45 || copy != priya || separate == priya) {
            throw new AssertionError("Reference demo failed");
        }
        System.out.println("Sample checks passed.");
    }
}
