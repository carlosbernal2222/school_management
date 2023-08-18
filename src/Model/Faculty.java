package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Faculty extends Person{

    private String facultyId; // Unique Faculty ID
    private String department; // E.g., "Computer Science", "Mathematics"
    private String title; // E.g., "Professor", "Assistant Professor"
    private String highestDegree; // E.g., "Ph.D.", "M.Sc."
    private Date hireDate; // Date when the faculty member was hired
    private double salary;
    private List<Course> coursesTaught; // Courses currently being taught by the faculty member
    private List<String> researchInterests; // Areas of research interest
    private String officeLocation; // E.g., "Room 301, Science Building"
    private String officeHours; // E.g., "Mon-Wed 10:00 - 12:00"
    private boolean isTenured;

    public Faculty(String firstName, String lastName, String email, String facultyId,
                   String department, String title, String highestDegree, Date hireDate,
                   double salary, List<String> researchInterests, String officeLocation,
                   String officeHours, boolean isTenured) {
        super(firstName, lastName, email);
        this.facultyId = facultyId;
        this.department = department;
        this.title = title;
        this.highestDegree = highestDegree;
        this.hireDate = hireDate;
        this.salary = salary;
        this.researchInterests = researchInterests;
        this.officeLocation = officeLocation;
        this.officeHours = officeHours;
        this.isTenured = isTenured;
        this.coursesTaught = new ArrayList<>();
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public List<String> getResearchInterests() {
        return researchInterests;
    }

    public void setResearchInterests(List<String> researchInterests) {
        this.researchInterests = researchInterests;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public boolean isTenured() {
        return isTenured;
    }

    public void setTenured(boolean tenured) {
        isTenured = tenured;
    }
}
