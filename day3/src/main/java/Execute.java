import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker2 implements Runnable{
    @Override
    public void run() {
        System.out.println("worker");
    }
}
public class Execute {
    public static void main(String[] args){
        ExecutorService exe= Executors.newSingleThreadExecutor();
        exe.submit(new Worker2());
        exe.shutdown();
    }
}
