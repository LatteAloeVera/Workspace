package Code;

import java.util.ArrayList;

public class Student extends Entity {
    private int creditsEarned;
    private ArrayList<String> enrolledCourses;

    public Student(String id, String name) {
        super(id, name);
        this.creditsEarned = 0;
        this.enrolledCourses = new ArrayList<String>();
    }

    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void addEnrolledCourses(Course course) {
        if (!enrolledCourses.contains(course.getCourseId())) {
            enrolledCourses.add(course.getCourseId());
            this.creditsEarned += course.getCredits();
            System.out.println("Added new course for " + this.name + "!");
        } else {
            System.out.println("This student already has this lesson!");
        }
    }

    public void removeEnrolledCourses(Course course) {
        if (enrolledCourses.contains(course.getCourseId())) {
            enrolledCourses.remove(course.getCourseId());
            this.creditsEarned -= course.getCredits();
            System.out.println("Successfully removed course from " + this.name + "!");
        } else {
            System.out.println("This student doesn't attends to this course!");
        }
    }

    public double calculateAcademicProgress() {
        double progress = 0;
        double totalCredits = 0;

        // Getting total credits
        for (Course course : UniversityManagementSystem.courseMap.values()) {
            totalCredits = +course.getCredits();
        }
        progress = this.creditsEarned / totalCredits;

        return progress;
    }

    public void displayDetails() {
        System.out.printf("ID:-%8s, Name:-%15s, Earned Credits:-%5\n",
                this.id, this.name, this.creditsEarned);
        System.out.print("Enrolled course ID's: ");
        for (String enrolledCourseID : enrolledCourses) {
            System.out.print(enrolledCourseID + " ");
        }
        System.out.println();
    }

}
