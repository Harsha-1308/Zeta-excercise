package BankExecutor;

import java.util.concurrent.Callable;

class WithdrawTask implements Callable {
    private final BankAccount account;
    private final int amount;

    public WithdrawTask(BankAccount account,int amount) {
        this.account = account;
        this.amount=amount;
    }
    @Override
    public Object call(){
        String thread=Thread.currentThread().getName();
        System.out.println("Current Request: "+amount);
        if (amount<=0){
            throw new EntryAmountException();

        }
        System.out.println(thread+ "attempting gto withdraw $" + amount);
        boolean success =account.withdarw(amount);
        if (success){
            System.out.println(thread+"successfully withdraw $" + amount);
            return true;
        }
        else {
            System.out.println(thread+"FAILED TO WITHDRAW $"+ amount+"(Insufficient balance)");
            return false;
        }
    }
}
