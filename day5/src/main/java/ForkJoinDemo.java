import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 3;
    private ArrayList<Account> arr;
    private int start, end;

    SumTask(ArrayList<Account> arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (Account animal : arr) {
                sum += (int) animal.getBalance();
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);

            left.fork();          // start async
            int rightResult = right.compute();
            int leftResult = left.join();

            return leftResult + rightResult;
        }
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,10,4,5,5,7,7,7,7,7,7,7,7,89,9,};
        List<Account> accList= new ArrayList<Account>();
        for(int i=1;i<10;i++){
            Account S=new SavingsAccount(i);
            S.deposit(i*10);
            accList.add(S);
        }
        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new SumTask((ArrayList<Account>) accList, 0, accList.size()));

        System.out.println("Sum = " + result);
    }
}