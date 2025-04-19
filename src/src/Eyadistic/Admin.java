package Eyadistic;
import Yahia.User;
import Yahia.gender;
import x3mara.*;

import java.util.Date;


public class Admin extends User{


    //Attributes
    private String role;
    private String workingHours;
    private String ID = "a" + System.nanoTime();


    //Constructors//
    Admin(){}

    @Override
    protected void login() {

    }

    Admin(String role, String workingHours){
        this.role = role;
        this.workingHours = workingHours;
    }


    //Methods
    public String getRole() {
        return role;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public void addRooms(String roomName, String roomCapacity, int rentPrice, double bookedSlots, Schedule[] bookedList){
    }

    @Override
    public String getEmail() {
        return "";
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public String getContactNo() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public gender getGen() {
        return null;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public Date getDateOfBirth() {
        return null;
    }

    @Override
    public String getAddress() {
        return "";
    }
    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String toString(){
       return "User{" +
                "email='" + getEmail() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", contactNo='" + getContactNo() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", address='" + getAddress() + '\'' +
                ", balance=" + getBalance() +
                ", gen=" + getGen() +
                ", ID='" + getID() + '\'' +
                '}';
    }

    //till User class is made
    //Methods to be added:
    //addRooms, viewEvents, viewAttendees, viewOrganizers, login, register, toString, equals//
}
