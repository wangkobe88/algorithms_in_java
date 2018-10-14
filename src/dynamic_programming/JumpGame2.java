package dynamic_programming;

/**
 * Created by kewang on 12/10/18.
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] results = new int[nums.length];
        results[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int minNextStep = results[i + 1];
            for (int j = 2; j <= nums[i] && (i + j) <= (nums.length - 1); j++) {
                minNextStep = Math.min(results[i + j], minNextStep);
            }
            results[i] = minNextStep + 1;
            System.out.println( results[i] );
        }
        return results[0];

    }

    public static void main(String[] args){
        JumpGame2 jg = new JumpGame2();
        int[] nums = { 2,3,1,1,4 };
        System.out.println( jg.jump(nums) );

        //jg.canJump(int[2, 3,1,1,4]);
    }
}
