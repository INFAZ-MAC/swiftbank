public class Student{
private String studentName;
        }
import java.util.*;

public class StudentManagement {

    Integer[] arr = new Integer[100];
    int index = 0;

    public static void main(String[] args) {

        StudentManagement sm = new StudentManagement();

        sm.addStudentMarks();
        sm.viewStudentMarks();
        sm.updateStudentNic();
    }

    public void addStudentMarks() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Marks");

        int M = input.nextInt();

        System.out.println("Enter Marks = " + M);
    }

    public void viewStudentMarks() {

        Scanner input = new Scanner(System.in);

        System.out.println("View Marks");

        int VM = input.nextInt();

        System.out.println("View Marks = " + VM);
    }

    public void updateStudentNic() {

        Scanner input = new Scanner(System.in);

        System.out.println("Update NIC");

        int update = input.nextInt();

        System.out.println("Update NIC = " + update);
    }
}

