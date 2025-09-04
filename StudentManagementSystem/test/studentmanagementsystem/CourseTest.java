package studentmanagementsystem;

import static org.junit.Assert.*;
import org.junit.Test;

public class CourseTest {

    @Test
    public void testCourseConstructorAndGetters() {
        Course course = new Course("CS101", "Introduction to Programming", 3);
        
        assertEquals("CS101", course.getCourseId());
        assertEquals("Introduction to Programming", course.getCourseName());
        assertEquals(3, course.getCredits());
    }
    
    @Test
    public void testToString() {
        Course course = new Course("MATH201", "Calculus", 4);
        String expected = "ID: MATH201, Name: Calculus, Credits: 4";
        
        assertEquals(expected, course.toString());
    }
}
