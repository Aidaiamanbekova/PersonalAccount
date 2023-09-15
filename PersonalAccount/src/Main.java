// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {    public static void main(String[] args) {
    PersonalAccount account = new PersonalAccount(12345, "Zarina`s eyes");
    account.deposit(1000);
    account.withdraw(300);
    account.deposit(200);
    System.out.println("Account Holder: " + account.getAccountHolder());
    System.out.println("Account Number: " + account.getAccountNumber());
    System.out.println("Balance: $" + account.getBalance());
    System.out.println("\nTransaction History:");
    account.printHistory();
}}