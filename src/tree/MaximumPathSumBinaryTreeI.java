package tree;

/**
 * Created by kewang on 18/10/18.
 */
public class MaximumPathSumBinaryTreeI {
    private int maxPathSum = Integer.MIN_VALUE;

    private int maxPathSumSolve(TreeNode root){
        if(root.left == null && root.right == null){
            return root.key;
        } else if(root.left == null){
            return maxPathSumSolve(root.right) + root.key;
        } else if(root.right == null){
            return maxPathSumSolve(root.left) + root.key;
        }

        int maxValueRight = maxPathSumSolve(root.right);
        int maxValueLeft = maxPathSumSolve(root.left);
        int maxValue = Math.max(maxValueRight, maxValueLeft);
        this.maxPathSum = Math.max(maxValueRight + maxValueLeft + root.key,
                maxPathSum);
        return maxValue + root.key;
    }

    public int maxPathSum(TreeNode root) {
        // Write your solution here
        int maxPathSum = Integer.MIN_VALUE;
        if(root == null || root.left == null || root.right == null){
            return maxPathSum;
        }
        maxPathSumSolve(root);
        return this.maxPathSum;
    }
}
