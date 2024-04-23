package Code;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * CourseTest
 */

public class CourseTest {
    private Course course;
    
    @Before
    public void setUp() {
        course = new Course("CS101", "Introduction to Computer Science", 4);
    }

    @Test
    public void testConstructorAndSettersGetters() {
        assertEquals("CS101", course.getCourseId());
        assertEquals("Introduction to Computer Science", course.getTitle());
        assertEquals(4, course.getCredits());
        
        // Test setters
        course.setCourseId("CS102");
        course.setTitle("Data Structures");
        course.setCredits(3);
        
        // Test getters again after setting new values
        assertEquals("CS102", course.getCourseId());
        assertEquals("Data Structures", course.getTitle());
        assertEquals(3, course.getCredits());
    }
}