public class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountHolderName, int accountNumber, double balance, double interestRate) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void applyInterest() {
        double interest = getBalance() * (this.interestRate / 100);
        setBalance(getBalance() + interest);
        System.out.printf("Interest applied. New balance is: %.2f\n", getBalance());
    }
}