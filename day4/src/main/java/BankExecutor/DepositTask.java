package BankExecutor;

public class DepositTask implements Runnable{
    private final BankAccount account;
    private final int amount;
    public DepositTask(BankAccount account,int amount){
        this.account=account;
        this.amount=amount;

    }
    @Override
    public void run() {
        if (amount<=0){
            throw new EntryAmountException();
        }
        String thread=Thread.currentThread().getName();
        System.out.println(thread+"depositing $"+ amount);
        account.deposit(amount);
        System.out.println(thread+" completed deposit of $"+ amount);
    }
}
