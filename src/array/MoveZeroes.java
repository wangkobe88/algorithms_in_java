package array;

/**
 * Created by kewang on 8/11/18.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != 0) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        while(slow < nums.length){
            nums[slow++] = 0;
        }
    }
}
