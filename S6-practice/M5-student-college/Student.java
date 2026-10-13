/**
 * Week 6 · S6 practice · M5 Student and College Information Management
 *
 * collegeName and studentCount belong to the class, not to each student.
 * printCollegeInfo uses only static fields and is called on the class name.
 */
public class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new Student("Ravi", 90);
        new Student("Anitha", 88);
        Student.printCollegeInfo();
        if (Student.studentCount != 2) {
            throw new AssertionError("Count mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
