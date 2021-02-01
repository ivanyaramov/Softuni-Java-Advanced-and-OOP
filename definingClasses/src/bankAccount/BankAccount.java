package bankAccount;

public class BankAccount {

    private double balance;
    private static double interestRate=0.02;
    private static int IDcurrent=1;
    private int id=IDcurrent;
    public static void setInterestRate(double interest){
        BankAccount.interestRate=interest;
    }
    public  double getInterest(int years){
return BankAccount.interestRate*years*this.balance;
    }
    public void deposit(double amount){
        this.balance+=amount;
    }
    public void incrementID(){
        System.out.println("Account ID"+this.id+" created");
        IDcurrent++;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
