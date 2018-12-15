package dfs;
import java.util.*;
/**
 * Created by kewang on 14/12/18.
 */
public class Subsets {
    private void subsetsHelper(int[] nums, int level, List<Integer> result, List<List<Integer>> results) {
        if(nums.length == level) {
            List<Integer> resultCopy = new ArrayList();
            resultCopy.addAll(result);
            results.add(resultCopy);
            return;
        }
        result.add(nums[level]);
        subsetsHelper(nums, level + 1, result, results);
        result.remove(result.size() - 1);

        subsetsHelper(nums, level + 1, result, results);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return results;
        }

        subsetsHelper(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
}
