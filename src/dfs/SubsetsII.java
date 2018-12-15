package dfs;
import java.util.*;
/**
 * Created by kewang on 13/11/18.
 */
public class SubsetsII {
    private void subsetDSP(int[] nums, int level, List<Integer> result, List<List<Integer>> results) {
        if(nums.length <= level) {
            List<Integer> resultCopy = new ArrayList<Integer>();
            for(Integer value : result) {
                resultCopy.add(value);
            }
            results.add(resultCopy);
            return;
        }
        result.add(nums[level]);
        subsetDSP(nums, level + 1, result, results);
        result.remove(result.size() - 1);

        while(level < (nums.length - 1) && nums[level + 1] == nums[level]){
            level++;
        }
        subsetDSP(nums, level + 1, result, results);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null) {
            return results;
        }

        Arrays.sort(nums);
        List<Integer> result = new ArrayList<Integer>();
        subsetDSP(nums, 0, result, results);
        return results;
    }
}
