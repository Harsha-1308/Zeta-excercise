package LambdaModify;

import java.util.function.Supplier;

public class LoanAccount {
    private final float intrestRate;
    private int tenure;
    private float principal;
    LoanAccount(int tenure,float principal){
        this.tenure=tenure;
        this.intrestRate = 15;
        this.principal=principal;
    }
    public Supplier<Integer> getTenureSupplier() {
        return () -> tenure;
    }


    public float  getPrincipal(){
        return principal;
    }
    public float  getIntrestRate(){
        return intrestRate;
    }


}
