package sum;
import java.util.*;
/**
 * Created by kewang on 8/11/18.
 */
public class Sum3V2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        if(nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int smallIndex = i + 1;
            int bigIndex = nums.length - 1;
            int remainSum = 0 - nums[i];
            while(smallIndex < bigIndex) {
                if( nums[smallIndex] + nums[bigIndex] == remainSum) {
                    if(smallIndex != i && bigIndex != i ) {
                        List<Integer> result = new ArrayList<Integer>();
                        result.add(nums[i]);
                        result.add(nums[smallIndex]);
                        result.add(nums[bigIndex]);
                        Collections.sort(result);
                        if(!resultSet.contains(result)) {
                            results.add(result);
                            resultSet.add(result);
                        }
                    }
                    smallIndex ++;
                    bigIndex --;
                } else if(nums[smallIndex] + nums[bigIndex] > remainSum){
                    bigIndex --;
                } else {
                    smallIndex ++;
                }
            }
        }
        return results;
    }
}
