package heap;
import java.util.*;
/**
 * Created by kewang on 10/11/18.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length || k <= 0) {
            //threw exception
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                if(i1 < i2) {
                    return -1;
                } else if (i1 > i2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        minHeap.offer(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(minHeap.size() >= k && nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            } else if(minHeap.size() < k){
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();

    }
}
