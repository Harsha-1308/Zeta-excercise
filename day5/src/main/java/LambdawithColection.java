import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdawithColection {
    public static void main(String[] args){
        showAccount();
    }
    static Predicate<Account> removeFunction = acc -> acc.getNumber()%2==0;

    private static void showAccount() {
        List<Account> accounts =  new ArrayList<>();
        for(int i=0;i<=10;i++){
            accounts.add(new SavingsAccount(i+1));
        }
        accounts.forEach(account -> System.out.println(account));
        System.out.println("After sorting-----");
        accounts.sort((acc1,acc2)-> acc2.getNumber()-acc1.getNumber());
        accounts.forEach(account -> System.out.print(""+account.getNumber()+","));
        System.out.println("");
        System.out.println("After removing-----");
        //accounts.removeIf(acc-> acc.getNumber()%2==0);
        accounts.removeIf(removeFunction);
        accounts.forEach(account -> System.out.print(""+account.getNumber()+","));
    }
}
