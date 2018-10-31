package dfs;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by kewang on 29/10/18.
 */
/*
错误：
* 当结果是List<List> 的时候，但是暂时结果是数组，需要遍历数组进行数据拷贝;
* SWAP-SWAP方法是两次SWAP;
* */
public class Permutations {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void permute(int level, int[] nums, List<List<Integer>> results) {
        if(level == nums.length) {
            List<Integer> resultList = new ArrayList<Integer>();
            for (int i : nums) {
                resultList.add(i);
            }
            results.add(resultList);
            return;
        }

        for(int i = level; i < nums.length; i++){
            swap(nums, level, i);
            permute(level + 1, nums, results);
            swap(nums, level, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null) {
            return results;
        }
        permute(0, nums, results);
        return results;
    }
}
