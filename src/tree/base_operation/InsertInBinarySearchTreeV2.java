package tree.base_operation;

import tree.TreeNode;

/**
 * Created by kewang on 2/10/18.
 */
public class InsertInBinarySearchTreeV2 {

    public TreeNode insert(TreeNode root, int key) {
        // Write your solution here
        if ( root == null ){
            return  new TreeNode(key);
        }
        if ( root.key > key ) {
            if ( root.left != null) {
                insert(root.left, key);
            } else {
                root.left = new TreeNode(key);
            }
        } else if(root.key < key) {
            if ( root.right != null ) {
                insert(root.right, key);
            } else {
                root.right = new TreeNode(key);
            }
        }
        return root;
    }


    public TreeNode insertV2(TreeNode root, int target) {
        // Write your solution here
        if (root == null){
            return new TreeNode(target);
        }

        if (root.key == target){
            return root;
        } else if ( root.key > target ) {
            root.left = insertV2(root.left, target);
        } else {
            root.right = insertV2(root.right, target);
        }
        return root;
    }

}
