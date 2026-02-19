import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        // Adding elements
        queue.add("Amit");
        queue.add("Neha");
        queue.add("Ravi");
        System.out.println("Initial Queue: " + queue);
        System.out.println("Head element: " + queue.peek());
        System.out.println("Removed: " + queue.poll());

        System.out.println("Queue after removal: " + queue);
    }
}