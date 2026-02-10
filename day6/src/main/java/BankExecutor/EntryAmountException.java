package BankExecutor;

public class EntryAmountException extends RuntimeException{
    public EntryAmountException(){
        super("Number cant be less than zero");
    }
}
