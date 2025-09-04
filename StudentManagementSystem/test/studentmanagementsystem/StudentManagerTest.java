package studentmanagementsystem;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class StudentManagerTest {

    private StudentManager manager;
    private Student student1;
    private Student student2;
    
    @Before
    public void setUp() {
        manager = new StudentManager();
        student1 = new Student("S001", "John Doe", 20);
        student2 = new Student("S002", "Jane Smith", 21);
    }
    
    @Test
    public void testAddStudent() {
        manager.addStudent(student1);
        manager.addStudent(student2);
       
        assertNotNull(manager.findStudent("S001"));
        assertNotNull(manager.findStudent("S002"));
        assertNotNull(manager.getStudentGrades("S001"));
        assertNotNull(manager.getStudentGrades("S002"));
    }
    
    @Test
    public void testFindStudent() {
        manager.addStudent(student1);
        
        Student found = manager.findStudent("S001");
        assertNotNull(found);
        assertEquals("John Doe", found.getName());
        
        Student notFound = manager.findStudent("S999");
        assertNull(notFound);
    }
    
    @Test
    public void testAddGrade() {
        manager.addStudent(student1);
        
        Grade grade = new Grade("CS101", "Programming", 3, 85.0);
        manager.addGrade("S001", grade);
        
        ArrayList<Grade> grades = manager.getStudentGrades("S001");
        assertEquals(1, grades.size());
        assertEquals("CS101", grades.get(0).getCourseId());
    }
    
    @Test
    public void testGetStudentGrades() {
        manager.addStudent(student1);
  
        ArrayList<Grade> emptyGrades = manager.getStudentGrades("S001");
        assertTrue(emptyGrades.isEmpty());
     
        ArrayList<Grade> nonExistentGrades = manager.getStudentGrades("S999");
        assertTrue(nonExistentGrades.isEmpty());
    }
    
    @Test
    public void testCalculateGPA() {
        manager.addStudent(student1);
       
        assertEquals(0.0, manager.calculateGPA("S001"), 0.01);
        
        // Test with grades
        manager.addGrade("S001", new Grade("CS101", "Programming", 3, 95.0)); // A = 4.0
        manager.addGrade("S001", new Grade("MATH101", "Mathematics", 4, 85.0)); // B = 3.0
        
        assertEquals(3.4286, manager.calculateGPA("S001"), 0.0001);
    }
    
    @Test
    public void testCalculateGPAWithFailingGrade() {
        manager.addStudent(student1);
        
        manager.addGrade("S001", new Grade("CS101", "Programming", 3, 55.0)); // F = 0.0
        manager.addGrade("S001", new Grade("MATH101", "Mathematics", 4, 85.0)); // B = 3.0
     
        assertEquals(1.7143, manager.calculateGPA("S001"), 0.0001);
    }
}