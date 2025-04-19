package x3mara;

public class Wallet implements HasID {
    private final String walletID;
    private double balance;
    public Wallet(){
        walletID = "W" + System.nanoTime();
    }
    public Wallet(double balance){
        walletID = "W" + System.nanoTime(); // change to user id
        this.balance = balance;
        Database.create(this);
    }
    public double getBalance() {
        return balance;
    }
    public boolean isSufficient(double amount){
        return (balance >= amount);
    }
    public void deposit(double amount){
        balance += amount;
        Database.update(this);
    }
    public void withdraw(double amount){
        if(!isSufficient(amount)) throw new IllegalArgumentException("Insufficient Balance; balance: " + balance + "; attempted withdraw amount: " + amount);
        deposit(-amount);
    }
    public void transferTo(double amount, Wallet recipient){
        withdraw(amount);
        recipient.deposit(amount);
    }
    public String getID() {
        return walletID;
    }

    @Override
    public String toString() {
        return "{ID: " + walletID + "; Balance: " + balance + "}";
    }
}