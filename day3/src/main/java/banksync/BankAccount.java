package banksync;

public class BankAccount {
    private int balance;
    BankAccount(int balance){
        this.balance=balance;
    }

    synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" trying to withdraw "+amount);

        if(balance>=amount){
            System.out.println("Approved"+Thread.currentThread().getName());

            balance-=amount;
            System.out.println(Thread.currentThread().getName()+" Completed ");
        }
        else{
            System.out.println(Thread.currentThread().getName()+" no withdrawal");
        }
    }
    int getBalance(){
        return balance;
    }

}
