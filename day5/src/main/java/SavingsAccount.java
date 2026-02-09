
import java.util.logging.Logger;

public class SavingsAccount extends Account {
//    final ACCOUNT_TYPE acc_type = ACCOUNT_TYPE.SAVINGS;

    public SavingsAccount (int number){
        super(number, ACCOUNT_TYPE.SAVINGS);
    }

    Logger logger = Logger.getLogger("Savings Account");
    @Override
    protected float deposit(float number) {
        validateAmount(number);
        float balance = super.getBalance();
        float update_balance = balance + number;
        super.setBalance(update_balance);

        float DEPOSIT_THRESHOLD = 2000;
        if (number > DEPOSIT_THRESHOLD){
            logger.warning("Deposit Threshold Exceeded");
        }

        return super.getBalance();

    }


    @Override
    protected float withdraw(float number) {
        validateAmount(number);
        float balance = super.getBalance();
        if (balance < number){
            throw new InsufficientBalanceException("Insufficient funds, Current Balance: " + balance);
            //return 0;
        }

        float update_balance = balance - number;
        super.setBalance(update_balance);

        float WITHDRAW_THRESHOLD = 2000;
        if (number > WITHDRAW_THRESHOLD){
            logger.warning("withdraw threshold reached");
        }

        return super.getBalance();
    }
}
