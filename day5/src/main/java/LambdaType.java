import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class LambdaType {
    static Predicate<Integer> predLambda= (x) -> {
        return x%2==0;
    };


    public static void main(String[] args){
        System.out.println("Proudct "+predLambda.test(3));
        Calculator cal =(x,y)-> x+y;
        System.out.println(cal.add(2,3));
        ArrayADD arrayadd = (x,y)->{
          for(int i=0;i<x.length;++i){
              x[i]=x[i]+y;
          }
          return x;
        };
        EvenArrayADD evenarrayadd = (x,y)->{
            for(int i=0;i<x.length;++i){
                if (x[i]%2==0){x[i]=x[i]+y;}
            }
            return x;
        };
        ThirdArrayADD thirdarrayadd = (x)->{
            int sum=0;
            for(int i=0;i<x.length;++i){
                if ((i+1)%3==0){sum+=x[i];}
            }
            return sum;
        };
        int[] x={1,2,3,4,5,6};int y=2;
        System.out.println("Original Array: "+Arrays.toString(x));
        System.out.println("Add 2 :"+Arrays.toString(arrayadd.arrayadd(x, y)));
        System.out.println("Add for even numbers: "+Arrays.toString(evenarrayadd.evenarrayadd(x,y)));
        System.out.println("Add for Every Third numbers: "+thirdarrayadd.thirdarrayadd(x));


    }
}
