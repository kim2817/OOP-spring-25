package Yahia;

import java.util.Date;

abstract public class User {
    private String email;
    private String username;
    private String contactNo;
    private String password;
    private Date dateOfBirth;
    private String address;
    private double balance;
    private gender gen;

    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getContactNo() {
        return contactNo;
    }
    public String getPassword() {
        return password;
    }
    public gender getGen() {
        return gen;
    }
    public double getBalance() {
        return balance;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public String getAddress() {
        return address;
    }

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", gen=" + gen +
                '}';
    }

    abstract void login();



}
