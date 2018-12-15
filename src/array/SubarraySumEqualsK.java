package array;
import java.util.*;

/**
 * Created by kewang on 9/11/18.
 */
/*预先计算 以及HashMap结合，处理子数组和的问题。
* */
public class SubarraySumEqualsK {
    public int subarraySumSlow(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer,Integer> previousSum = new HashMap<Integer,Integer>();
        previousSum.put(0, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(previousSum.containsKey(sum - k)) {
                count += previousSum.get(sum - k);
            }
            if(previousSum.containsKey(sum)){
                previousSum.put(sum,previousSum.get(sum) + 1);
            } else {
                previousSum.put(sum,1);
            }
        }
        return count;
    }
}
