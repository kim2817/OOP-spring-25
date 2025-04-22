package Yahia;

import java.util.Arrays;
import java.util.Scanner;

import Jasmin.*;
import Karma.*;
import x3mara.*;


public class Organizer extends User {
    private Schedule schedule;
    public Organizer(){
    ID = "O" + System.nanoTime();
    }

    public Organizer(String email, String username, String contactNo, String password, DateTime dateOfBirth, String address, double balance, Gender gen, Schedule schedule) {
        
        this.email = email;
        this.username = username;
        this.contactNo = contactNo;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.balance = balance;
        this.gen = gen;
        this.schedule = schedule;
        ID = "O" + System.nanoTime();
    }
    public String getContactInfo() {
        return contactNo;
    }
    public void viewCurrentEvents() {
         System.out.println(Arrays.toString(Database.readAll(new Event())));
    }

    public void manageEventDetails() {
        String targetID;
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter event ID");
        targetID = cin.next();
        Event chosenEvent = (Event) Database.read(targetID);
        System.out.println("Event found: " + chosenEvent.getEventName());
        System.out.println("Would you like to update the event? (yes/no)");
        String response = cin.next();
        if (response.equalsIgnoreCase("yes")) {
            chosenEvent.updateEvent();
        }
    }



    public void viewEventStats(){
        String targetID;
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter event ID");
        targetID = cin.next();
        Event chosenEvent = (Event) Database.read(targetID);
        System.out.println(chosenEvent);
        //search for target event id
        //call getters of event with target id
        //if target id was not found return error message
    }

    //we somehow need to get the room ID that is related to this room's ID
    public void rentRoom(DateTime slot){
        String targetRoomID;
        String choice;
        Scanner cin = new Scanner(System.in);
        targetRoomID = cin.next();
        Room[] roomArray = (Room[]) Database.readAll((new Room()));

        for (int i = 0; i < Database.readAll(new Room()).length; i++){
            if (targetRoomID.equals(roomArray[i].getID())){
                if (roomArray[i].isAvailable(slot)) {
                    roomArray[i].reserveSlot(slot);
                    System.out.println("The room with ID " + roomArray[i].getID() + " is available and costs " + roomArray[i].getRentPrice());
                }
            }
            else{
                if (!roomArray[i].isAvailable(slot)){
                    System.out.println("The room with ID " + roomArray[i].getID() + " is already taken!");
                }
                else {
                    System.out.println("The room with ID " + roomArray[i].getID() + " doesn't exit.");
                }
            }
        }
        //search for target room id
        //if room id not found return error message
        //if room id found then print which time slot will be reserved
        //print price
        //at last print are you sure you want to rent room (targetRoomID) for the slots (slotChosen) for (room[targetRoomID])$
        //if yes then call room setter with targetRoomID and change its isAvailable
        cin.close();
    }

    public void create(){
        Database.create(this);
    }
    public void update(){
        Database.update(this);
    }
    public void delete(){
        Database.delete(this);
    }

    static public void listEvents(){
        System.out.println(Arrays.toString(Database.readAll(new Event())));
    }

    public void showAvailableRooms(DateTime slot) {
        Room[] roomArray = (Room[]) Database.readAll((new Room()));
        int numberOfFiltered = 1;
        Room[] roomArrayFiltered = new Room[numberOfFiltered];
        for (int i = 0; i < (Database.readAll((new Room()))).length; i++) {
            if (roomArray[i].isAvailable(slot)) {
                numberOfFiltered++;
                roomArrayFiltered[i] = roomArray[i];
            }
        }
        numberOfFiltered--;
    }

    public void register(){

    }

    public void organizerInterface(){
    Scanner cin = new Scanner(System.in);
    System.out.println("Organizer Dashboard\n" +
            "Username: "+ this.username +
            "\nEmail: " + this.email +
            "\nPassword: " + this.password +
            "\nContact Info:" + this.contactNo);

        System.out.println("Choose a function\n" +
                "List All Events (1)\n"
                + "Manage Event details (2)\n" +
                "View Specific event details (3)\n"+
                "Rent room (4)\n"+
                "List available rooms (5)");

        int choice = cin.nextInt();
        switch (choice){
            case 1:
                viewCurrentEvents();
                break;
            case 2:
                manageEventDetails();
                break;
            case 3:
                viewEventStats();
                break;
            case 4:
                DateTime date2 = new DateTime();
                System.out.println("Choose a time slot: \n"+"MORNING (1)\n"+
                        "AFTERNOON (2)\n"+
                        "EVENING (3)");
                date2.setTime(TimeSlot.translate(cin.nextInt()));
                System.out.println("Enter day:");
                date2.setDay(cin.nextInt());
                System.out.println("Enter month:");
                date2.setMonth(cin.nextInt());
                System.out.println("Enter year:");
                date2.setYear(cin.nextInt());
                rentRoom(date2);
                break;
            case 5:
                DateTime date = new DateTime();
                System.out.println("Choose a time slot: \n"+"MORNING (1)\n"+
                        "AFTERNOON (2)\n"+
                        "EVENING (3)");
                date.setTime(TimeSlot.translate(cin.nextInt()));
                System.out.println("Enter day:");
                date.setDay(cin.nextInt());
                System.out.println("Enter month:");
                date.setMonth(cin.nextInt());
                System.out.println("Enter year:");
                date.setYear(cin.nextInt());
                showAvailableRooms(date);
                break;
            default :
                return;
        }
        organizerInterface();
    }

    @Override
    public String getID(){
        return ID;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance + '\'' +
                ", gen=" + gen + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
