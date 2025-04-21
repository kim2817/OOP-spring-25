package Yahia;

import Jasmin.Event;


import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

import Karma.*;
import x3mara.*;
import Jasmin.*;


public class Organizer extends User {
private Schedule schedule;
    public Organizer(){
    ID = "O" + System.nanoTime();
    }

    public Organizer(String email, String username, String contactNo, String password, Date dateOfBirth, String address, double balance, gender gen,Schedule schedule) {
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
            System.out.println("What would you like to update?");
            System.out.println("1. Name");
            System.out.println("2. Category");
            System.out.println("3. Price");
            System.out.println("4. Date");
            int lol = cin.nextInt();
            switch (lol) {
                case 1:
                    System.out.println("Enter the new event name:");
                    String newName = cin.nextLine();
                    chosenEvent.setEventName(newName);
                    break;
                case 2:
                    System.out.println("Enter the new event Category:");
                    String newCaT = cin.nextLine();
                    chosenEvent.setEventCat(new Category(newCaT));
                    break;
                case 3:
                    System.out.println("Enter the new event price:");
                    int newPrice = cin.nextInt();
                    chosenEvent.setTicketPrice(newPrice);
                    break;
                case 4:
                    while (true) {
                        System.out.println("Enter the new event Date in the format DD/MM/YYYY");
                        String newDate = cin.next();
                        try {
                            String[] parts = newDate.split("/");
                            int day = Integer.parseInt(parts[0]);
                            int month = Integer.parseInt(parts[1]);
                            int year = Integer.parseInt(parts[2]);
                            DateTime UGHH = new DateTime(day, month, year);
                            if (schedule.isAvailable(UGHH)) {
                                chosenEvent.setEventDate(UGHH);
                                schedule.add(UGHH);
                                break;
                            } else {
                                System.out.println("Date is already taken. Try another one.");
                            }
                        } catch (Exception e) {
                            System.out.println("WRONG Format  IDIOT");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid number from the list (1-4)(idiot).");
            }
        }
    }



    public void viewEventStats(){
        String targetID;
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter event ID");
        targetID = cin.next();
        Event chosenEvent = (Event) Database.read(targetID);
        System.out.println(
                chosenEvent.getID()
                        + chosenEvent.getEventName()
                        + Arrays.toString(chosenEvent.getEventAttendees())
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

    public void showAvailableRooms(DateTime slot){
        Room[] roomArray = (Room[])Database.readAll((new Room()));

        for(int i = 0; i < (Database.readAll((new Room()))).length; i++){
            if(roomArray[i].isAvailable(slot)){
                System.out.println(roomArray[i].toString());
            }
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
