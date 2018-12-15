package dfs;

/**
 * Created by kewang on 13/11/18.
 */
public class PartitionEqualSubsetSum {
    private boolean partitionDFS(int[] nums, int level, int currentSum, int totalSum) {
        if(totalSum == currentSum * 2) {
            return true;
        }

        if(currentSum*2 > totalSum || nums.length == level) {
            return false;
        }

        return partitionDFS(nums, level + 1, currentSum + nums[level], totalSum) || partitionDFS(nums, level + 1, currentSum, totalSum);
    }

    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        return partitionDFS(nums, 0, 0, totalSum);
    }
}
