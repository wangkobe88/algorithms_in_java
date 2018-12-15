package array;

/**
 * Created by kewang on 10/11/18.
 */
/*
* 从PreSum到PreProduct跟AfterProduct等，比较容易考虑到。
* */

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return null;
        }

        int[] productBefore = new int[nums.length];
        productBefore[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            productBefore[i] = productBefore[i-1] * nums[i-1];
        }

        int[] productAfter = new int[nums.length];
        productAfter[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            productAfter[i] = productAfter[i+1] * nums[i+1];
        }

        int[] results = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            results[i] = productBefore[i] * productAfter[i];
        }
        return results;
    }
}
