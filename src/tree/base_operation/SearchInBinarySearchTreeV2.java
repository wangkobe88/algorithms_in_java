package tree.base_operation;

import tree.TreeNode;

/**
 * Created by kewang on 2/10/18.
 */
public class SearchInBinarySearchTreeV2 {

    public TreeNode search(TreeNode root, int key) {
        // Write your solution here

        if ( root == null ){
            return root;
        }
        if (root.key == key) {
            return root;
        } else if ( root.key > key ) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public TreeNode searchIteration(TreeNode root, int key) {
        if ( root == null ){
            return root;
        }

        while(root != null){
            if(root.key == key){
                return root;
            } else if (root.key > key){
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }

}
