package Java_OOP.BankAccount;

public class TestBank {
    public static void main(String[] args) {

        BankAccount account1=new BankAccount();
        BankAccount account2=new BankAccount();
        BankAccount account3=new BankAccount();

        account1.depositChecking(300);
        System.out.println("account1 checking deposit "+account1.getCheckingBalance());

        account2.depositSavings(400);
        System.out.println("account2 checking deposit "+account2.getSavingsBalance());

        account3.depositChecking(500);
        System.out.println("account3 checking deposit "+account3.getCheckingBalance());

        account1.withdrawChecking(200);
        System.out.println( account2.withdrawChecking(200));
        account2.withdrawSavings(300);
        account3.withdrawChecking(400);

        System.out.println("number of accounts: "+BankAccount.getAccounts());
        System.out.println(BankAccount.getTotalMoney());

        System.out.println(account1.getAccountNumber());
        System.out.println(account2.getAccountNumber());
        System.out.println(account3.getAccountNumber());



    }
}
