package tree;

/**
 * Created by kewang on 9/10/18.
 */
public class LowestCommonAncestorI {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        // Write your solution here.

        if(root == null || root == one || root == two) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);

        if ((left == one && right == two) || (left == two && right == one)) {
            return root;
        } else if ( left != null){
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}
