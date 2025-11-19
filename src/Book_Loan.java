
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MOMEN
 */
public class Book_Loan {

    private String borrower;
    private Copy copyOfBook;
    private Date dateFrom, dateReturned;
    private double fine;

    public Book_Loan(String borrower, Copy copyOfBook, Date dateFrom, Date dateReturned, double fine) {
        this.borrower = borrower;
        this.copyOfBook = copyOfBook;
        this.dateFrom = dateFrom;
        this.dateReturned = dateReturned;
        this.fine = fine;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public void setCopyOfBook(Copy copyOfBook) {
        this.copyOfBook = copyOfBook;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getBorrower() {
        return borrower;
    }

    public Copy getCopyOfBook() {
        return copyOfBook;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public double getFine() {
        return fine;
    }
}
