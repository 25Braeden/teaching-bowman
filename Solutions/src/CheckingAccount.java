public class CheckingAccount extends BankAccount {
    private final double overdraftLimit;
    public CheckingAccount(String accountHolderName, int accountNumber, double balance, double overdraftLimit) {
        super(accountHolderName, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount >= getBalance() + this.overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.printf("Withdrew: %.2f, Remaining balance: %.2f\n", amount, getBalance());
        } else {
            System.out.printf("You are exceeding your overdraft limit of %.2f, the most you can" +
                    " withdraw is %.2f", this.overdraftLimit, getBalance() + this.overdraftLimit);
        }
    }
}