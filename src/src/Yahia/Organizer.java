package Yahia;

import java.util.Arrays;
import java.util.Scanner;

import Jasmin.*;
import Karma.*;
import x3mara.*;


public class Organizer extends User {
    public Organizer(){
    ID = "O" + System.nanoTime();
    }

    public Organizer(String email, String username, String contactNo, String password, DateTime dateOfBirth, String address, double balance, Gender gen) {
        
        this.email = email;
        this.username = username;
        this.contactNo = contactNo;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.balance = balance;
        this.gen = gen;
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
    public Room rentRoom(DateTime slot, Event event){
        Scanner input = new Scanner(System.in);

        Object[] Temp = Database.readAll(new Room());
        Room[] roomArray = new Room[Temp.length];
        for(int i=0;i<Temp.length;i++){
            roomArray[i] = (Room)Temp[i];
        }

        int numberOfFiltered = 1;
        Room[] roomArrayFiltered = new Room[numberOfFiltered];
        for(int i = 0; i < (Database.readAll((new Room()))).length; i++){
            if(roomArray[i].isAvailable(slot)){
                roomArrayFiltered[numberOfFiltered] = roomArray[i];
                numberOfFiltered++;
            }
        }
        String choiceS = "n";
        int choiceI = 0;
        while(choiceS == "N" || choiceS == "n") {
            System.out.println("Please choose a room from these available rooms:\n");
            for (int i = 0; i < Database.readAll(new Room()).length; i++) {

                System.out.println("(" + i + ")" + " Room ID: " + roomArrayFiltered[i].getID() + "   Room name: " + roomArrayFiltered[i].getRoomName() + "   Room Capacity: " + roomArrayFiltered[i].getRoomCapacity() + "   Rent price: " + roomArrayFiltered[i].getRentPrice());
            }
            choiceI = input.nextInt();
            System.out.println("Are you sure you want to choose room number (" + choiceI + ")");
            System.out.println("Choose (Y/N)");
            choiceS = input.next();
        }
        System.out.println("Congrats, You now have rented room (" + choiceI  + ")");
        roomArrayFiltered[choiceI].reserveSlot(slot,event);
        return roomArrayFiltered[choiceI];


        //search for target room id
        //if room id not found return error message
        //if room id found then print which time slot will be reserved
        //print price
        //at last print are you sure you want to rent room (targetRoomID) for the slots (slotChosen) for (room[targetRoomID])$
        //if yes then call room setter with targetRoomID and change its isAvailable
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
        Object[] T = Database.readAll((new Room()));
        Room[] roomArray = new Room[T.length];
        for(int i=0;i<T.length;i++){
            roomArray[i] = (Room)T[i];
        }
        int numberOfFiltered = 1;
        Room[] roomArrayFiltered = new Room[numberOfFiltered];
        for (int i = 0; i < (Database.readAll((new Room()))).length; i++) {
            if (roomArray[i].isAvailable(slot)) {
                numberOfFiltered++;
                roomArrayFiltered[i] = roomArray[i];
            }
        }
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
                "Create Event (4)\n"+
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
                Event.createEvent(this);
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
