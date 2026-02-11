package BankExecutor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Transactions implements Runnable{
    private final BankAccount account1;
    private final BankAccount account2;
    private final int amount;
    private final int accNumber1;
    private final int accNumber2;


    public Transactions(BankAccount account1, int accNumber1,BankAccount account2, int accNumber2, int amount){
        this.account1=account1;
        this.account2=account2;
        this.amount=amount;
        this.accNumber1=accNumber1;
        this.accNumber2=accNumber2;

    }
    @Override
    public void run(){
        if(accNumber1==accNumber2){
        System.out.println("Transaction cant happen for same account.");

        }
        else if (amount<=0){
            throw new EntryAmountException();
        }
        else if (account1.getBalance()>=amount){
            System.out.println("crediting $"+ amount+" to "+accNumber2);
            WithdrawTask w1 = new WithdrawTask(account1,amount);
            DepositTask d1= new DepositTask(account2,amount);
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            Future condition1=executorService.submit(w1);
            Future condition2=executorService.submit(d1);

            try {
                boolean c1= (boolean) condition1.get();
                boolean c2= (boolean) condition2.get();
                if (c1==true && c2==true){
                    account1.addTransactionList(accNumber2,amount,"Debit");
                    account2.addTransactionList(accNumber1,amount,"Credit");
                    System.out.println("Transaction successful");
                    System.out.println(" completed credit of $"+ amount +"to :"+accNumber2);
                }
                else if (c1==false){
                    executorService.submit(new WithdrawTask(account2,amount));
                    System.out.println("Withdraw failed from account: "+accNumber1);
                    System.out.println("System Roll-back");
                }

                else{
                    System.out.println("Transaction failed");
                }
            } catch (Exception e) {
                System.out.println("Transaction failed");
            }
            executorService.shutdown();



        }

    }
}
