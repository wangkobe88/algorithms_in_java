package tree;

/**
 * Created by kewang on 26/10/18.
 */
/*
* 错误：找到全局最大最小值，当没有说明元素都是正数的情况下，必须设置初值为最大或者最小的INT
* */

public class MaximumPathSumBinaryTreeIIIV2 {
    private int maxPathSum(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int leftMaxSum = maxPathSum(root.left, maxSum);
        int rightMaxSum = maxPathSum(root.right, maxSum);
        int currentMaxSum = root.key + Math.max(0, Math.max(leftMaxSum,rightMaxSum));
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
