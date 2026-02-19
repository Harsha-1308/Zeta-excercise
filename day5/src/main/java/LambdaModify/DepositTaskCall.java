package LambdaModify;

import java.util.concurrent.Callable;

public class DepositTaskCall implements Callable {
    private final BankAccount account;
    private final int amount;
    public  DepositTaskCall(BankAccount account, int amount){
        this.account=account;
        this.amount=amount;

    }
    @Override
    public Object call() throws Exception{
        if (amount<=0){
            throw new EntryAmountException();
        }
        double x = Math.random()*10000;
        int y = x>5000?1:3000;
        String thread=Thread.currentThread().getName();
        Thread.sleep(y);
        System.out.println(thread+"depositing $"+ amount);
        account.deposit(amount);
        System.out.println(thread+" completed deposit of $"+ amount);
        return account.getBalance();

    }
}
