package studentmanagementsystem;

import java.util.Scanner;

public class StudentManagementApp {
    private StudentManager manager;
    private Scanner scanner;
    
    public StudentManagementApp() {
        manager = new StudentManager();
        scanner = new Scanner(System.in);
    }
    
    public void run() {
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Generate Full Report");
            System.out.println("4. Generate Student Report");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    manager.generateReport();
                    break;
                case 4:
                    generateStudentReport();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = getIntInput();
        
        manager.addStudent(new Student(id, name, age));
        System.out.println("Student added successfully.");
    }
    
    private void addGrade() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        
        if (manager.findStudent(studentId) == null) {
            System.out.println("Student not found.");
            return;
        }
        
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter course credits: ");
        int credits = getIntInput();
        System.out.print("Enter score: ");
        double score = getDoubleInput();
        
        manager.addGrade(studentId, new Grade(courseId, courseName, credits, score));
        System.out.println("Grade added successfully.");
    }
    
    private void generateStudentReport() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        manager.generateStudentReport(studentId);
    }
    
    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
    
    private double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
    
    public static void main(String[] args) {
        StudentManagementApp app = new StudentManagementApp();
        app.run();
    }
}
