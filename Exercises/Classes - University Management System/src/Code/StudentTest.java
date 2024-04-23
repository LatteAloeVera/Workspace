package Code;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    private Student student;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static final HashMap<String, Course> mockCourseMap = new HashMap<>();

    @Before
    public void setUp() {
        student = new Student("S100", "Alice Smith");
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture System.out

        // Mock data for courses
        mockCourseMap.put("CS101", new Course("CS101", "Introduction to Computer Science", 4));
        mockCourseMap.put("CS102", new Course("CS102", "Data Structures", 3));
        mockCourseMap.put("CS103", new Course("CS103", "Algorithms", 3));

        // Assume that UniversityManagementSystem.courseMap is a public static field for the purpose of this test.
        // Ideally, you should have proper getters/setters or use dependency injection for better testability.
        UniversityManagementSystem.courseMap = mockCourseMap;
    }
    
    // Reset the System.out to its original stream after tests
    @After
    public void tearDown() {
        System.setOut(System.out);
        // Clear the mockCourseMap for consistent test results
        mockCourseMap.clear();
    }

    @Test
    public void testStudentCreation() {
        assertEquals("S100", student.getId());
        assertEquals("Alice Smith", student.getName());
        assertEquals(0, student.getCreditsEarned());
    }

    @Test
    public void testAddEnrolledCourse() {
        Course course = mockCourseMap.get("CS101");
        student.addEnrolledCourses(course);
        assertTrue(student.getEnrolledCourses().contains("CS101"));
        assertEquals(4, student.getCreditsEarned());
    }

    @Test
    public void testRemoveEnrolledCourse() {
        Course course = mockCourseMap.get("CS101");
        student.addEnrolledCourses(course);
        student.removeEnrolledCourses(course);
        assertFalse(student.getEnrolledCourses().contains("CS101"));
        assertEquals(0, student.getCreditsEarned());
    }

    @Test
    public void testCalculateAcademicProgress() {
        // Add a few courses to simulate the student's academic progress
        student.addEnrolledCourses(mockCourseMap.get("CS101"));
        student.addEnrolledCourses(mockCourseMap.get("CS102"));

        // Assuming the total credits for a degree is a static number (for example, 120 credits)
        final double totalCreditsForDegree = 10.0;
        double expectedProgress = (4.0 + 3.0) / totalCreditsForDegree;

        assertEquals(expectedProgress, student.calculateAcademicProgress(), 0.1);
    }

    @Test
    public void testDisplayDetails() {
        student.addEnrolledCourses(mockCourseMap.get("CS101"));
        student.displayDetails();
        
        String expectedOutput = "Added new course for Alice Smith!\nStudent ID: S100\nStudent Name: Alice Smith\nCredits Earned: 4\nEnrolled course ID's: [CS101]";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
    
    
}
