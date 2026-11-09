package pkgnew.java;

import java.util.ArrayList;
import java.util.Scanner;

public class NewJava {

    static class Person {
        String name;
        int age;
        String address;
        int phoneNumber;

        public void displayInfo() {
            System.out.println("Name        : " + name);
            System.out.println("Age         : " + age);
            System.out.println("Address     : " + address);
            System.out.println("Phone Number: " + phoneNumber);
        }

        public void introduce() {
            System.out.println("Hello, my name is " + name + ".");
        }
    }

    static class Student extends Person {
        String studentId;
        String major;
        double gpa;

        @Override
        public void displayInfo() {
            System.out.println("Student ID  : " + studentId);
            System.out.println("Name        : " + name);
            System.out.println("Age         : " + age);
            System.out.println("Address     : " + address);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Major       : " + major);
            System.out.println("GPA         : " + gpa);
            System.out.println("Academic Standing: " + getAcademicStanding());
        }

        @Override
        public void introduce() {
            System.out.println("Hi i'm  " + name
                    + " and I am doing  " + major + ".");
        }

        public String getAcademicStanding() {
            if (gpa >= 3.5) {
                return "Dean's List";
            } else if (gpa >= 3.0) {
                return "Honours";
            } else if (gpa >= 2.0) {
                return "Good Standing";
            } else if (gpa >= 1.0) {
                return "Academic Probation";
            } else {
                return "Academic Dismissal";
            }
        }
    }

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. View Student");
            System.out.println("4. Get All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    viewStudent();
                    break;

                case 4:
                    getAllStudents();
                    break;

                case 5:
                    System.out.println("Program exited successfully.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    // ADD STUDENT
    public static void addStudent() {

        Student student = new Student();

        System.out.println("\n===== ADD STUDENT =====");

        System.out.print("Enter Student ID: ");
        student.studentId = scanner.nextLine();

        System.out.print("Enter Name: ");
        student.name = scanner.nextLine();

        System.out.print("Enter Age: ");
        student.age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Address: ");
        student.address = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        student.phoneNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Major: ");
        student.major = scanner.nextLine();

        System.out.print("Enter GPA: ");
        student.gpa = scanner.nextDouble();
        scanner.nextLine();

        students.add(student);

        System.out.println("Student added successfully!");
    }

    
    
    
    // UPDATE STUDENT
    public static void updateStudent() {

        System.out.println("\n===== UPDATE STUDENT =====");

        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        student.name = scanner.nextLine();

        System.out.print("Enter New Age: ");
        student.age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Address: ");
        student.address = scanner.nextLine();

        System.out.print("Enter New Phone Number: ");
        student.phoneNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Major: ");
        student.major = scanner.nextLine();

        System.out.print("Enter New GPA: ");
        student.gpa = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Student updated successfully!");
    }

    // VIEW ONE STUDENT
    public static void viewStudent() {

        System.out.println("\n===== VIEW STUDENT =====");

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.displayInfo();

        System.out.println("\nIntroduction:");
        student.introduce();
    }

    // GET ALL STUDENTS
    public static void getAllStudents() {

        System.out.println("\n===== ALL STUDENTS =====");

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student student : students) {
            System.out.println("----------------------------");
            student.displayInfo();
        }

        System.out.println("----------------------------");
    }

    // FIND STUDENT BY ID
    public static Student findStudent(String id) {

        for (Student student : students) {
            if (student.studentId.equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }
}