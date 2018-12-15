package normal;

/**
 * Created by kewang on 11/12/18.
 */

public class NextPermutation {
    private void swap(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int breakPoint = 0;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                breakPoint = i + 1;
                break;
            }
        }

        swap(nums, breakPoint, nums.length - 1);

        if(breakPoint != 0) {
            for(int i = breakPoint; i <= nums.length - 1 ;i++) {
                if(nums[i] > nums[breakPoint - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[breakPoint - 1];
                    nums[breakPoint - 1] = temp;
                    //swap(nums, breakPoint - 1, i);
                    break;
                }
            }

        }
    }
}
