package BankExecutor;

class WithdrawTask implements Runnable{
    private final BankAccount account;
    private final int amount;

    public WithdrawTask(BankAccount account,int amount) {
        this.account = account;
        this.amount=amount;
    }
    @Override
    public void run(){
        String thread=Thread.currentThread().getName();
        System.out.println("Current Request: "+amount);
        if (amount<=0){
            throw new EntryAmountException();
        }
        System.out.println(thread+ "attempting gto withdraw $" + amount);
        boolean success =account.withdarw(amount);
        if (success){
            System.out.println(thread+"successfully withdraw $" + amount);
        }
        else {
            System.out.println(thread+"FAILED TO WITHDRAW $"+ amount+"(Insufficient balance)");
        }
    }
}
