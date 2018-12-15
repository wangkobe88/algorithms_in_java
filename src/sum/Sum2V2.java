package sum;
import java.util.*;
/**
 * Created by kewang on 15/11/18.
 */
public class Sum2V2 {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int[] results = new int[2];
        Map<Integer,Integer> valuePosMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(valuePosMap.containsKey(target - nums[i])) {
                results[0] = valuePosMap.get(target - nums[i]);
                results[1] = i;
                return results;
            }
            valuePosMap.put(nums[i],i);
        }
        return results;
    }
}
