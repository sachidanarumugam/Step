/**
 * Week 6 · S6 practice · M1 Student Placement Record Management
 *
 * One object holds name, company, and package together, replacing parallel arrays.
 */
public class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        PlacementRecord[] records = {
                new PlacementRecord("Ravi", "TCS", 4.5),
                new PlacementRecord("Anitha", "Zoho", 6.2),
                new PlacementRecord("Karthik", "Infosys", 4.0)
        };
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
