package Jasmin;
import java.util.Arrays;
import java.util.Date;
import Karma.*;
import Eyadistic.Admin;
import Omar.Attendee;
import Yahia.User;
import x3mara.*;
import Yahia.Organizer;

public class Event implements HasID {
    static int totEvents =0;
    private String eventID;
    private String eventName;
    private Category eventCat;
    private Room eventRoom;
    private Organizer eventOrg;
    private double ticketPrice;
    private double eventDuration;
    private DateTime eventDate;
    private TimeSlot eventTime;
    private Attendee [] eventAttendees;

//Constructors
    public Event(){
        totEvents++;
    }
    public Event(String eventName, Category eventCat, Room eventRoom, Organizer eventOrg ,
                      double ticketPrice, double eventDuration, DateTime eventDate,TimeSlot eventTime  ){
        this.eventID= "E"+System.nanoTime();
        this.eventName= eventName;
        this.eventCat= eventCat;
        this.eventRoom= eventRoom;
        this.eventOrg= eventOrg;
        this.ticketPrice= ticketPrice;
        this.eventDuration= eventDuration;
        this.eventDate = eventDate;
        this.eventTime= eventTime;
        this.eventAttendees = new Attendee[100];
        eventCat.addEvent(this);
        totEvents++;
    }

    //accessors
    public String getID(){return eventID;}
    public String getEventName(){return eventName;}
    public Category getEventCat(){return eventCat;}
    public Room getEventRoom(){return eventRoom;}
    public Organizer getEventOrg(){return eventOrg;}
    public double getTicketPrice(){return ticketPrice;}
    public Attendee [] getEventAttendees(){return eventAttendees;}
    public double getEventDuration(){return eventDuration;}
    public DateTime getEventDate() {return eventDate;}
    public TimeSlot getEventTime(){return eventTime;}

    //mutators
    public void setEventName(String eventName){this.eventName=eventName;}
    //check that category matches outputted values from category maps before using this setter
    public void setEventCat(Category eventCat){this.eventCat=eventCat;}
    //validate that room is available using isAvailable () before using this setter
    public void setEventRoom(Room eventRoom){this.eventRoom=eventRoom;}
    public void setTicketPrice(double ticketPrice){
        if (ticketPrice>0){
            this.ticketPrice=ticketPrice;
        }
    }
    public void setEventDuration(double eventDuration){
        if (eventDuration > 0) {
            this.eventDuration=eventDuration;
        }
    }
    public void setEventDate(DateTime eventDate){
        this.eventDate=eventDate;
    }
    public void setEventTime( TimeSlot eventTime){
        this.eventTime=eventTime;
    }

    //CRUD
    private void createEvent(User obj) {
        Database.create(this);
    }
    private void updateEvent(User obj){
        Database.update(this);
    }
    private void deleteEvent(User obj){
        Database.delete(this);
    }
    public static void listAllEvents(){
        System.out.println(Arrays.toString(Database.readAll(new Event())));
    }


    @Override
    public String toString(){
        String s;
        s="Event ID:"+eventID+"\nEvent name:"+ eventName + "\nEvent Category:"+ eventCat.toString() +
                "\nEvent Room:"+ eventRoom.toString() + "\nEvent organizer:" + eventOrg.toString()+ "\nTicket Price:"+
                ticketPrice + "\nEvent Attendees:"+ eventAttendees.toString() + "\n Event Duration:" + eventDuration +
                " hours\nEvent Date:" + eventDate.toString() + "\nEvent Time: " + eventTime.toString();


        return s;
    }
    public boolean equals(Event event){

        return(this.eventID.equals(event.eventID));
    }

}