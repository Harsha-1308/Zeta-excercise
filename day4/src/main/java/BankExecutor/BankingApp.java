package BankExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankingApp {
    public static void main(String[] args){
        Scanner S= new Scanner(System.in);

        HashMap<Integer,BankAccount> bankList= new HashMap<>();
        bankList.put(108,new BankAccount(108,10000));
        bankList.put(150,new BankAccount(150,10800));
        BankAccount account;
        ExecutorService executor = Executors.newFixedThreadPool(3);
        while(true){
            System.out.println("Enter the bank account number");
            int accountNumber = S.nextInt();
            if (bankList.containsKey(accountNumber)){
                account=bankList.get(accountNumber);
                break;
            }
            else if(accountNumber<0){
                throw new EntryAmountException();
            }
            else{
                System.out.println("Account Number is not existing. Want to create a new account? type 1");
                int newacc = S.nextInt();
                if (newacc ==1 ){
                    System.out.println("Enter initial bank balance: $");
                    int initialbalance=S.nextInt();
                    account= new BankAccount(110,initialbalance);
                    bankList.put(110,account);
                    break;
                }

            }
            }



        while(true){
            System.out.println("\n======== MultiThreading BANKING SYSTEM (EXECUTOR SERVICE) =============");
            System.out.println(" 1. Check Balance");
            System.out.println(" 2. Deposit Money");
            System.out.println(" 3. Withdraw Money");
            System.out.println(" 4. Simulate Parallel Withdraws");
            System.out.println(" 5. Simulate one withdraw one deposit");
            System.out.println(" 6. Get a loan");
            System.out.println(" 7. Give bank details");
            System.out.println(" Enter your  choice");
            int choice = S.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Current Balance: $ " +account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit :$ ");
                    int dep = S.nextInt();
                    executor.execute(new DepositTask(account, dep));
                    break;
                case 3:
                    System.out.println("Enter the amount to withdraw :$ ");
                    int wd = S.nextInt();
                    executor.execute(new WithdrawTask(account,wd));
                    break;
                case 4:
                    System.out.println(" Simulating two parallel withdraws of $ ");
                    executor.execute(new WithdrawTask(account, account.getBalance()/2));
                    executor.execute(new WithdrawTask(account, account.getBalance()/2));
                    break;
                case 5:
                    System.out.println(" Simulating parallel withdraw and deposit of $ ");
                    System.out.println("Enter the amount to withdraw :$ ");
                    int wd1 = S.nextInt();
                    System.out.print("Enter amount to deposit :$ ");
                    int dep1 = S.nextInt();
                    executor.execute(new WithdrawTask(account,wd1));
                    executor.execute(new DepositTask(account,dep1));
                    break;
                case 6:
                    System.out.println("Welcome");
                    if(!account.getLoanStatus() && account.getBalance()>=100000){

                        System.out.println("Enter the principal");
                        float principal = S.nextFloat();
                        System.out.println("Enter tenure");
                        int tenure = S.nextInt();
                        account.getLoan(tenure,principal);
                        System.out.println("Loan Account created successfully!!!!");
                    }
                    else if (account.getBalance()<100000){
                        System.out.println("Loan Account not possible: Amount is less than 100000");
                    }
                    else{
                        System.out.println("Loan account already exists");
                    }
                    break;
                case 7:
                    account.getDetails();
                    break;
                case 8:
                    System.out.println("Shutting down banking system ...");
                    executor.shutdown();
                    S.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Try again. ");


            }
        }

    }
}
