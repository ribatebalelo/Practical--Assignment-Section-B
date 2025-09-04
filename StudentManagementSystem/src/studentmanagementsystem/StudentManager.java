package studentmanagementsystem;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentManager {
    private ArrayList<Student> students;
    private HashMap<String, ArrayList<Grade>> studentGrades;
    
    public StudentManager() {
        students = new ArrayList<>();
        studentGrades = new HashMap<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
        studentGrades.put(student.getStudentId(), new ArrayList<>());
    }
    
    public void addGrade(String studentId, Grade grade) {
        if (studentGrades.containsKey(studentId)) {
            studentGrades.get(studentId).add(grade);
        }
    }
    
    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
    
    public ArrayList<Grade> getStudentGrades(String studentId) {
        return studentGrades.getOrDefault(studentId, new ArrayList<>());
    }
    
    public double calculateGPA(String studentId) {
        ArrayList<Grade> grades = getStudentGrades(studentId);
        if (grades.isEmpty()) return 0.0;
        
        double totalPoints = 0;
        int totalCredits = 0;
        
        for (Grade grade : grades) {
            totalPoints += grade.getGradePoints() * grade.getCredits();
            totalCredits += grade.getCredits();
        }
        
        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }
    
    public void generateReport() {
        System.out.println("=== STUDENT MANAGEMENT SYSTEM REPORT ===");
        System.out.println("Total Students: " + students.size());
        System.out.println("========================================");
        
        for (Student student : students) {
            System.out.println("\nStudent: " + student);
            ArrayList<Grade> grades = getStudentGrades(student.getStudentId());
            
            if (grades.isEmpty()) {
                System.out.println("No grades recorded.");
            } else {
                System.out.println("Grades:");
                for (Grade grade : grades) {
                    System.out.println("  - " + grade);
                }
                System.out.printf("GPA: %.2f\n", calculateGPA(student.getStudentId()));
            }
            System.out.println("----------------------------------------");
        }
    }
    
    public void generateStudentReport(String studentId) {
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        
        System.out.println("=== INDIVIDUAL STUDENT REPORT ===");
        System.out.println("Student: " + student);
        
        ArrayList<Grade> grades = getStudentGrades(studentId);
        if (grades.isEmpty()) {
            System.out.println("No grades recorded.");
        } else {
            System.out.println("Grades:");
            for (Grade grade : grades) {
                System.out.println("  - " + grade);
            }
            System.out.printf("GPA: %.2f\n", calculateGPA(studentId));
        }
    }
}
