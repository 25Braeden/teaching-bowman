public class Main {
    public static void main(String[] args) {
        // Create a BankAccount
        BankAccount account = new BankAccount("John Doe", 12345, 500.0);
        account.deposit(200);
        account.withdraw(100);
        System.out.println(account);

        // Create a SavingsAccount
        SavingsAccount savings = new SavingsAccount("Jane Smith", 67890, 1000.0, 5.0);
        savings.applyInterest();
        System.out.println(savings);

        // Create a CheckingAccount
        CheckingAccount checking = new CheckingAccount("Alice Johnson", 11223, 300.0, 200.0);
        checking.withdraw(400);
        System.out.println(checking);

        // Test Transfer
        System.out.println("\nTesting Transfer:");
        account.transfer(savings, 200);
        System.out.println(account);
        System.out.println(savings);
    }
}
