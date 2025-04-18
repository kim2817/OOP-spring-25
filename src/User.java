import java.util.*;
public class User {
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

    User(){

    }

    User(String email, String username, String contactNo, String password, Date dateOfBirth, String address, double balance, gender gen) {
        this.email = email;
        this.username = username;
        this.contactNo = contactNo;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.balance = balance;
        this.gen = gen;
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

    void login(){
    Scanner cin = new Scanner(System.in);






    cin.close();
    }



}
