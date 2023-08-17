package Model;

public class Grade {

    private int gradeId;
    private Enrollment enrollment;
    private String assessmentName; // E.g., "Midterm Exam", "Project 1"
    private String grade; // E.g., "A", "B-"
    private double weight; // Weight of this assessment in the final grade, e.g., 0.2 for 20%

    public Grade(int gradeId, Enrollment enrollment, String assessmentName, String grade, double weight) {
        this.gradeId = gradeId;
        this.enrollment = enrollment;
        this.assessmentName = assessmentName;
        this.grade = grade;
        this.weight = weight;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
