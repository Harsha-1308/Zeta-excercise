import java.util.function.BiFunction;
import java.util.function.Function;

class Util{
    static int sum(int x,int y){
        return x+y;}
     int square(int x){
        return x*x;
     }
}
public class MethodRefernce {
    public static void main(String[] args){
        Util util= new Util();
        Function<Integer,Integer> ref= util::square;
        BiFunction<Integer,Integer,Integer> ref2= Util::sum;
        System.out.println("Square:"+ ref.apply(2));
        System.out.println("Sum: "+ref2.apply(2,3));

    }


}
