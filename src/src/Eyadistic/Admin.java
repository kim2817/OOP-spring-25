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
    private Wallet balance;



    //Constructors//
    public Admin(){}

    public Admin(String email, String username, String contactNo, String password,
                 DateTime dateOfBirth, String address, Gender gen, String role, String workingHours, double walletBalance) {
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
        this.balance = new Wallet(walletBalance);
    }





    //Setters and getters
    public String getRole() {return role;}
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
    public void setBalance(Wallet balance) {this.balance = balance;}


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

    public static void listAllCategories(){
        System.out.println(Arrays.toString(Database.readAll(new Category())));
    }

    public void adminInterface(){
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("\n Please choose an option of the following");
        System.out.println(" 1) Add room\n 2) View events\n 3) View organizers\n 4) View Attendee\n\n CRUD:\n 5) Create Category\n 6) Delete Category\n 7) Update Category\n 8) List all Categories\n 9) Create room\n 10) Update room\n 11) Delete room\n 12) list rooms\n\n 13) Exit");
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
                System.out.println("Room "+ roomName + "succesfully added.");
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
                Category.addCatToDatabase(this);
                break;
            case 6:
                Category[] T = (Category[]) Database.readAll(new Category());
                Category[] options = new Category[T.length];
                for(int i=0;i<T.length;i++){
                    options[i] = (Category)T[i];
                }
                System.out.println("Please choose a category to update");
                for (int i=0;i< options.length;i++){
                    System.out.println("(" + i + ")" + "Category name: " + options[i].getCatName() + "   Category event: " + options[i].getEvents());
                }
                options[input.nextInt()].updateCatInDatabase(this);
                break;
            case 7:
                Category[] S = (Category[]) Database.readAll(new Category());
                Category[] options2 = new Category[S.length];
                for(int i=0;i<S.length;i++){
                    options2[i] = (Category)S[i];
                }
                System.out.println("Please choose a category to update");
                for (int i=0;i< options2.length;i++){
                    System.out.println("(" + i + ")" + "Category name: " + options2[i].getCatName() + "   Category event: " + options2[i].getEvents());
                }
                options2[input.nextInt()].deleteCatFromDatabase(this);
                break;
            case 8:
                listAllCategories();
                break;
            case 9:
                Room.createRoom(this);
                break;
            case 10:
                Room[] Q = (Room[]) Database.readAll(new Room());
                Room[] options3 = new Room[Q.length];
                for(int i=0;i<Q.length;i++){
                    options3[i] = (Room)Q[i];
                }
                System.out.println("Please choose a room to update");
                for (int i=0;i<options3.length;i++){
                    System.out.println("(" + i + ")" + "Room name: " + options3[i].getRoomName() + "   Room ID: " + options3[i].getID());
                }
                options3[input.nextInt()].delete(this);
                break;

            case 11:
                Room[] W = (Room[]) Database.readAll(new Room());
                Room[] options4 = new Room[W.length];
                for(int i=0;i<W.length;i++){
                    options4[i] = (Room)W[i];
                }
                System.out.println("Please choose a room to update");
                for (int i=0;i<options4.length;i++){
                    System.out.println("(" + i + ")" + "Room name: " + options4[i].getRoomName() + "   Room ID: " + options4[i].getID());
                }
                options4[input.nextInt()].delete(this);
                break;
            case 12:
                Room.listRooms();
                break;
            default:
                return;

        }
        adminInterface();
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

    @Override
    public boolean equals(Object o){
        if (o instanceof Admin){
            return (this.role.equals(((Admin) o).getRole()) && (this.workingHours.equals(((Admin) o).getWorkingHours())));
        }
        else return false;
    }

}
