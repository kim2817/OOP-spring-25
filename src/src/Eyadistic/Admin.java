package Eyadistic;
import Yahia.Organizer;
import Yahia.User;
import Omar.Attendee;
import Yahia.gender;
import x3mara.*;
import Jasmin.Event;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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

    public void addRooms(Room o, String roomName, int roomCapacity, double rentPrice){
    Database.create(o);
    o.setRoomName(roomName);
    o.setRoomCapacity(roomCapacity);
    o.setRentPrice(rentPrice);
    }

    public void viewEvents(){
        Database.readAll(new Event());
    }

    public void viewOrganizers(){
        Database.readAll(new Organizer());
    }

    public void viewAttendee(){
        Database.readAll(new Attendee());
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String toString(){
       return "Admin{" +
                "email='" + this.email + '\'' +
                ", username='" + this.username + '\'' +
                ", role='" + getRole() + '\'' +
                ", workingHours='" + getWorkingHours() + '\'' +
                ", contactNo='" + this.contactNo + '\'' +
                ", password='" +  this.password + '\'' +
                ", dateOfBirth=" + this.dateOfBirth +
                ", address='" + this.address + '\'' +
                ", balance=" + this.balance +
                ", gen=" + this.gen +
                ", ID='" + getID() + '\'' +
                '}';
    }

    //Methods to be added:
    //login, register, equals//
}
