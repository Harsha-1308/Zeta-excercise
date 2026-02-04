
public interface ICreditCard {
    boolean transaction(Account recipient,float amount);
    boolean withdrawCash(float amount);

}