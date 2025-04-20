package Yahia;

import java.util.Date;
import x3mara.*;

abstract public class User implements HasID {
    protected String email;
    protected String username;
    protected String contactNo;
    protected String password;
    protected Date dateOfBirth;
    protected String address;
    protected double balance;
    protected gender gen;
    protected String ID;

    protected User (){

    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getContactNo() {
        return contactNo;
    }
    public String getPassword() {
        return password;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public double getBalance() {
        return balance;
    }
    public String getAddress() {
        return address;
    }
    public gender getGen() {
        return gen;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setGen(gender gen) {
        this.gen = gen;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    abstract public String toString();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //    protected abstract void login();

}
