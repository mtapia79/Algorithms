import edu.princeton.cs.algs4.StdIn;  
import java.util.Date;
  
public class Permutation {  
    public static void main(String[] args) {  
        RandomizedQueue rq = new RandomizedQueue();  
        int k = Integer.parseInt(args[0]);  
        while (!StdIn.isEmpty()) {  
            rq.enqueue(StdIn.readString());  
            // System.out.println(StdIn.readString());  
        }  
        while (k > 0) {  
            System.out.println(rq.dequeue());  
            k--;  
        }  
    }  
}  