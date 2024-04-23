package Code;

import java.util.HashMap;

public class UniversityManagementSystem {
    public  static HashMap<String, Instructor> instructorMap = new HashMap<>();
    public static HashMap<String, Student> studentMap = new HashMap<>();
    public static HashMap<String, Course> courseMap = new HashMap<>();

    UniversityManagementSystem() {
        instructorMap = new HashMap<String, Instructor>();
        studentMap = new HashMap<String, Student>();
        courseMap = new HashMap<String, Course>();
    }

    public HashMap<String, Instructor> getInstructorMap() {
        return instructorMap;
    }

    public HashMap<String, Student> getStudentMap() {
        return studentMap;
    }

    public HashMap<String, Course> getCourseMap() {
        return courseMap;
    }

    public void assignInstructorToCourse(String insturctorId, String courseId) {
       instructorMap.get(insturctorId).addCoursesTaught(courseMap.get(courseId));
    }
    
    public void registerStudentForCourse(String studentId, String courseId) {
        studentMap.get(studentId).addEnrolledCourses(courseMap.get(courseId));
    }
    
    public void displayAllCoursesTaughtByInstructor(String instructorId) {
        System.out.print("Courses of " + instructorMap.get(instructorId).name + ": ");
        for (String courseId : instructorMap.get(instructorId).getCoursesTaught()) {
            System.out.print(courseMap.get(courseId).getTitle() + " ");
        }
        System.out.println();
    }

    public void listStudentsEnrolledInCourse(String courseId) {
        System.out.print("Students in " + courseMap.get(courseId).getTitle() + " course: ");
        for (Student student : studentMap.values()) {
            if (student.getEnrolledCourses().contains(courseId)) {
                System.out.print(student.getName() + " ");
            }
        }
    }
}
