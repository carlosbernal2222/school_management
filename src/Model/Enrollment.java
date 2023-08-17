package Model;

import java.util.Date;

public class Enrollment {

    private int enrollmentId;
    private Student student;
    private Course course;
    private Date enrollmentDate;
    private String status; // E.g., "Enrolled", "Completed", "Withdrawn"
    private String grade; // E.g., "A", "B-", "Incomplete"

    public Enrollment(int enrollmentId, Student student, Course course, Date enrollmentDate, String status) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
        this.grade = ""; // Initially, no grade assigned
    }

    // Methods to update enrollment status, assign grades, etc., can be added here


    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
