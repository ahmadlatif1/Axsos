package Java_OOP.BankAccount;

import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private long accountNumber;

    private static int accounts;
    private static double totalMoney;


    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        accounts++;
        accountNumber=makeAccountNumber();
    }

    public BankAccount() {

        accounts++;
        accountNumber=makeAccountNumber();
    }

    public void depositChecking(double amount){
        this.checkingBalance+=amount;
        totalMoney+=amount;

    }

    public void depositSavings(double amount){
        this.savingsBalance+=amount;
        totalMoney+=amount;
    }

    public Boolean withdrawChecking(double amount){

        if (this.getCheckingBalance()-amount>0){
            this.setCheckingBalance(getCheckingBalance()-amount);
            totalMoney-=amount;
            return true;
        }

        return false;

    }

    public Boolean withdrawSavings(double amount){

        if (this.getSavingsBalance()-amount>0){
            this.setSavingsBalance(getSavingsBalance()-amount);
            totalMoney-=amount;
            return true;
        }

        return false;
    }


    private long makeAccountNumber(){
        Random rand =new Random();
        rand.setSeed(accounts);
        return rand.nextLong(1000000000L,10000000000L);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public static int getAccounts() {
        return accounts;
    }

    public static void setAccounts(int accounts) {
        BankAccount.accounts = accounts;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }

    public static void setTotalMoney(double totalMoney) {
        BankAccount.totalMoney = totalMoney;
    }
}
