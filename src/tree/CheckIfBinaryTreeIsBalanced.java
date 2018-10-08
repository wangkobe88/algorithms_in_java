package tree;

/**
 * Created by kewang on 22/9/18.
 */
public class CheckIfBinaryTreeIsBalanced {

    public int findHeight(TreeNode root) {
        // Write your solution here
        if (root == null){
            return 0;
        }
        return Math.max(findHeight(root.left),findHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        // Write your solution here
        if(root == null){
            return true;
        }

        if(Math.abs(findHeight(root.left) - findHeight(root.right)) <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
}
