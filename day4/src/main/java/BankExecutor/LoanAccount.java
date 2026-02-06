package BankExecutor;

public class LoanAccount {
    private final float intrestRate;
    private int tenure;
    private float principal;
    LoanAccount(int tenure,float principal){
        this.tenure=tenure;
        this.intrestRate = 15;
        this.principal=principal;
    }
    public int getTenure(){
        return tenure;
    }
    public float  getPrincipal(){
        return principal;
    }
    public float  getIntrestRate(){
        return intrestRate;
    }

}
