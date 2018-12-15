package array;

/**
 * Created by kewang on 8/11/18.
 */
/*需要对两个挡板的物理意义理解清楚。*/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            //threw exception
        }

        int slow = 0;
        int fast = 1;
        while(fast < nums.length) {
            if(nums[slow] == nums[fast]) {
                fast++;
            } else {
                nums[++slow] = nums[fast++];
            }
        }
        return slow + 1;
    }
}
