package dynamic_programming;

/**
 * Created by kewang on 11/10/18.
 * leetcode
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        boolean[] results = new boolean[nums.length];
        results[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            results[i] = false;
            for (int j = 1; j <= nums[i] && (i + j) <= (nums.length - 1) ; j++){
                if (results[i + j] == true){
                    results[i] = true;
                    continue;
                }
            }
        }
        return results[0];
    }

    public static void main(String[] args){
        JumpGame jg = new JumpGame();
        int[] nums = { 2,3,1,1,4 };
        System.out.println( jg.canJump(nums) );

        nums = new int[] {2,3,1,0,4 };
        System.out.println( jg.canJump(nums) );

        nums = new int[] {3,2,1,0,4 };
        System.out.println( jg.canJump(nums) );

        //jg.canJump(int[2, 3,1,1,4]);
    }
}
