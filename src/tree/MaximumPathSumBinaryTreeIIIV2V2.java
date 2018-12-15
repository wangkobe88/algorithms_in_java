package tree;

/**
 * Created by kewang on 26/10/18.
 */
/*
* 错误：找到全局最大最小值，当没有说明元素都是正数的情况下，必须设置初值为最大或者最小的INT
* */

public class MaximumPathSumBinaryTreeIIIV2V2 {
    private int maxPathSum(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxPathSum(root.left, maxSum);
        leftMax = leftMax > 0 ? leftMax : 0;
        int rightMax = maxPathSum(root.right, maxSum);
        rightMax = rightMax > 0 ? rightMax : 0;
        int currentMaxSum = Math.max(leftMax, rightMax) + root.key;
        maxSum[0] = Math.max(maxSum[0], currentMaxSum);
        return currentMaxSum;
    }

    public int maxPathSum(TreeNode root) {
        // Write your solution here
        if(root == null) {
            //threw Exception
        }
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxPathSum(root, maxSum);
        return maxSum[0];
    }
}
