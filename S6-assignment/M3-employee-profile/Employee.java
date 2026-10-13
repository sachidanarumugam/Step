/**
 * Week 6 · S6 assignment · M3 Employee Profile Creation
 *
 * The intern constructor chains to the permanent constructor with salary 0,
 * then marks the employee as an intern.
 */
public class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");
        permanent.printProfile();
        intern.printProfile();
        if (permanent.isIntern || !intern.isIntern || intern.salary != 0) {
            throw new AssertionError("Constructor chaining failed");
        }
        System.out.println("Sample checks passed.");
    }
}
