package tree.lowest_common_ancestor;

import tree.TreeNode;

/**
 * Created by kewang on 9/10/18.
 */

// leetcode 236
//
public class LowestCommonAncestorIRound2 {
    private TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        } else if (root == p || root == q) {
            return root;
        }

        TreeNode left = findLowestCommonAncestor(root.left, p, q);
        TreeNode right = findLowestCommonAncestor(root.right, p, q);

        if((left == p && right == q) || (left == q && right == p)) {
            return root;
        } else if(left != null) {
            return left;
        } else if(right != null){
            return right;
        } else {
            return null;
        }

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || p == null || q == null) {
            //threw exception
        }
        return findLowestCommonAncestor(root, p, q);
    }
}
