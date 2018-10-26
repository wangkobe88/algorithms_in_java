package tree;

/**
 * Created by kewang on 26/10/18.
 */
/*
* 错误：从头将结点信息保存的问题，往往不需要返回值。
* */

public class MaximumPathSumBinaryTreeIII {
    private void maxPathSum(TreeNode root, int[] maxSum, int currentMaxSum) {
        if (root == null) {
            return;
        }

        currentMaxSum = currentMaxSum > 0 ? currentMaxSum + root.key : root.key;
        maxSum[0] = Math.max(maxSum[0], currentMaxSum);
        maxPathSum(root.left, maxSum, currentMaxSum);
        maxPathSum(root.right, maxSum, currentMaxSum);
    }

    public int maxPathSum(TreeNode root) {
        // Write your solution here
        if(root == null) {
            //threw Exception
        }
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxPathSum(root, maxSum, 0);
        return maxSum[0];
    }
}
