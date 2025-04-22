package Jasmin;
import java.util.Arrays;
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
    private TimeSlot eventTime;
    private int eventRoomCap;
    private int eventAttendees=0;
//Constructors
    public Event(){this.eventID= "E"+System.nanoTime();}
    public Event(String eventName, Category eventCat, Room eventRoom, Organizer eventOrg ,
                      double ticketPrice, double eventDuration, DateTime eventDate,TimeSlot eventTime  ){

        this.eventID= "E"+System.nanoTime();
        this.eventName= eventName;
        this.eventCat= eventCat;
        this.eventRoom= eventRoom;
        this.eventOrg= eventOrg;
        this.ticketPrice= ticketPrice;
        this.eventDate = eventDate;
        this.eventTime= eventTime;
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
    public TimeSlot getEventTime(){return eventTime;}
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
    public void setEventTime( TimeSlot eventTime){
        this.eventTime=eventTime;
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
    public void update(){Database.update(this);}
    private void createEvent(User obj) {Database.create(this);}
    private void updateEvent(String eventName, Category eventCat, Room eventRoom, Organizer eventOrg ,
                             double ticketPrice, double eventDuration, DateTime eventDate, TimeSlot eventTime ){

//        static String[] options = new String[] {"Event name", "Event Category", "Event "}
        this.eventName= eventName;
        this.eventCat= eventCat;
        this.ticketPrice= ticketPrice;

        update();
    }
    private void deleteEvent(User obj){Database.delete(this);}
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
                " hours\nEvent Date:" + eventDate.toString() + "\nEvent Time: " + eventTime.toString()+"\n\n";

        return s;
    }
    public boolean equals(Event event){return(this.eventID.equals(event.eventID));}

}