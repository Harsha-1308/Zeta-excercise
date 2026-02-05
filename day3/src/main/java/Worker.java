public class Worker extends Thread{
    Worker(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<10;++i){
            System.out.println("thread"+Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
