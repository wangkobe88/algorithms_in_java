package tree.binary_search_tree;
import tree.TreeNode;

/**
 * Created by kewang on 24/10/18.
 */
public class ClosestNumberInBinarySearchTree {

    public int closest(TreeNode root, int target) {
        // Write your solution here
        if( root == null ){
            return -1;
        }

        TreeNode current = root;
        int closetValue = root.key;

        while( current != null ) {
            if( Math.abs(current.key - target) < Math.abs(closetValue - target) ) {
                closetValue = current.key;
            }

            if(current.key > target) {
                current = current.left;
            } else if (current.key < target) {
                current = current.right;
            } else {
                return current.key;
            }
        }

        return closetValue;

    }
}
