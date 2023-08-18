import Database.DatabaseManager;
import Model.Student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {

        System.out.println("Welcome To my School Management System");

        // Initialize the database manager
        DatabaseManager dbManager = new DatabaseManager();

        try {
            // Establish a connection to the database
            Connection connection = dbManager.getConnection();
            if (connection != null && !connection.isClosed()) {

                // Connection successful message
                System.out.println("Connection to the database established successfully!");

                // Initialize scanner for user input
                Scanner scanner = new Scanner(System.in);

                System.out.println("Select an action:");
                System.out.println("1. Register Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. View Student");
                System.out.print("Your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (choice == 1) {
                    // Gather student information for registration
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();

                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Date of Birth (MM/dd/yyyy): ");
                    String dob = scanner.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    Date dateOfBirth = sdf.parse(dob);

                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();

                    System.out.print("Enter Nationality: ");
                    String nationality = scanner.nextLine();

                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();

                    Date enrollmentDate = new Date(); // Set to the current date

                    System.out.print("Enter Status (Full-time/Part-time): ");
                    scanner.nextLine(); // Consume newline character
                    String status = scanner.nextLine();

                    System.out.print("Is the student in good standing? (yes/no): ");
                    String goodStandingInput = scanner.nextLine();
                    boolean inGoodStanding = goodStandingInput.equalsIgnoreCase("yes");

                    // Create a Student instance with gathered information
                    Student student = new Student(studentId, firstName, lastName, email, dateOfBirth, gender,
                            nationality, address, phoneNumber, major, gpa, enrollmentDate, status, inGoodStanding);

                    // Registering the student in the database
                    if (student.registerStudent(connection)) {
                        System.out.println("Student registered successfully with ID: " + student.getId());
                    } else {
                        System.out.println("Student registration failed.");
                    }
                } else if (choice == 3) {
                    // Gather student ID for deletion
                    System.out.print("Enter Student ID to delete: ");
                    String studentIdToDelete = scanner.nextLine();

                    // Create a Student instance with the studentIdToDelete for deletion
                    Student studentToDelete = new Student(studentIdToDelete, null, null, null,
                            null, null, null, null, null, null,
                            0, null, null, false);

                    // Delete the student from the database
                    if (studentToDelete.deleteStudent(connection)) {
                        System.out.println("Student with ID " + studentIdToDelete + " deleted successfully.");
                    } else {
                        System.out.println("Failed to delete student with ID " + studentIdToDelete + ".");
                    }
                } else if(choice == 4){
                    System.out.print("Enter Student ID to view: ");
                    String studentIdToView = scanner.nextLine();

                    // Create a Student instance with the studentIdToView for viewing
                    Student studentToView = new Student(studentIdToView, null, null, null, null,
                            null,  null, null, null, null, 0, null,
                            null, false);

                    // Retrieve student information from the database
                    if (studentToView.retrieveStudent(connection)) {

                        //Print all the student information
                        studentToView.printStudentInformation();

                    } else {
                        System.out.println("Failed to retrieve student with ID " + studentIdToView + ".");
                    }
                }else {
                    System.out.println("This action is not implemented yet.");
                }

            } else {
                System.out.println("Failed to establish connection!");
            }
        } catch (Exception e) { // Catching both SQLException and ParseException
            e.printStackTrace();
        } finally {
            // Close the database connection
            dbManager.closeConnection();
        }
    }
}
