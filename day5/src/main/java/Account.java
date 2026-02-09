
public abstract class Account {

    private float balance;
    private final int number;
    private final ACCOUNT_TYPE  type;
    Address address; // Has-A relationship composition

    Account(int number, ACCOUNT_TYPE type){
        this.number = number;
        this.type = type;
    }

    public Account(int number, ACCOUNT_TYPE accountType, int number1, ACCOUNT_TYPE type) {
        this.number = number1;
        this.type = type;
    }



    protected static void validateAmount(float number) {
        if (number <= 0){
            throw new IllegalArgumentException("Amount cannot be less than or equal to 0");
        }
    }


    protected abstract float deposit(float number);

    protected abstract  float withdraw(float number);

    public int getNumber(){
        return this.number;
    }
    public ACCOUNT_TYPE getType(){
        return this.type;
    }

    public float getBalance(){
        return this.balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }




}
