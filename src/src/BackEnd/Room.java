package BackEnd;

import java.util.Arrays;
import java.util.Scanner;

public class Room implements HasID {
    private final String roomID;
    private String roomName;
    private int roomCapacity;
    private double rentPrice;
    private String roomLocation;
    private Schedule bookedSlots = new Schedule();

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
    public boolean isAvailable(DateTime slot){
        return bookedSlots.isAvailable(slot);
    }
    public void reserveSlot(DateTime slot, Event event){
        bookedSlots.add(slot,event);
    }
    // CRUD \\
    public static void createRoom(User user){
        if(!(user instanceof Admin)) return;
        Scanner in = new Scanner(System.in);
        System.out.println("Creating Room");
        System.out.print("Room Name: ");
        String roomName = in.next();
        System.out.print("Capacity: ");
        int capacity = in.nextInt();
        System.out.print("Rent Price: ");
        double rentPrice = in.nextDouble();
        System.out.print("Location: ");
        String location = in.next();
        Database.create(new Room(roomName,capacity,rentPrice,location));
    }
    public void update(Admin admin){
        String[] options = new String[]{"Name","Capacity","Rent Price"};
        Scanner in = new Scanner(System.in);
        System.out.println("Choose an option:");
        for(int i=0;i<options.length;i++){
            System.out.println((i+1) + ") " + options[i]);
        }
        int choice = in.nextInt();
        switch (choice){
            case 1:
                setRoomName(in.next());
                break;
            case 2:
                setRoomCapacity(in.nextInt());
                break;
            case 3:
                setRentPrice(in.nextDouble());
                break;
        }
    }
    public void delete(Admin admin){
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