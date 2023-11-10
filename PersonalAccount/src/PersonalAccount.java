public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private Amount[] transactions;
    private int transactionCount;

    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new Amount[10]; // Assuming a maximum of 10 transactions for simplicity
        this.transactionCount = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions[transactionCount++] = new Amount(amount, "Deposit");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Cannot withdraw. Insufficient balance.");
        } else {
            balance -= amount;
            transactions[transactionCount++] = new Amount(amount, "Withdrawal");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for Account Number: " + accountNumber);
        for (int i = 0; i < transactionCount; i++) {
            Amount transaction = transactions[i];
            System.out.println(transaction.getTransactionType() + ": " + transaction.getAmount());
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public static void main(String[] args) {
        try {
            PersonalAccount account = new PersonalAccount(12345, "Aidai");

            account.deposit(1000.0);
            account.withdraw(1500.0); // This should throw an InsufficientBalanceException
            account.printTransactionHistory();
            System.out.println("Current Balance: " + account.getBalance());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
