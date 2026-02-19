import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args){
        Map<MyKey,String> map= new HashMap<>();
        map.put(new MyKey(1),"value1");
        map.put(new MyKey(1),"value2");
        map.put(null,"value3");
        System.out.println(map);
        System.out.println(map.put(new MyKey(2),"value4"));
        map.forEach((key,value)-> System.out.println("KEY: "+key+" Value: "+value));
        map.remove(null);

    }
}
