package Jasmin;
import java.util.Date;
import Karma.Category;
import Eyadistic.Admin;
import Omar.Attendee;
import x3mara.Database;
import x3mara.Room;
import x3mara.Schedule;
import x3mara.TimeSlot;
import Yahia.Organizer;

public class Event {
    static int totEvents =0;
    private String eventID;
    private String eventName;
    private Category eventCat;
    private Room eventRoom;
    private Organizer eventOrg;
    private double ticketPrice;
    private double eventDuration;
    private Schedule eventDate;
    private TimeSlot eventTime;
    private Attendee [] eventAttendees;


    public void Event(){
        totEvents++;
    }
    public void Event(String eventName, Category eventCat, Room eventRoom, Organizer eventOrg ,
                      double ticketPrice, double eventDuration, Schedule eventDate,TimeSlot eventTime  ){
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
        totEvents++;

    }

    public String getEventID(){
        return eventID;
    }
    public String getEventName(){
        return eventName;
    }
    public Category getEventCat(){
        return eventCat;
    }
    public Room getEventRoom(){
        return eventRoom;
    }
    public Organizer getEventOrg(){
        return eventOrg;
    }
    public double getTicketPrice(){
        return ticketPrice;
    }
    public Attendee [] getEventAttendees(){
        return eventAttendees;
    }
    public double getEventDuration(){
        return eventDuration;
    }
    public Schedule getEventDate() {
        return eventDate;
    }
    public TimeSlot getEventTime(){
        return eventTime;
    }

    public void setEventName(String eventName){
        this.eventName=eventName;
    }
    //check that category matches outputted values from category maps before using this setter
    public void setEventCat(Category eventCat){
        this.eventCat=eventCat;
    }
    //validate that room is available using isAvailable () before using this setter
    public void setEventRoom(Room eventRoom){
        this.eventRoom=eventRoom;
    }
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
    public void setEventDate(Schedule eventDate){
        this.eventDate=eventDate;
    }
    public void setEventTime( TimeSlot eventTime){
        this.eventTime=eventTime;
    }

    public void createEvent(String eventName, Category eventCat, Room eventRoom, Organizer eventOrg ,
                            double ticketPrice, double eventDuration, Schedule eventDate, TimeSlot eventTime ){
        Event(eventName, eventCat,eventRoom,eventOrg,ticketPrice, eventDuration, eventDate, eventTime );

    }
    // organizers part
    public void updateEvent(int eventID ,String eventName, Category eventCat, Room eventRoom,
                            Organizer eventOrg , double ticketPrice, double eventDuration, Schedule eventDate,
                            TimeSlot eventTime, Attendee [] eventAttendees){
        //search for eventID in hashmap
    }
    public void listEvents(){

    }
    public void deleteEvent(int eventID){

    }

    @Override
    public String toString(){
        String s;
        s="Event ID:"+eventID+"\nEvent name:"+ eventName + "\nEvent Category:"+ eventCat.toString() +
                "\nEvent Room:"+ eventRoom.toString() + "\nEvent organizer:" + eventOrg.toString()+


        return s;
    }
    public boolean equal(Event event){

        return(this.eventID.equals(event.eventID));
    }

}