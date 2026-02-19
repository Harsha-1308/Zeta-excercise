class Counter{
    static int x=0;
    void increment(){
        System.out.println("inside="+x);
        synchronized (this){
            x++;
            for(;;);
        }

    }
    synchronized int getValue(){
        return x;
    }

}
class Worker1 extends Thread{
     private Counter counter;
     Worker1(Counter counter){
         this.counter=counter;
     }
    @Override
    public void run(){
        counter.increment();
    }
}
public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Worker1 c1= new Worker1(c);
        System.out.println("1="+c.getValue());
        c1.start();
        Worker1 c2 = new Worker1(c);
        System.out.println("2="+c.getValue());
        c2.start();
        //c2.join();
        System.out.println("3="+c.getValue());


    }
}
