package studentmanagementsystem;
import static org.junit.Assert.*;
import org.junit.Test;
public class StudentTest {

    @Test
    public void testStudentConstructorAndGetters() {
        Student student = new Student("S001", "John Doe", 20);
        
        assertEquals("S001", student.getStudentId());
        assertEquals("John Doe", student.getName());
        assertEquals(20, student.getAge());
    }
    
    @Test
    public void testSetters() {
        Student student = new Student("S001", "John Doe", 20);
        
        student.setName("Jane Smith");
        student.setAge(21);
        
        assertEquals("Jane Smith", student.getName());
        assertEquals(21, student.getAge());
    }
    
    @Test
    public void testToString() {
        Student student = new Student("S001", "John Doe", 20);
        String expected = "ID: S001, Name: John Doe, Age: 20";
        
        assertEquals(expected, student.toString());
    }
}
