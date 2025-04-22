package Jasmin;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Karma.*;
import Eyadistic.*;
import Omar.*;
import Yahia.*;
import x3mara.*;


public class Event implements HasID {
    static int totEvents =0;
    private String eventID;
    private String eventName;
    private Category eventCat;
    private Room eventRoom;
    private Organizer eventOrg;
    private double ticketPrice;
    private DateTime eventDate;
    private int eventRoomCap;
    private int eventAttendees=0;
//Constructors
    public Event(){this.eventID= "E"+System.nanoTime();}
    public Event(String eventName, Category eventCat, Room eventRoom, Organizer eventOrg ,
                      double ticketPrice, double eventDuration, DateTime eventDate){

        this.eventID= "E"+System.nanoTime();
        this.eventName= eventName;
        this.eventCat= eventCat;
        this.eventRoom= eventRoom;
        this.eventOrg= eventOrg;
        this.ticketPrice= ticketPrice;
        this.eventDate = eventDate;
        eventCat.addEvent(this);
        this.eventRoomCap=eventRoom.getRoomCapacity();
        totEvents++;
    }

    //accessors
    public String getID(){return eventID;}
    public String getEventName(){return eventName;}
    public Category getEventCat(){return eventCat;}
    public Room getEventRoom(){return eventRoom;}
    public Organizer getEventOrg(){return eventOrg;}
    public double getTicketPrice(){return ticketPrice;}
    public DateTime getEventDate() {return eventDate;}
    public int getEventRoomCap(){return eventRoomCap;}
    public int getEventAttendees(){return eventAttendees;}

    //mutators
    public void setEventName(String eventName){this.eventName=eventName;}
    //check that category matches outputted values from category maps before using this setter
    public void setEventCat(Category eventCat){this.eventCat=eventCat;}
    //validate that room is available using isAvailable () before using this setter
    public void setTicketPrice(double ticketPrice){
        if (ticketPrice>0){
            this.ticketPrice=ticketPrice;
        }
    }
    public void setEventDate(DateTime eventDate){
        this.eventDate=eventDate;
    }
    public boolean checkEventAvailability(int nOfTickets){
        if(eventAttendees+nOfTickets>eventRoomCap){
            return false;
        }
        else{
            eventAttendees+=nOfTickets;
            return true;
        }
    }

    //CRUD
    static Scanner input = new Scanner(System.in);
    public void update(){Database.update(this);}
    private void createEvent(User obj) {
        System.out.println("please enter the new event name using underscores instead of spaces:");
        String eventName=input.next();
        Object[] T = Database.readAll(new Category());
        Category[] catArr = new Category[T.length];
        for(int i=0;i<T.length;i++){
            catArr[i] = (Category)T[i];
        }
        for(int i=0;i<catArr.length;i++){
            System.out.println((i+1) + ") " + catArr[i]);
        }
        System.out.println("enter a number corresponding to your category of choice");
        int choice = input.nextInt();
        Category cat= catArr[choice-1];
        //Room room= Organizer.rentRoom();
        System.out.println("please enter ticket price");
        double ticketPrice = input.nextDouble();
        if(ticketPrice<0){
            throw new InputMismatchException("Input should be inbounds.");
        }
        //pls event date i will cry






// eventName, cat, room, this.eventOrg, ticketPrice
        Database.create(new Event());
    }
    public void updateEvent(){

        String[] options = new String[] {"Event name", "Event Category", "Ticket Price ", "Exit"};
        System.out.println("Which Detail do you want to edit? Please enter a number");
        for(int i=0;i<options.length;i++){
            System.out.println((i+1) + ") " + options[i]);
        }
        int choice = input.nextInt();
        if(choice < 1 || choice > options.length){
            throw new InputMismatchException("Input should be inbounds.");
        }
        switch (choice){
            case 1:
                System.out.println("please enter the new event name using underscores instead of spaces:");
                setEventName(input.next());
                break;
            case 2:
                System.out.println("please enter the new event cat");
                Category[] catArr = (Category[]) Database.readAll(new Category());
                for(int i=0;i<catArr.length;i++){
                    System.out.println((i+1) + ") " + catArr[i]);
                }
                System.out.println("enter a number corresponding to your category of choice");
                int catnum = input.nextInt();
                Category cat= catArr[catnum-1];
                String category= this.eventCat.getCatName();
                this.eventCat.deleteEventFromCat(this);
                this.eventCat=cat;
                eventCat.addEvent(this);
                break;
            case 3:
                System.out.println("please enter the new ticket price");
                setTicketPrice(input.nextDouble());

                break;
            case 4:
                break;
        }

        update();
    }
    private void deleteEvent(User obj){
        System.out.println("please confirm that you want to delete this event." );
        System.out.println("press 1 to confirm, any other number to exit");
        int choice = input.nextInt();
        if (choice==1){
            Database.delete(this);
        }
    }
    public static void listAllEvents(){System.out.println(Arrays.toString(Database.readAll(new Event())));}
    public void showEvent(){
        System.out.println(Database.read(this.eventID));
    }


    @Override
    public String toString(){
        String s;
        s="Event ID:"+eventID+"\nEvent name:"+ eventName + "\nEvent Category:"+ eventCat.toString() +
                "\nEvent Room:"+ eventRoom.toString() + "\nEvent organizer:" + eventOrg.toString()+ "\nTicket Price:"+
                ticketPrice + "\nNumber of Event Attendees:"+ eventAttendees+ " out of" + eventRoomCap +
                " hours\nEvent Date:" + eventDate.toString() + "\n\n";

        return s;
    }
    public boolean equals(Event event){return(this.eventID.equals(event.eventID));}

}