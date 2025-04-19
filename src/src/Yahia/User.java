package Yahia;

import java.util.Date;
import x3mara.*;

abstract public class User implements HasID {
    String email;
    String username;
    String contactNo;
    String password;
    Date dateOfBirth;
    String address;
    double balance;
    gender gen;
    String ID;

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
