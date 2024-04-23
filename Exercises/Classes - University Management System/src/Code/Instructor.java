package Code;

import java.util.HashSet;
import java.util.Set;

public class Instructor extends Entity {
    private double salary;
    private Set<String> coursesTaught;

    public Instructor(String id, String name, double salary) {
        super(id, name);
        this.salary = salary;
        this.coursesTaught = new HashSet<String>();
    }

    public Set<String> getCoursesTaught() {
        return coursesTaught;
    }

    public void addCoursesTaught(Course course) {
        if (!coursesTaught.contains(course.getCourseId()) && course.getInstructorId().equals(null)) {
            coursesTaught.add(course.getCourseId());
            course.setInstructorId(this.id);
            System.out.println("Course added to instructor " + this.name);
        } else {
            System.out.println("This course has already been added!");
        }
    }
    
    public void removeCoursesTaught(Course course) {
        if (coursesTaught.contains(course.getCourseId())) {
            coursesTaught.remove(course.getCourseId());
            course.setCourseId(null);
            System.out.println("This course is removed from instructor " + this.name);
        } else {
            System.out.println("This instructor doesn't teach this course!");
        }
    }
    
    public int calculateWorkload() {
        int workLoad = 0;

        for (String courseId : coursesTaught) {
            Course course = UniversityManagementSystem.courseMap.get(courseId);
            
            if (course != null) {
                workLoad += course.getCredits();
            }
        }
        
        return workLoad;
    }

    
    //override method
    public void displayDetails() {
        System.out.printf("ID:-%8s, Name:-%20s, Salary:-%10s", id, name, salary);
        System.out.print("Courses: ");
        for (String courseId : coursesTaught) {
            System.out.print(courseId + " ");
        }
        System.out.println();
    }
}
