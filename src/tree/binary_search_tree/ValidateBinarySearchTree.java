package tree.binary_search_tree;

/**
 * Created by kewang on 6/11/18.
 */
/*
* Binary Search Tree的性质是左子树所有节点都小于跟节点，右子树所有节点都大于跟节点。
* 并且左右子树都是BST。
* 其中比较坑的地方时Integer.MIN_VALUE/Integer.MAX_VALUE会忽略跟节点就是这个值的情况。
* 所以必须用Long.MIN_VALUE/Long.MAX_VALUE
* */
public class ValidateBinarySearchTree {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }

        if( (!(root.val > min && root.val < max))  ) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

    }

    boolean isValidBST(TreeNode root) {
        if( root == null) {
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

}
