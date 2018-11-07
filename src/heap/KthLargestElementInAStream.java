package heap;
import java.util.*;
/**
 * Created by kewang on 7/11/18.
 */
public class KthLargestElementInAStream {
    private PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    private int size;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.size = k;
        for(int i = 0; i < nums.length; i++){
            pq.offer( nums[i] );
            if(this.pq.size() > this.size) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(this.pq.size() > this.size) {
            pq.poll();
        }
        return pq.peek();
    }
}
