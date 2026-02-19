public class Main {


    public static void main(String[] args){
        Worker work1=new Worker("Kaushal");
        work1.start();

         Worker work2= new Worker("Varun");
        work2.start();
        try {
            work2.wait(3000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
