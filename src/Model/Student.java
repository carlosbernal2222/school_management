package Model;

import java.math.BigDecimal;
import java.sql.*;
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

    public Student(String studentId, String firstName, String lastName, String email,
                   Date dateOfBirth, String gender, String nationality, String address,
                   String phoneNumber, String major, double gpa, Date enrollmentDate,
                   String status, boolean inGoodStanding) {
        super(firstName, lastName, email);
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

    //Register student into system
    public boolean registerStudent(Connection connection) throws SQLException {
        String sql = "INSERT INTO Students (studentId, firstName, lastName, email, dateOfBirth, gender, nationality, address, phoneNumber, major, gpa, enrollmentDate, status, inGoodStanding) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, getStudentId());
            pstmt.setString(2, getFirstName());
            pstmt.setString(3, getLastName());
            pstmt.setString(4, getEmail());
            pstmt.setDate(5, new java.sql.Date(getDateOfBirth().getTime()));
            pstmt.setString(6, getGender());
            pstmt.setString(7, getNationality());
            pstmt.setString(8, getAddress());
            pstmt.setString(9, getPhoneNumber());
            pstmt.setString(10, getMajor());
            pstmt.setDouble(11, getGpa());
            pstmt.setDate(12, new java.sql.Date(getEnrollmentDate().getTime()));
            pstmt.setString(13, getStatus());
            pstmt.setBoolean(14, isInGoodStanding());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                return false;
            }

            // Get the generated ID and set it
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating student failed, no ID obtained.");
                }
            }

            return true;
        }
    }

    // Delete student from system
    public boolean deleteStudent(Connection connection) throws SQLException {
        String sql = "DELETE FROM Students WHERE studentId = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, getStudentId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    //Retrieve Student Information by Id
    // Retrieve Student Information by Id
    // Retrieve Student Information by Id
    public boolean retrieveStudent(Connection connection) throws SQLException {
        String sql = "SELECT * FROM Students WHERE studentId = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, getStudentId());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Retrieve student information from the result set and set the corresponding fields
                    this.setFirstName(rs.getString("firstName"));
                    this.setLastName(rs.getString("lastName"));
                    this.setEmail(rs.getString("email"));
                    this.setDateOfBirth(rs.getDate("dateOfBirth"));
                    this.setGender(rs.getString("gender"));
                    this.setNationality(rs.getString("nationality"));
                    this.setAddress(rs.getString("address"));
                    this.setPhoneNumber(rs.getString("phoneNumber"));
                    this.setMajor(rs.getString("major"));
                    this.setGpa(rs.getDouble("gpa"));
                    this.setEnrollmentDate(rs.getDate("enrollmentDate"));
                    this.setStatus(rs.getString("status"));
                    this.setInGoodStanding(rs.getBoolean("inGoodStanding"));

                    // You can similarly set other fields based on the retrieved data

                    return true;
                }
            }
        }
        return false;
    }

    public void printStudentInformation() {

        System.out.println("***********************************************");
        System.out.println("Student Information:");
        System.out.println("+---------------------------------------------+");
        String[] labels = {
                "ID:", "First Name:", "Last Name:", "Email:", "Date of Birth:",
                "Gender:", "Nationality:", "Address:", "Phone Number:",
                "Major:", "GPA:", "Enrollment Date:", "Status:", "In Good Standing:"
        };

        String[] values = {
                getStudentId(), getFirstName(), getLastName(), getEmail(), getDateOfBirth().toString(),
                getGender(), getNationality(), getAddress(), getPhoneNumber(),
                getMajor(), String.format("%.2f", getGpa()), getEnrollmentDate().toString(), getStatus(),
                isInGoodStanding() ? "Yes" : "No"
        };

        for (int i = 0; i < labels.length; i++) {
            System.out.printf("| %-16s %-31s |\n", labels[i], values[i]);
        }
        System.out.println("+---------------------------------------------+");
    }

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


