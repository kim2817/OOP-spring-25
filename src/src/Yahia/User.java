package Yahia;

import java.util.Date;
import x3mara.*;

abstract public class User implements HasID {
    private String email;
    private String username;
    private String contactNo;
    private String password;
    private Date dateOfBirth;
    private String address;
    private double balance;
    private gender gen;
    private String ID;

    abstract public String getEmail();
    abstract public String getUsername();
    abstract public String getContactNo();
    abstract public String getPassword();
    abstract public gender getGen();
    abstract public double getBalance();
    abstract public Date getDateOfBirth();
    abstract public String getAddress();

    @Override
    abstract public String toString();

    protected abstract void login();



}
