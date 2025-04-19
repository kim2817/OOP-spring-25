package Eyadistic;
import Yahia.User;
import x3mara.Schedule;
import x3mara.Database;


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
    public String toString(){
        return "Wok";
    }
    @Override
    public String getID() {
        return ID;
    }
    //till User class is made
    //Methods to be added:
    //addRooms, viewEvents, viewAttendees, viewOrganizers, login, register, toString, equals//
}
