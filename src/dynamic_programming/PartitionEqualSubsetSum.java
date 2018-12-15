package dynamic_programming;

/**
 * Created by kewang on 13/11/18.
 */
//Corner Case: 当数组中有一条数据已经比target大，也就是比数组的总和一半还大。
public class PartitionEqualSubsetSum {
    //Base Rule: M[i][A[i]] = true
    //Induction Rule : M[i][j] = M[i-1][j - A[i]] if i>0 && j - A[i] > 0
    private boolean partitionDP(int[] nums, int target) {
        boolean[][] results = new boolean[nums.length][target + 1];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > target) {
                return false;
            }
            results[i][nums[i]] = true;
            for(int j = 0; j <= target; j++){
                if(i > 0 && results[i-1][j]) {
                    results[i][j] = true;
                }
                if(i > 0 && (j - nums[i]) > 0 && results[i-1][j - nums[i]]) {
                    results[i][j] = true;
                }
            }
        }

        return results[nums.length-1][target];
    }

    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        if(totalSum%2 != 0) {
            return false;
        }
        int target = totalSum/2;
        return partitionDP(nums, target);
    }
}
