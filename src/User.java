
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
public class User {
    private int id;
    private double totalFine;
    private String firstName,lastName,password;
    private Date date;

    public User(int id, double totalFine, String firstName, String lastName, String password, Date date) {
        this.id = id;
        this.totalFine = totalFine;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public double getTotalFine() {
        return totalFine;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalFine(double totalFine) {
        this.totalFine = totalFine;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
