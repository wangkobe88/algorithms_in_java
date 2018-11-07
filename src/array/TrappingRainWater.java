package array;

/**
 * Created by kewang on 1/11/18.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) {
            return 0;
        }

        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        int i = 0;
        int j = height.length - 1;
        int waterTotal = 0;
        while(i < j && i < height.length - 1 && j > 0) {
            if(leftMax <= rightMax){
                leftMax = Math.max(leftMax, height[++i]);
                waterTotal += leftMax - height[i];
            } else {
                rightMax = Math.max(rightMax, height[--j]);
                waterTotal += rightMax - height[j];
            }
        }
        return waterTotal;
    }
}
