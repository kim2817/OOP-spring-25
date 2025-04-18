import java.util.*;


public class organizer {

    private String organizerName;
    private String contactInfo;
    private int numOfEvents;
    private Event[] currentEvents = new Event[numOfEvents];
    private double balance;

    organizer(){

    }

    public organizer(String organizerName, String contactInfo, double balance) {
        this.organizerName = organizerName;
        this.contactInfo = contactInfo;
        this.balance = balance;
    }

    public String getOrganizerName() {
        return organizerName;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public void viewCurrentEvents() {
        for(int i=0;i<numOfEvents;i++){
            System.out.println(currentEvents[i]);
        }
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
    public void showAvailableRooms(){
      //print all rooms with its value of isavailable = true
    }
    public void register(){


    }

    @Override
    public String toString() {
        return "organizer{" +
                "organizerName='" + organizerName + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
