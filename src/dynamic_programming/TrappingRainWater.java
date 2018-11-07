package dynamic_programming;

/**
 * Created by kewang on 1/11/18.
 */
public class TrappingRainWater {
    public int trapWater(int[] A) {
        // Write your solution here
        if(A == null || A.length == 0) {
            return 0;
        }

        int[] leftMax = new int[A.length];
        int[] rightMax = new int[A.length];

        leftMax[0] = A[0];
        for(int i = 1; i < A.length; i++){
            leftMax[i] = Math.max(leftMax[i - 1], A[i]);
        }

        rightMax[A.length - 1] = A[A.length - 1];
        for(int i = A.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], A[i]);
        }

        int totalTrapped = 0;
        for(int i = 0; i < A.length; i++) {
            int trapped = Math.min(leftMax[i] , rightMax[i]) - A[i];
            totalTrapped += trapped;
        }

        return totalTrapped;
    }
}
