public class BankAccount implements AccountFeatures {
  /* BankAccount object variables */
  private final String accountHolderName;
  private final int accountNumber;
  private double balance;

  /* Constructor method */
  public BankAccount(String accountHolderName, int accountNumber, double balance) {
    this.accountHolderName = accountHolderName;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  /* Getters and setters because of encapsulation */
  public String getAccountHolderName() {
    return this.accountHolderName;
  }

  public int getAccountNumber() {
    return this.accountNumber;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public void withdraw(double amount) {
    if (this.balance >= amount) {
      this.balance -= amount;
    } else {
      System.out.println("Invalid withdraw amount.");
    }
  }

  @Override
  public void deposit(double amount) {
    if (amount > 0) {
      this.balance += amount;
    } else {
      System.out.println("Invalid deposit amount.");
    }
  }

  @Override
  public void transfer(BankAccount toAccount, double amount) {
    if (amount > 0 && amount <= this.balance) {
      this.withdraw(amount);
      toAccount.deposit(amount);
      System.out.printf("%s transferred %.2f to %s.\n", this.accountHolderName, amount, toAccount.getAccountHolderName());
    }
  }

  @Override
  public String toString() {
    return String.format("Account holder: %s\nAccount number: %d\nCurrent balance: $%.2f\n", this.accountHolderName, this.accountNumber, this.balance);
  }
}
