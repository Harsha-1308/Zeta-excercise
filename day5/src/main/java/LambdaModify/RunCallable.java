package LambdaModify;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        BankAccount account = new BankAccount(108,10);
        Future<Integer> future1 = executorService.submit(() -> {
            account.deposit(10);
            return account.getBalance();
        });

        Future<Integer> future2 = executorService.submit(() -> {
            account.deposit(10);
            return account.getBalance();
        });

        System.out.println(future1.get());
        System.out.println(future2.get());


    }
}
