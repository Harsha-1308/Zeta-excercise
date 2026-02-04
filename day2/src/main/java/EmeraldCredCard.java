
public class EmeraldCredCard extends CreditCard implements ICreditCard{
    public EmeraldCredCard(String customerName) {
        super(customerName);
    }

    @Override
    public boolean transaction(Account recipient, float amount) {
        return false;
    }

    @Override
    public boolean withdrawCash(float amount) {
        return false;
    }

}
