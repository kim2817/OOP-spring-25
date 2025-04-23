package Eyadistic;
import java.util.Arrays;

import Karma.DateTime;
import Yahia.Organizer;
import Yahia.User;
import Omar.Attendee;
import Yahia.Gender;
import x3mara.*;
import Jasmin.Event;
import Karma.Category;

import java.util.Date;
import java.util.Scanner;


public class Admin extends User{

    //Attributes
    private String role;
    private String workingHours;
    private String ID;


    //Constructors//
    public Admin(){}

    public Admin(String email, String username, String contactNo, String password,
                 DateTime dateOfBirth, String address, Gender gen, String role, String workingHours) {
        this.email = email;
        this.username = username;
        this.contactNo = contactNo;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gen = gen;
        this.ID = "a" + System.nanoTime();
        this.workingHours = workingHours;
        this.role = role;
    }


    //Setters and getters
    public String getRole() {
        return role;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public String getID() {
        return ID;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public void setID(String ID) {
        this.ID = "a" + System.nanoTime();
    }

    //Methods


    public void addRooms(Room o, String roomName, int roomCapacity, double rentPrice){
    Database.create(o);
    o.setRoomName(roomName);
    o.setRoomCapacity(roomCapacity);
    o.setRentPrice(rentPrice);
    }

    public void viewEvents(){
        System.out.println(Arrays.toString(Database.readAll(new Event())));
    }

    public void viewOrganizers(){
        System.out.println(Arrays.toString(Database.readAll(new Organizer())));
    }

    public void viewAttendee(){
        System.out.println(Arrays.toString(Database.readAll(new Attendee())));
    }



    // CRUD
    private void createCat() {
        Database.create(this);
    }
    private void updateCat(){
        Database.update(this);
    }
    private void deleteCat(){
        Database.delete(this);
    }
    public static void listAllCategories(){
        System.out.println(Arrays.toString(Database.readAll(new Category())));
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

    public boolean equals(Object o){
        if (o instanceof Admin){
            return (this.role.equals(((Admin) o).getRole()) && (this.workingHours.equals(((Admin) o).getWorkingHours())));
        }
        else return false;
    }
    public void adminInterface(){
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("\n Please choose an option of the following");
        System.out.println(" 1) Add room\n 2) View events\n 3) View organizers\n 4) View Attendee\n\n CRUD:\n 5) Create Category\n 6) Delete Category\n 7) Update Category\n 8) List all Categories");
        switch(input.nextInt()){
            case 1:
                Room o = new Room();
                String roomName;
                int Roomcapacity;
                double rentprice;
                System.out.println("Please set room name");
                roomName = input.next();
                System.out.println("Please set room capacity");
                Roomcapacity = input.nextInt();
                System.out.println("Please set rent price");
                rentprice = input.nextDouble();
                addRooms(o, roomName, Roomcapacity, rentprice);
                System.out.println("Room is succesfully added. YIPEEE!!");
                break;
            case 2:
                viewEvents();
                break;
            case 3:
                viewOrganizers();
                break;
            case 4:
                viewAttendee();
                break;
            case 5:
                createCat();
                break;
            case 6:
                deleteCat();
                break;
            case 7:
                updateCat();
                break;

        }
    }
}
