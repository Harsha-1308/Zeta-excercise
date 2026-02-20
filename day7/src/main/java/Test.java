import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args){
        List<String> list = new Vector<>();
        new Thread(()->{
            list.add("D");
        }
        ).start();
        list.add("A");
        list.add("B");
        list.add("C");
        for(;;){
            if(list.contains("B")){
                list.remove("B");
            }
            System.out.println(list);
        }

    }

}
