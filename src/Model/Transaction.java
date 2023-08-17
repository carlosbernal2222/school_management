package Model;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private Student student;
    private String type; // E.g., "Tuition Payment", "Lab Fee", "Refund"
    private double amount;
    private Date transactionDate;
    private String status; // E.g., "Completed", "Pending", "Failed"

    public Transaction(int transactionId, Student student, String type, double amount, Date transactionDate, String status) {
        this.transactionId = transactionId;
        this.student = student;
        this.type = type;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.status = status;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
