package Omar;
import Yahia.Gender;
import x3mara.HasID;
import Yahia.User;
import java.util.Arrays;
import Karma.*;
import x3mara.*;
import Jasmin.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Attendee extends User implements HasID {
    private String ID;
    private int age;
    private String city;
    private Wallet balance;
    private Category[] interest = new Category[3];
    private ArrayList<Event> bookedEvents = new ArrayList<>();

    public Attendee() {
        this.ID = "A" + System.nanoTime();
    }

    public Attendee(String email, String username, String contactNo, String password,
                    DateTime dateOfBirth, String address, Gender gen,
                    int age, String city,  double walletBalance) {
        this.email = email;
        this.username = username;
        this.contactNo = contactNo;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gen = gen;
        this.ID = "A" + System.nanoTime();
        this.age = age;
        this.city = city;
        this.balance = new Wallet(walletBalance);
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public double getBalance() {
        return balance.getBalance();
    }

    public void attendeeDeposit(double money){
        balance.deposit(money);
    }


    public void ShowInterest() {
        System.out.println("Please enter 3 Category:");
        Scanner input = new Scanner(System.in);
        Object[] T = Database.readAll(new Category());
        Category[] options = new Category[T.length];
        for(int i=0;i<T.length;i++){
            options[i] = (Category)T[i];
        }
        for(int i=0;i<options.length;i++) {
            System.out.println((i + 1) + ") " + options[i]);
        }
        for(int i=0;i<3;i++){
            int temp = input.nextInt();
            temp = temp-1;
            if (temp < 0 || temp >= options.length) {
                throw new InvalidCategoryindex("CHOOSE THE RIGHT INDEX NEXT TIME");
            }

            interest[i] = (Category) Database.read(options[temp].getID());
        }
        ArrayList<Event> tempEvents = new ArrayList<>();
        for(int  i = 0; i<3 ;i++){

            Event [] tempeventsarray = interest[i].getEvents().toArray(new Event[0]);
            for(int j =0;j< tempeventsarray.length;j++){
                tempEvents.add(tempeventsarray[j]);
            }
        }
        for (Event e:tempEvents) {
            System.out.println(e);
        }

    }

    public void showEvents() {
        System.out.println(Arrays.toString(Database.readAll(new Event())));
    }
    public void showBookedevents() {
        if (bookedEvents.isEmpty()) {
            System.out.println("No events booked yet.");
        } else {
            for (Event e : bookedEvents) {
                System.out.println(e);
            }
        }
    }
    public void chooseEvent() {
        Scanner input = new Scanner(System.in);
        Object[] T = Database.readAll(new Event());
        Event[] options = new Event[T.length];
        for (int i = 0; i < T.length; i++) {
            options[i] = (Event) T[i];
        }
        System.out.println("Please select an event:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") ID: " + options[i]);
        }
        try{
            int temp = input.nextInt();
            temp = temp-1;
            Event chosenEvent = options[temp];
            System.out.println(chosenEvent);
            System.out.println("number of tickets");
            int count = input.nextInt();
            buyTickets(count, chosenEvent.getID());
        }catch (Exception ex){
            System.out.println("Something wrong happened here -_-");
        }
    }

    public void buyTickets(int noOfTickets, String eventID) {
        Event temppurchased = (Event) Database.read(eventID);
        double price = temppurchased.getTicketPrice();
        double total = price * noOfTickets;
        if(noOfTickets < 0){
            throw new NotPostiveAmount("number of tickers is 0");
        }
        if (!balance.isSufficient(total)){
            throw new FundsNOTenough("Not enough money g");
        } if(!temppurchased.isThereEnough(noOfTickets)) {
            throw new EventnotAvaible("Event is not avaible hehe");
        }
        balance.withdraw(total);
        temppurchased.addAttendee(noOfTickets);
        bookedEvents.add(temppurchased);
        System.out.println("You have purchased " + noOfTickets + " ticket(s) for event ID " + eventID);


    }
    public void attendeeInterface(){
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Please choose one of the following option
                       1) getId
                       2) getBalance
                       3) Deposit money
                       4) get recommendation based on your interest
                       5) Show events
                       6) Choose events
                       7) Show booked events
                       8) View wallet details
                       9) Exit""");
        int answer = input.nextInt();
        switch (answer){
            case 1:
                System.out.println(this.getID());
                break;
            case 2:
                System.out.println(this.getBalance());
                break;
            case 3:
                System.out.println("please enter a value");
                double deposit = input.nextDouble();
                this.attendeeDeposit(deposit);
                break;
            case 4:
                this.ShowInterest();
                break;
            case 5:
                this.showEvents();
                break;
            case 6:
                this.chooseEvent();
                break;
            case 7:
                this.showBookedevents();
                break;
            case 8:
                this.viewWalletdetails();
                break;
            default:
                return;
        }
        attendeeInterface();
    }
    public void viewWalletdetails() {
        System.out.println("Wallet Details: " + balance);
    }



    @Override
    public String toString() {
        return  "Attendee[age=" + age + ", city=" + city + ", balance=" + balance.getBalance() + ", DoB: " + dateOfBirth + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Attendee) {
            return this.age == ((Attendee) o).age && this.city.equals(((Attendee) o).city);
        } else return false;
    }
    @Override
    public String getID() {
        return ID;
    }

}
