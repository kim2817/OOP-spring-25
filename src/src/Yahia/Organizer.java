package Yahia;

import Jasmin.Event;


import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import x3mara.*;


public class Organizer extends User {

    public Organizer(){
    ID = "O" + System.nanoTime();
    }

    public Organizer(String email, String username, String contactNo, String password, Date dateOfBirth, String address, double balance, gender gen) {
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
         System.out.println(Database.readAll(new Event()));
    }

    public void manageEventDetails(){
        String targetID;
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter event ID");
        targetID = cin.next();
        //search for target event id
        //call setters of event with target id
        //if target id was not found return error message
        cin.close();
    }

    public void viewEventStats(){
        String targetID;
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter event ID");
        targetID = cin.next();
        Event chosenEvent = (Event) Database.read(targetID);
        System.out.println(
                chosenEvent.getEventID()
                        + chosenEvent.getEventName()
                        + chosenEvent.getEventAttendees()
                        + chosenEvent.getEventCat()
                        + chosenEvent.getEventDate()
                        + chosenEvent.getEventDuration()
                        + chosenEvent.getTicketPrice()
                        + chosenEvent.getEventRoom()
                        + chosenEvent.getEventTime()
        );

        //search for target event id
        //call getters of event with target id
        //if target id was not found return error message
        cin.close();
    }

    public void rentRoom(){
        String targetRoomID;
        Scanner cin = new Scanner(System.in);
        targetRoomID = cin.next();
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

    public void showAvailableRooms(Date date, TimeSlot timeSlot){
        for(int i = 0;i < (Database.readAll((new Room()))).length;i++){


        }
    }

    public void register(){

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
                ", balance=" + balance +
                ", gen=" + gen +
                ", ID='" + ID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
