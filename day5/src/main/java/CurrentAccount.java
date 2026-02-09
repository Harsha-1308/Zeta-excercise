
public class CurrentAccount extends Account{


    CurrentAccount(int number) {
        super(number, ACCOUNT_TYPE.CURRENT);
    }

    @Override
    protected float deposit(float number) {
        validateAmount(number);
        float balance = super.getBalance();
        float update_balance = balance + number;
        super.setBalance(update_balance);


        return super.getBalance();

    }

    protected static void validateAmount(float number) {
    }


    @Override
    protected float withdraw(float number) {
        validateAmount(number);
        float balance = super.getBalance();
        if (balance < number){
            throw new InsufficientBalanceException("Insufficient funds, Current Balance: " + balance); //String interpolation
            //return 0;
        }

        float update_balance = balance - number;
        super.setBalance(update_balance);


        return super.getBalance();
    }


}

