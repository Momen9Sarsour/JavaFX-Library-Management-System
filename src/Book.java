/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOMEN
 */
public class Book {
    private int id,year,numberOfCopyies;
    private double financialValue;
    private String titel,publisher,author,status;  // شوف قصة الStatus
    private Copy copiesOfBook;

    public Book(int id, int year, int numberOfCopyies, double financialValue, String titel, String publisher, String author, String status, Copy copiesOfBook) {
        this.id = id;
        this.year = year;
        this.numberOfCopyies = numberOfCopyies;
        this.financialValue = financialValue;
        this.titel = titel;
        this.publisher = publisher;
        this.author = author;
        this.status = status;
        this.copiesOfBook = copiesOfBook;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getNumberOfCopyies() {
        return numberOfCopyies;
    }

    public double getFinancialValue() {
        return financialValue;
    }

    public String getTitel() {
        return titel;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }

    public Copy getCopiesOfBook() {
        return copiesOfBook;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumberOfCopyies(int numberOfCopyies) {
        this.numberOfCopyies = numberOfCopyies;
    }

    public void setFinancialValue(double financialValue) {
        this.financialValue = financialValue;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCopiesOfBook(Copy copiesOfBook) {
        this.copiesOfBook = copiesOfBook;
    }
    
    
    
}
