package tree;

/**
 * Created by kewang on 22/9/18.
 */
public class CheckIfBinaryTreeIsBalancedV2 {

    public int judgeIsBalanced(TreeNode root, boolean[] isBalanced) {
        // Write your solution here
        if (root == null) {
            return 0;
        }

        int leftHeight = judgeIsBalanced(root.left, isBalanced);
        int rightHeight = judgeIsBalanced(root.right, isBalanced);

        if(Math.abs(leftHeight - rightHeight) > 1){
            isBalanced[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        // Write your solution here
        if(root == null){
            return true;
        }
        boolean[] isBalanced = new boolean[1];
        isBalanced[0] = true;
        judgeIsBalanced(root, isBalanced);
        return isBalanced[0];
    }
}
