# Banking System
> Assignment to get unnamed person that is maybe in my class up to speed cuz copilot cooked his brain.

## Setup
Before starting do this:
- Make new vscode codespace or start a new intellij project
> This is 100% easier in intellij
- Make two new files ```Main.java``` and ```AccountFeatures.java```
> If using intellij mark AccountFeatures as an interface </br>
> We will be making more files later, I'm just going to hope that I won't need to say when

Then add the following code to ```AccountFeatures.java```:
```java
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
```
> Yes i wrote those comments myself, its called good code
> 
Now we can start hopefully.


## Part 1
### Use encapsulation for everything
Write the ```BankAccount``` class, it should implement ```AccountFeatures```. The class should have three variables ```accountHolderName```, ```accountNumber```, and ```balance```. 
> If you want to be mr. fancy pants you can make accountHolderName and accountNumber ```final```, for this code though it dont really matter.
> 
Make a constructor for BankAccount that will initialize and set all 3 variables I just listed. </br>
Fun part! Write the following methods :)
- Getters for all variables
- A setter for balance
- All the abstract methods inside of ```AccountFeatures.java```
- > It's a good practice to have @Override ON TOP of the methods in ```AccountFeatures``` when writing inside ```BankAccount```
- > If stuck on transfer, either skip or ask for help. You need to do it after making all other class methods though


## Part 2
Create the ```SavingsAccount``` class. It should extend BankAccount and have a variable ```interestRate```. 
> If interestRate is an int, you're wrong. Make sure variables in BankAccount are also what they should be. You should have 1 String, 1 double, and 1 int inside of BankAccount.
> 
Hit jack </br>
Make the ```SavingsAccount``` constructor. It should have 4 paramaters.
> 3 of the 4 should just be the same as ```BankAccount``` constructor.
> 
> Remember that you need to use ```super()``` when constructing SavingsAccount, as subclasses need to make parent class when initialized. </br>

Write a method ```applyInterest``` to add interest to the balance, you can calculate the interest payment by doing: </br>```getBalance() * (this.interestRate / 100 )```

## Part 2.5
Create the ```CheckingAccount``` class. yada yada yada extend BankAccount, add ```overdraftLimit``` class variable, make class constructor, etc etc. </br>
Override the ```withdrawl()``` method and make a new one where it allows user to withdrawl balance + overdraftLimit, if overdrafted, set balance to negative reflecting how much they owe.
Go back and make transfer if you didnt do it earlier

## Test code
Assuming we both named everything the same (if not I'm blaming you cause i neva wrong) run this code and hopefully you see same output bbg 
> Spacing may vary. Hit jack again bcuz dating sim
> 
```java
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
```
#### Output
```
Account holder: John Doe
Account number: 12345
Current balance: $600.00

Interest applied. New balance is: 1050.00
Account holder: Jane Smith
Account number: 67890
Current balance: $1050.00

You are exceeding your overdraft limit of 200.00, the most you can withdraw is 500.00
Account holder: Alice Johnson
Account number: 11223
Current balance: $300.00


Testing Transfer:
John Doe transferred 200.00 to Jane Smith.
Account holder: John Doe
Account number: 12345
Current balance: $400.00

Account holder: Jane Smith
Account number: 67890
Current balance: $1250.00
```
