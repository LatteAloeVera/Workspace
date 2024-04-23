package Code;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;
import static org.junit.Assert.*;

public class InstructorTest {
    private Instructor instructor;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        instructor = new Instructor("I100", "John Doe", 50000.0);
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture System.out
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void testInstructorCreation() {
        assertEquals("I100", instructor.getId());
        assertEquals("John Doe", instructor.getName());
        assertEquals(50000.0, instructor.getSalary(), 0.1);
    }

    @Test
    public void testAddCourse() {
        Course course = new Course("CS101", "Introduction to Computer Science", 4);
        instructor.addCoursesTaught(course);
        assertTrue(instructor.getCoursesTaught().contains("CS101"));
        assertEquals("I100", course.getInstructorId());
    }

    @Test
    public void testRemoveCourse() {
        Course course = new Course("CS101", "Introduction to Computer Science", 4);
        instructor.addCoursesTaught(course);
        instructor.removeCoursesTaught(course);
        assertFalse(instructor.getCoursesTaught().contains("CS101"));
        assertNull(course.getInstructorId());
    }

    @Test
    public void testCalculateWorkload() {
        Course course1 = new Course("CS101", "Introduction to Computer Science", 4);
        Course course2 = new Course("CS102", "Data Structures", 3);
        instructor.addCoursesTaught(course1);
        instructor.addCoursesTaught(course2);
        assertEquals(7, instructor.calculateWorkload());
    }

    @Test
    public void testDisplayDetails() {
        instructor.displayDetails();
        String expectedOutput = "ID: I100\nName: John Doe\nSalary: 50000.0\nCourses: []";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
