package x3mara;

import java.util.Arrays;
import java.util.Date;

public class Room implements HasID{
    private final String roomID;
    private String roomName;
    private int roomCapacity;
    private double rentPrice;
    private String roomLocation;
    private Schedule bookedSlots;

    public Room(){
        this("",100,100.00,"");
    }
    public Room(String roomName, int roomCapacity, double rentPrice, String roomLocation){
        roomID = "R" + System.nanoTime();
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.rentPrice = rentPrice;
        this.roomLocation = roomLocation;
    }

    // accessors \\
    public String getID() {
        return roomID;
    }
    public String getRoomName() {
        return roomName;
    }
    public int getRoomCapacity() {
        return roomCapacity;
    }
    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }
    public double getRentPrice() {
        return rentPrice;
    }
    // mutators \\
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }
    public boolean isAvailable(Date date, TimeSlot timeSlot){
        return bookedSlots.isAvailable(date, timeSlot);
    }
    public void reserveSlot(Date date, TimeSlot timeSlot){
        bookedSlots.add(date, timeSlot);
    }
    // CRUD \\
    public void create(){
        Database.create(this);
    }
    public void update(){
        Database.update(this);
    }
    public void delete(){
        Database.delete(this);
    }
    static public void listRooms(){
        System.out.println(Arrays.toString(Database.readAll(new Room())));
    }

    @Override
    public String toString() {
        return "{ID: " + roomID + "; Name: " + roomName + "; Capacity: " + roomCapacity + "; Rent Price: " + rentPrice + "; Location: " + roomLocation + "; Booked Slots: " + bookedSlots + "}";
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Room)) return false;
        return (this.roomID).equals(((Room)obj).getID());
    }
}