package dummies;
import BackEnd.Attendee;
import BackEnd.Database;
import BackEnd.Event;
import BackEnd.Organizer;

import java.util.Arrays;

public class DummyAdmin {

    private String email = "aaaaaadmin@gmail.com";
    private String username = "admin10101";
    private String contactNo = "987654321";
    private String role = "superman";
    private String workingHours = "12 hours";
    private String ID = "A999";

    public DummyAdmin(String email, String username, String contactNo, String role, String workingHours) {
        System.out.println("admin created");
    }

    // getters
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getContactNo() { return contactNo; }
    public String getRole() { return role; }
    public String getWorkingHours() { return workingHours; }
    public String getID() { return ID; }

    // setters
    public void setEmail(String email) { this.email = email; }
    public void setUsername(String username) { this.username = username; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }
    public void setRole(String role) { this.role = role; }
    public void setWorkingHours(String workingHours) { this.workingHours = workingHours; }

    public void addRooms(Object room, String roomName, int capacity, double price) {
        System.out.println("room created" );
    }

    public String viewEvents() {
        return Arrays.toString(Database.readAll(new Event()));
    }

    public String viewOrganizers() {
        return Arrays.toString(Database.readAll(new Organizer()));
    }

    public String viewAttendee() {
        return Arrays.toString(Database.readAll(new Attendee()));
    }



    @Override
    public String toString(){
        return "Admin{" +
                "email='" + this.email + '\'' +
                ", username='" + this.username + '\'' +
                ", role='" + getRole() + '\'' +
                ", workingHours='" + getWorkingHours() + '\'' +
                ", contactNo='" + this.contactNo + '\'' +
                '}';
    }


}
