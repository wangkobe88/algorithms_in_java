package tree;

/**
 * Created by kewang on 26/10/18.
 */
public class MaximumPathSumBinaryTreeII {
    public int maxPathSum(TreeNode root, int[] maxValue){
        if(root == null) {
            return 0;
        }
        int rightMax = maxPathSum(root.right, maxValue);
        int leftMax = maxPathSum(root.left, maxValue);

        rightMax = rightMax > 0 ? rightMax : 0;
        leftMax = leftMax > 0 ? leftMax : 0;

        maxValue[0] = Math.max(maxValue[0], root.key + rightMax + leftMax);
        return root.key + Math.max(rightMax, leftMax);
    }

    public int maxPathSum(TreeNode root) {
        // Write your solution here
        if(root == null) {
            return 0;
        }
        int[] maxValue = new int[1];
        maxValue[0]= Integer.MIN_VALUE;
        maxPathSum(root, maxValue);
        return maxValue[0];
    }
}
