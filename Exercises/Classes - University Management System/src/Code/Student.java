package Code;

import java.util.ArrayList;

public class Student extends Entity {
    private int creditsEarned;
    private ArrayList<String> enrolledCourses;

    public Student(String id, String name) {
        super(id, name);
        this.creditsEarned = 0;
        this.enrolledCourses = new ArrayList<String>();

        UniversityManagementSystem.studentMap.put(this.id, this);
    }

    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void addEnrolledCourses(Course course) {
        if (!enrolledCourses.contains(course.getCourseId())) {
            enrolledCourses.add(course.getCourseId());
            this.creditsEarned += course.getCredits();
            System.out.print("Added new course for " + this.name + "!" + "\n");
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
            totalCredits += course.getCredits();
        }
        progress = this.creditsEarned / totalCredits;

        return progress;
    }

    public void displayDetails() {
        System.out.print("Student ID: " + this.id + "\n");
        System.out.print("Student Name: " + this.name + "\n");
        System.out.print("Credits Earned: " + this.creditsEarned + "\n");
        System.out.print("Enrolled course ID's: " + this.enrolledCourses);
    }

    public int getCreditsEarned() {
        return creditsEarned;
    }

}
