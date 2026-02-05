package banksync;

public class BankDemo {
    public static void main(String[] args) throws Exception {
        BankAccount acc = new BankAccount(100);

        Thread t1 = new Thread(() -> acc.withdraw(80), "T1");
        Thread t2 = new Thread(() -> acc.withdraw(80), "T2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final balance = " + acc.getBalance());
    }

}
