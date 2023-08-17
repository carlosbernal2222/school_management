package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person{
    private String studentId; //Unique student Id
    private Date dateOfBirth;
    private String gender;
    private String nationality;
    private String address;
    private String phoneNumber;
    private String major;
    private double gpa;
    private Date enrollmentDate;
    private String status; //Full-time, Part-time, Alumni
    private List<Enrollment> enrollments; // Courses that the student is currently taking
    private List<Transaction> transactions; //Financial transactions related to the student
    private boolean inGoodStanding; //Flag indicating if the student is passing his classes

    public Student(int id, String firstName, String lastName, String email, String studentId,
                   Date dateOfBirth, String gender, String nationality, String address,
                   String phoneNumber, String major, double gpa, Date enrollmentDate,
                   String status, boolean inGoodStanding) {
        super(id, firstName, lastName, email);
        this.studentId = studentId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.gpa = gpa;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
        this.inGoodStanding = inGoodStanding;
        this.enrollments = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    //Additional helper methods


    //Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
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

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean isInGoodStanding() {
        return inGoodStanding;
    }

    public void setInGoodStanding(boolean inGoodStanding) {
        this.inGoodStanding = inGoodStanding;
    }
}


