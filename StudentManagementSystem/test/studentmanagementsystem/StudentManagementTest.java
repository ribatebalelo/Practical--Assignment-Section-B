package studentmanagementsystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentManagementTest {
    
    @Test
    public void testStudentCreation() {
        Student student = new Student("S001", "John Doe", 20);
        assertEquals("S001", student.getStudentId());
        assertEquals("John Doe", student.getName());
        assertEquals(20, student.getAge());
    }
    
    @Test
    public void testGradeCalculation() {
        Grade grade = new Grade("C001", "Mathematics", 4, 85.5);
        assertEquals('B', grade.getGradeLetter());
        assertEquals(3.0, grade.getGradePoints(), 0.01);
    }
    
    @Test
    public void testGPACalculation() {
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student("S001", "John Doe", 20));
        
        manager.addGrade("S001", new Grade("C001", "Mathematics", 4, 85.5)); // B = 3.0
        manager.addGrade("S001", new Grade("C002", "Physics", 3, 92.0)); // A = 4.0
        assertEquals(3.43, manager.calculateGPA("S001"), 0.01);
    }
    
    @Test
    public void testStudentNotFound() {
        StudentManager manager = new StudentManager();
        assertNull(manager.findStudent("S999"));
    }
    
    @Test
    public void testNoGradesGPA() {
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student("S001", "John Doe", 20));
        assertEquals(0.0, manager.calculateGPA("S001"), 0.01);
    }
}