package studentmanagementsystem;
import static org.junit.Assert.*;
import org.junit.Test;

public class GradeTest {

    @Test
    public void testGradeConstructorAndGetters() {
        Grade grade = new Grade("CS101", "Programming", 3, 85.5);
        
        assertEquals("CS101", grade.getCourseId());
        assertEquals("Programming", grade.getCourseName());
        assertEquals(3, grade.getCredits());
        assertEquals(85.5, grade.getScore(), 0.01);
    }
    
    @Test
    public void testSetScore() {
        Grade grade = new Grade("MATH101", "Mathematics", 4, 75.0);
        grade.setScore(88.0);
        
        assertEquals(88.0, grade.getScore(), 0.01);
    }
    
    @Test
    public void testGetGradeLetter() {
        Grade gradeA = new Grade("CS101", "Programming", 3, 95.0);
        Grade gradeB = new Grade("CS101", "Programming", 3, 85.0);
        Grade gradeC = new Grade("CS101", "Programming", 3, 75.0);
        Grade gradeD = new Grade("CS101", "Programming", 3, 65.0);
        Grade gradeF = new Grade("CS101", "Programming", 3, 55.0);
        
        assertEquals('A', gradeA.getGradeLetter());
        assertEquals('B', gradeB.getGradeLetter());
        assertEquals('C', gradeC.getGradeLetter());
        assertEquals('D', gradeD.getGradeLetter());
        assertEquals('F', gradeF.getGradeLetter());
    }
    
    @Test
    public void testGetGradePoints() {
        Grade gradeA = new Grade("CS101", "Programming", 3, 95.0);
        Grade gradeB = new Grade("CS101", "Programming", 3, 85.0);
        Grade gradeC = new Grade("CS101", "Programming", 3, 75.0);
        Grade gradeD = new Grade("CS101", "Programming", 3, 65.0);
        Grade gradeF = new Grade("CS101", "Programming", 3, 55.0);
        
        assertEquals(4.0, gradeA.getGradePoints(), 0.01);
        assertEquals(3.0, gradeB.getGradePoints(), 0.01);
        assertEquals(2.0, gradeC.getGradePoints(), 0.01);
        assertEquals(1.0, gradeD.getGradePoints(), 0.01);
        assertEquals(0.0, gradeF.getGradePoints(), 0.01);
    }
    
    @Test
    public void testToString() {
        Grade grade = new Grade("CS101", "Programming", 3, 85.5);
        String expected = "ID: CS101, Name: Programming, Credits: 3, Score: 85.5, Grade: B";
        
        assertEquals(expected, grade.toString());
    }
}
