package Code;

public class Course {
    private String courseId;
    private String title;
    private int credits;
    private String instructorId;

    public Course(String courseId, String title, int credits) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.instructorId = null;
        
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }
    
}
