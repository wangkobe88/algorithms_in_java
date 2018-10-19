package dynamic_programming;

/**
 * Created by kewang on 15/10/18.
 */
public class RangeSumQuery {
    public int sumRange(int[] nums, int i, int j) {
        // Write your solution here
        if (nums == null || nums.length == 0 || i >= j || i < 0 || j < 0){
            return 0;
        }

        int[] cache = new int[nums.length];
        cache[0] = nums[0];
        for (int k = 1; k < nums.length; k++){
            cache[k] = cache[k - 1] + nums[k];
        }

        return cache[i] - cache[j] + nums[j];
    }

    public static void main(String[] args){
        RangeSumQuery jg = new RangeSumQuery();
        System.out.println( jg.sumRange( new int[] {-2, 0, 3, -5, 2, -1}, 0 , 2 ) );
        //jg.canJump(int[2, 3,1,1,4]);
    }
}
