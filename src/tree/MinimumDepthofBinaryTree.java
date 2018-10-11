package tree;

/**
 * Created by kewang on 9/10/18.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        // Write your solution here
        if(root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min( minDepth(root.left), minDepth(root.right) ) + 1;
        }

    }
}
