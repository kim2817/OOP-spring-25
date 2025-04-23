package Omar;
import Yahia.Gender;
import com.sun.tools.javac.Main;
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

    @Override
    public String getID() {
        return ID;
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


    public void chooseInterest() {
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

            Event [] ughx2 = interest[i].getEvents().toArray(new Event[0]);
            for(int j =0;j< ughx2.length;j++){
                tempEvents.add(ughx2[j]);
            }
        }
        for (Event e:tempEvents) {
            System.out.println(e);
        }

    }

    public void showEvents() {
        System.out.println(Arrays.toString(Database.readAll(new Event())));
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
        Event temppurchased = new Event();
        temppurchased = (Event) Database.read(eventID);
        double price = temppurchased.getTicketPrice();
        double total = price * noOfTickets;
        if(noOfTickets < 0){
            throw new NotPostiveAmount("number of tickers is 0");
        }
        if (!balance.isSufficient(total)){
            throw new FundsNOTenough("Not enough money g");
        } if(!temppurchased.isthereEnough(noOfTickets)) {
            throw new EventnotAvaible("Event is not avaible hehe");
        }
        balance.withdraw(total);
        temppurchased.AddAttendee(noOfTickets);
        System.out.println("You have purchased " + noOfTickets + " ticket(s) for event ID " + eventID);


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
    public void attendeeInterface(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please choose one of the following option\n1) getId \n2) getBalance\n3) Deposit money\n4) get recommendation based on your interest" +
                "\n5) Show events \n6) choose events\n7) Exit");
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
                this.chooseInterest();
                break;
            case 5:
                this.showEvents();
                break;
            case 6:
                this.chooseEvent();
                break;
            default:
                return;
        }
        attendeeInterface();
    }
}
