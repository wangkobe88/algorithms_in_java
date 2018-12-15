package math;

/**
 * Created by kewang on 12/11/18.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int allSum = (nums.length * (nums.length + 1))/2;
        for(int i = 0; i < nums.length; i++) {
            allSum -= nums[i];
        }
        return allSum;
    }
}
