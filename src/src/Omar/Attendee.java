package Omar;
import Yahia.gender;
import x3mara.HasID;
import Yahia.User;
import java.util.Date;
import Karma.*;
import x3mara.*;
import Jasmin.*;
import java.util.Scanner;

public class Attendee extends User implements HasID {
    private String ID;
    private int age;
    private String city;
    private Wallet balance;
    private int[][] Purchasedtickets;
    private Category[] interest = new Category[3];

    public Attendee() {
        this.ID = "A" + System.nanoTime();
    }

    public Attendee(String email, String username, String contactNo, String password,
                    Date dateOfBirth, String address, gender gen,
                    int age, String city, int[][] Purchasedtickets, double walletBalance) {
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
        this.Purchasedtickets = Purchasedtickets;
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
    public void Attendeedeposit(double money){
        balance.deposit(money);
    }

    public int[][] getPurchasedtickets() {
        return Purchasedtickets;
    }

    public void chooseInterest() {
        System.out.println(Database.readAll(new Category()));
        System.out.println("Please type Category ID");
        Scanner input = new Scanner(System.in);
        for (int i = 0 ; i<3 ;i++){
            String tempID = input.next();
            interest[i] = (Category) Database.read(tempID);
        }

    }

    public void showEvents() {
        System.out.println(Database.readAll(new Event()));
    }

    public void chooseEvent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please type Event ID");
        String tempID = input.next();
         Event chosenEvent =(Event)  Database.read(tempID);
        try{
            System.out.println(chosenEvent);
            System.out.println("number of tickets");
            int temmmp = input.nextInt();
            buyTickets(temmmp,tempID,(chosenEvent.getTicketPrice()));
        }catch (Exception ex){
            System.out.println("Something wrong happened here -_-");
        }
    }

    public void buyTickets(int noOfTickets, String eventID, double price) {
        double total = price * noOfTickets;

        if (balance.isSufficient(total)) {
            balance.withdraw(total);
            System.out.println("You have purchased " + noOfTickets + " ticket(s) for event ID " + eventID);
        } else {
            throw new RuntimeException("Not enough moneym,get a job");
        }
    }

    public void register() {

    }


    @Override
    public String toString() {
        return  "Attendee[age=" + age + ", city=" + city + ", balance=" + balance.getBalance() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Attendee) {
            return this.age == ((Attendee) o).age && this.city.equals(((Attendee) o).city);
        } else return false;
    }
}
