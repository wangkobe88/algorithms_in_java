package dynamic_programming;

/**
 * Created by kewang on 13/12/18.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] results = new int[nums.length];
        int maxSum = nums[0];
        results[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(results[i - 1] < 0) {
                results[i] = nums[i];
            } else {
                results[i] = results[i - 1] + nums[i];
            }
            maxSum = Math.max(results[i], maxSum);
        }

        return maxSum;
    }
}
