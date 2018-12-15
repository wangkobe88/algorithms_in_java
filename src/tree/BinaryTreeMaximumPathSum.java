package tree;

/**
 * Created by kewang on 10/11/18.
 */
/*
* helper function 如果跟原函数同名，不要调用错。
* 树的迭代往往需要helper function，因为需要在树中迭代找到极值。
* */
public class BinaryTreeMaximumPathSum {
    /**
     * Definition for a binary tree node.
     * */
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public int maxPathSum(TreeNode root, int[] maxSum) {
        if(root == null) {
            return 0;
        }
        int leftMaxSum = maxPathSum(root.left, maxSum);
        int rightMaxSum = maxPathSum(root.right, maxSum);
        leftMaxSum = leftMaxSum > 0 ? leftMaxSum : 0;
        rightMaxSum = rightMaxSum > 0 ? rightMaxSum : 0;
        maxSum[0] = Math.max(leftMaxSum + root.val + rightMaxSum, maxSum[0]);
        return root.val + Math.max(leftMaxSum,rightMaxSum);
    }

    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxPathSum(root, maxSum);
        return maxSum[0];
    }
}
