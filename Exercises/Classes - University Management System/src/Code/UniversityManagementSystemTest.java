package Code;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UniversityManagementSystemTest {
    private UniversityManagementSystem ums;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        ums = new UniversityManagementSystem();
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture System.out

        // Set up some initial data
        Instructor instructor = new Instructor("I123", "Dr. Jane", 70000);
        Student student = new Student("S456", "Bob Smith");
        Course course = new Course("C789", "Data Science 101", 3);

        ums.getInstructorMap().put(instructor.getId(), instructor);
        ums.getStudentMap().put(student.getId(), student);
        ums.getCourseMap().put(course.getCourseId(), course);
    }

    // Reset the System.out to its original stream after tests
    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void testAssignInstructorToCourse() {
        ums.assignInstructorToCourse("I123", "C789");
        
        // Verify that the instructor has the course assigned
        assertTrue(ums.getInstructorMap().get("I123").getCoursesTaught().contains("C789"));
        
        // Verify that the course now has an instructor ID set
        assertEquals("I123", ums.getCourseMap().get("C789").getInstructorId());
    }

    @Test
    public void testRegisterStudentForCourse() {
        ums.registerStudentForCourse("S456", "C789");

        // Verify the student is now enrolled in the course
        assertTrue(ums.getStudentMap().get("S456").getEnrolledCourses().contains("C789"));
    }

    @Test
    public void testDisplayAllCoursesTaughtByInstructor() {
        ums.assignInstructorToCourse("I123", "C789");
        ums.displayAllCoursesTaughtByInstructor("I123");
        
        // The output should contain the course title
        assertTrue(outputStreamCaptor.toString().contains("Data Science 101"));
    }

    @Test
    public void testListStudentsEnrolledInCourse() {
        ums.registerStudentForCourse("S456", "C789");
        ums.listStudentsEnrolledInCourse("C789");

        // The output should contain the student's name
        assertTrue(outputStreamCaptor.toString().contains("Bob Smith"));
    }
    
    
}
