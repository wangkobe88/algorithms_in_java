package array;
import java.util.*;
/**
 * Created by kewang on 2/11/18.
 */
public class SldingWindowMaximum {
    class Element{
        int index;
        int value;
        Element(int index,int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if( nums == null || nums.length == 0 || nums.length < k) {
            return new int[]{};
        }

        Deque<Element> dq = new ArrayDeque<Element>();
        int right = 0;
        int[] result = new int[nums.length - k + 1];
        while(right < nums.length) {

            while( (!dq.isEmpty()) && nums[right] > dq.peekLast().value ){
                dq.pollLast();
            }

            dq.offerLast(new Element(right, nums[right]));

            if(dq.peekFirst().index <= (right - k)) {
                dq.pollFirst();
            }

            if(right >= (k - 1)){
                result[right - k + 1] = dq.peekFirst().value;
            }

            right++;
        }
        return result;
    }
}
