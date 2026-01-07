import java.util.ArrayList;
import java.util.Scanner;

class Stdnt {
    int rollNo;
    String name;
    boolean present;

    Stdnt(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.present = false;
    }

    @Override
    public String toString() {
        return rollNo + " | " + name + " | " + (present ? "Present" : "Absent");
    }
}

public class day4 {

    static ArrayList<Stdnt> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n===== Student Attendance System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Attendance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> markAttendance();
                case 3 -> viewAttendance();
                case 4 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    static void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        students.add(new Stdnt(roll, name));
        System.out.println("Student added successfully!");
    }

    static void markAttendance() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        for (Stdnt s : students) {
            if (s.rollNo == roll) {
                s.present = true;
                System.out.println("Attendance marked PRESENT.");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void viewAttendance() {
        System.out.println("\nRoll | Name | Status");
        System.out.println("----------------------");
        for (Stdnt s : students) {
            System.out.println(s);
        }
    }
}
