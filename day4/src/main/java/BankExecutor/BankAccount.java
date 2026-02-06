package BankExecutor;

public class BankAccount {
    private int balance;
    private boolean loanStatus;
    private int accountNumber;
    LoanAccount loan;
    public BankAccount(int accountNumber,int balance){
        this.balance=balance;
        this.loanStatus=false;
        this.accountNumber=accountNumber;
    }
    public synchronized int getBalance(){
        return balance;
    }
    public synchronized boolean withdarw(int amount){
        System.out.println(Thread.currentThread().getName()+"checking balance");
        if(balance>=amount){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
            balance-=amount;
            return true;
        }
        return false;

    }
    public synchronized void deposit(int amount){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {

        }
        balance+=amount;

    }

    public synchronized void getLoan( int tenure,float principal){
        if(!loanStatus){
           loanStatus=true;
           loan= new LoanAccount(tenure,principal);
        }
        else{
            System.out.println("Loan Account already created");
        }
    }

    public synchronized boolean getLoanStatus(){
        return loanStatus;
    }

    public synchronized void getDetails(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);
        System.out.println("Loan Status: "+ loanStatus);
        if (loanStatus){
            System.out.println("==== Loan Details ====");
            System.out.println("Principal: "+loan.getPrincipal());
            System.out.println("Tenure: "+loan.getTenure());
            System.out.println("IntrestRate: "+loan.getIntrestRate());
        }

    }

}
