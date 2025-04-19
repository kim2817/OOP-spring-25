package Omar;

import java.util.UUID;

class Attendee {
    private String id;
    private int age;
    private String city;
    private Wallet balance;
    private int[][] Purchasedtickets;

    Attendee() {
        this.id = UUID.randomUUID().toString();
    }

    Attendee(int age, String city, int[][] Purchasedtickets, double balance) {
        this.id = UUID.randomUUID().toString();
        this.age = age;
        this.city = city;
        this.balance = new Wallet(balance);
        this.Purchasedtickets = Purchasedtickets;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public Wallet getBalance() {
        return balance.getBalance();
    }
    public void Attendeedeposit(double money){
        balance.deposit(money);
    }

    public int[][] getPurchasedtickets() {
        return Purchasedtickets;
    }

    public Category chooseInterest() {
        return new Category();
    }

    public Event showEvents() {
        return new Event();
    }

    public void chooseEvent() {
        ///
    }

    public void buyTickets(int noOfTickets, int eventID, int price) {
        double total = price * noOfTickets;
        if (balance.isSufficient(total)) {
            balance.withdraw(total);
            System.out.println("You have purchased" + noOfTickets + "for eventID" + eventID);
        } else {
            System.out.println("Insufficient balance");
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
