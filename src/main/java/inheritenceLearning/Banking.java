package inheritenceLearning;

import java.util.Random;

public class  Banking {
    double interestRate;
    int accountNumber;


    double accountBalance;
    String accountType;
    String bankName;
    Banking() {
        System.out.println("Banking base class is called");
    }
    public Banking(double interestRate, int accountNumber, double accountBalance, String accountType, String bankName) {
        this.interestRate = interestRate;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.bankName = bankName;
    }
    public void accountDetails() {
        System.out.println("Account number is :"+accountNumber);
        System.out.println("Account balance is :"+accountBalance);
        System.out.println("Account type is :"+accountType);
        System.out.println("Account interest Rate is :"+interestRate);
        System.out.println("Bank name is :"+bankName);
    }

    public void deposit(double amount) {
        accountBalance = accountBalance + amount;
        System.out.println(amount+" Rs of amount credited successfully. current balance is :"+accountBalance);
    }

    public double getAccountBalance() {
        return  this.accountBalance;
    }

    public void withdraw(double amount) {
        accountBalance = accountBalance - amount;
        System.out.println(amount+" Rs of amount debited successfully. current balance is :"+accountBalance);
    }
    public double interestCalculator(int amount, float roi, int noOfMonths) {
        System.out.println("interestCalculator method in General bank");
        float interest = (amount*roi*noOfMonths) / 100;
        return interest;
    }

    public double calculateInterestBank(int noOfMonths) {
        float interest = (float) (((accountBalance*interestRate*noOfMonths) / 100) /12);
        return interest;
    }
    protected double calculateInterest(int noOfMonths, float interestRate) {
        System.out.println("calculateInterest method in SBI bank");
        float interest = (float) (((accountBalance*interestRate*noOfMonths) / 100)/12);
        return interest;
    }
    static double calculateInterestOnBalance(double balance, int noOfMonths, float interestRate) {
        System.out.println("calculateInterestOnBalance method in General bank..Current total balance is "+balance);
        float interest = (float) (((balance*interestRate*noOfMonths) / 100)/12);
        return interest;
    }

}

class SbiBank extends Banking {
    private int serviceTax;

    public void accountDetails(String bank) {
        System.out.println("Account number is :"+accountNumber);
        System.out.println("Account balance is :"+accountBalance);
        System.out.println("Account type is :"+accountType);
        System.out.println("Account interest Rate is :"+interestRate);
        System.out.println("  : object name is :"+bank);
    }
    public SbiBank(int accountNumber, double accountBalance) {
        super(9.0,accountNumber,accountBalance,"Savings","SBI");
        serviceTax = 2;
    }

    public double interestCalculator(int amount, float roi, int noOfMonths) {
        System.out.println("interestCalculator method in SBI bank");
        float interest = ((amount*roi*noOfMonths) / 100 /12);
        interest = interest + (amount * serviceTax)/100;
        return interest;
    }

    public double calculateInterest(int noOfMonths, float interestRate) {
        System.out.println("calculateInterest method in SBI bank");
        float interest = (float) (((accountBalance*interestRate*noOfMonths) / 100)/12);
        interest = (float) (interest + (accountBalance * serviceTax)/100);
        return interest;
    }
    public double calculateInterest(float interestRate) {
        System.out.println("calculateInterest method in SBI bank");
        float interest = (float) (((accountBalance*interestRate*12) / 100)/12);
        interest = (float) (interest + (accountBalance * serviceTax)/100);
        return interest;
    }
    static double calculateInterestOnBalance(double balance, int noOfMonths, float interestRate) {
        System.out.println("calculateInterestOnBalance method in SBI bank..Current total balance is "+balance);
        float interest = (float) (((balance*interestRate*noOfMonths) / 100)/12);
        return interest;
    }
    public static void main(String[] args) {
        int accountNumber = new Random().nextInt() * 10;
        SbiBank sbi1 = new SbiBank(accountNumber, 1000);
        sbi1.accountDetails();
        sbi1.deposit(2000);
        sbi1.accountDetails("SBI1");
        double interest = sbi1.calculateInterest(12, 24);
        System.out.println("Total interest for 10 months is @24%: "+interest);
        double interest1 = sbi1.calculateInterest(12.0f);
        System.out.println("Total interest for 12 months is @12%: "+interest1);
        sbi1.deposit(interest);
        double balance = sbi1.getAccountBalance();
        System.out.println("Total account balance is : "+balance);
        sbi1.withdraw(2000);
        balance = sbi1.getAccountBalance();
        System.out.println("Total account balance is : "+balance);
        sbi1.accountDetails();
        System.out.println("=================================================");
        Banking bank = new SbiBank(1, 2000);
        bank.accountDetails();
        bank.deposit(3000);
        interest = bank.calculateInterest(12,24.0f);
        System.out.println("Total interest for 10 months is @24%: "+interest);

        bank.deposit(interest);
        System.out.println("Total account balance is : "+bank.getAccountBalance());
        bank.withdraw(2000);
        System.out.println("Total account balance is : "+bank.getAccountBalance());
        System.out.println("Total interest is :"+bank.interestCalculator(1000, 24.0f, 12));
        System.out.println("Total interest on current balance is : "+SbiBank.calculateInterestOnBalance(bank.getAccountBalance(),12, 24.0f));
    }
}
