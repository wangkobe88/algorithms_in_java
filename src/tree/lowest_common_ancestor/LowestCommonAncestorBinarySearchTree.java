package tree.lowest_common_ancestor;
import tree.TreeNode;
/**
 * Created by kewang on 21/10/18.
 */
public class LowestCommonAncestorBinarySearchTree {
    public TreeNode lca(TreeNode root, int p, int q) {
        // Write your solution here
        if(root == null) {
            return root;
        }

        if( root.key > p && root.key > q) {
            return lca(root.left, p, q);
        } else if ( root.key < p && root.key < q ){
            return lca(root.right, p, q);
        } else {
            return root;
        }
    }
}
