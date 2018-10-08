package tree.base_operation;

import tree.TreeNode;

/**
 * Created by kewang on 2/10/18.
 */
public class SearchInBinarySearchTree {

    public TreeNode searchLaiCode(TreeNode root, int key) {
        // Write your solution here

        // Write your solution here
        if ( root == null ){
            return root;
        }
        if (root.key == key) {
            return root;
        } else if ( root.key > key ) {
            return searchLaiCode(root.left, key);
        } else {
            return searchLaiCode(root.right, key);
        }
    }


    public boolean search(TreeNode root, int target) {
        // Write your solution here
        if ( root == null ){
            return false;
        }
        if (root.key == target) {
            return true;
        } else if ( root.key > target ) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public void insert(TreeNode root, int target) {
        // Write your solution here
        if ( root == null ){
            root =  new TreeNode(target);
        }
        if ( root.key > target ) {
            if ( root.left != null) {
                insert(root.left, target);
            } else {
                root.left = new TreeNode(target);
            }
        } else if(root.key < target) {
            if ( root.right != null ) {
                insert(root.right, target);
            } else {
                root.right = new TreeNode(target);
            }
        }
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
