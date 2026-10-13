/**
 * Week 6 · S6 assignment · M5 Employee and Company Information Management
 *
 * companyName is static, so every employee shares one company name.
 * employeeCount increases in the constructor. printCompanyInfo is static.
 */
public class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new Employee("Divya", 65000);
        new Employee("Arjun", 0);
        new Employee("Meera", 42000);
        Employee.printCompanyInfo();
        if (Employee.employeeCount != 3) {
            throw new AssertionError("Count mismatch");
        }
        System.out.println("Sample checks passed.");
    }
}
