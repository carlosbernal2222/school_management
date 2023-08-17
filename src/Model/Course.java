package Model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private int courseId;
    private String courseName;
    private String description;
    private int creditHours;
    private Faculty instructor;
    private List<Course> prerequisites;
    private List<Student> enrolledStudents;
    private String schedule; // E.g., "Mon-Wed-Fri 10:00 - 11:00"
    private String location; // E.g., "Room 101, Science Building"
    private int maxEnrollment;

    public Course(int courseId, String courseName, String description, int creditHours,
                  Faculty instructor, List<Course> prerequisites, String schedule, String location,
                  int maxEnrollment) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.creditHours = creditHours;
        this.instructor = instructor;
        this.prerequisites = prerequisites;
        this.schedule = schedule;
        this.location = location;
        this.maxEnrollment = maxEnrollment;
        this.enrolledStudents = new ArrayList<>();
    }


    // Methods to manage enrollment, such as adding or removing students, can be added here

    // You can further add methods to manage grades, assessments, attendance, etc.

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public Faculty getInstructor() {
        return instructor;
    }

    public void setInstructor(Faculty instructor) {
        this.instructor = instructor;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }
}
