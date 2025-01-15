public interface AccountFeatures {
  /* Method to deposit money into account */
  void deposit(double amount);

  /* Method to withdraw money from the account */
  void withdraw(double amount);

  /* Method to transfer money between two BankAccount classes */
  void transfer(BankAccount toAccount, double amount);

  /* Method to get all account info, use @Override when implementing */
  String toString();
}
