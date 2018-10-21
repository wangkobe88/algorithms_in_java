package tree.lowest_common_ancestor;
import tree.TreeNode;
/**
 * Created by kewang on 21/10/18.
 */
public class LowestCommonAncestorIII {
    private TreeNode findLowestCommonAncestor(TreeNode root,
                                              TreeNode one, TreeNode two) {
        if(root == null || root == one || root == two){
            return root;
        }

        TreeNode right = findLowestCommonAncestor(root.right,one,two);
        TreeNode left = findLowestCommonAncestor(root.left,one,two);
        if (right != null && left != null){
            return root;
        } else if (right == null){
            return left;
        } else {
            return right;
        }
    }

    private boolean findNode(TreeNode root, TreeNode node){
        if(root == null) {
            return false;
        }else if(root == node) {
            return true;
        }

        return findNode(root.right,node) || findNode(root.left,node);
    }

    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {
        // write your solution here
        if(root == null || one == null || two == null) {
            return null;
        }

        TreeNode result = findLowestCommonAncestor(root, one, two);
        if (result == one && findNode(one, two)) {
            return one;
        } else if (result == two && findNode(two, one)) {
            return two;
        } else if (result == one || result == two) {
            return null;
        } else {
            return result;
        }
    }
}
