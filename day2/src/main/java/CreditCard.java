

public abstract class CreditCard {
    private float dueAmount;
    private int number;
    private String name;
    public float getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(float dueAmount) {
        this.dueAmount = dueAmount;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }


    public CreditCard(String customerName) {
        this.name = customerName;
    }
}
