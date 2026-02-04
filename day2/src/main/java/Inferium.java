
public class Inferium extends CreditCard implements ICreditCard{
    public Inferium(String customerName) {
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
