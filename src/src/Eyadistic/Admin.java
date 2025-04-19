package Eyadistic;


public class Admin extends User{


    //Attributes
    private String role;
    private String workingHours;


    //Constructors//
    Admin(){}

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

    public void addRooms(String roomName, String roomCapacity, int rentPrice, double bookedSlots){}

    //till User class is made
    //Methods to be added:
    //addRooms, viewEvents, viewAttendees, viewOrganizers, login, register, toString, equals//
}
