package tree.base_operation;
import tree.TreeNode;
/**
 * Created by kewang on 5/10/18.
 */
public class DeleteInBinarySearchTree {

    private TreeNode deleteNode(TreeNode root, int key) {
        if (root.left == null && root.right == null){
            return null;
        } else if (root.left == null){
            return root.right;
        } else if(root.right == null){
            return root.left;
        } else if(root.right.left == null){
            root.right.left = root.left;
            return root.right;
        }else{
            TreeNode smallest = deleteSmallest(root.right);
            smallest.left = root.left;
            smallest.right = root.right;
            return smallest;
        }
    }

    private TreeNode deleteSmallest(TreeNode root){
        TreeNode cur = root;
        TreeNode pre = root;
        while (cur.left != null){
            pre = cur;
            cur = cur.left;
        }
        //pre.left = null;
        pre.left = pre.left.right;
        return cur;
    }


    public TreeNode delete(TreeNode root, int key) {
        // Write your solution here
        if ( root == null ){
            return null;
        }
        if (root.key > key) {
            if ( root.left != null) {
                root.left = delete(root.left, key);
            }
        } else if(root.key < key) {
            if ( root.right != null ) {
                root.right = delete(root.right, key);
            }
        } else {
            root = deleteNode(root, key);
        }
        return root;
    }
}
