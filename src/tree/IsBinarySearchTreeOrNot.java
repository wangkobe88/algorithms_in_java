package tree;

/**
 * Created by kewang on 22/9/18.
 */
public class IsBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
        // Write your solution here
        Integer rangeMin = Integer.MIN_VALUE;
        Integer rangeMax = Integer.MAX_VALUE;
        return isBST(root, rangeMin, rangeMax);
    }
    boolean isBST(TreeNode root, Integer rangeMin, Integer rangeMax){
        if (root == null){
            return true;
        }

        if (root.key > rangeMin && root.key < rangeMax){
            return isBST(root.left, rangeMin, root.key) && isBST(root.right, root.key, rangeMax);
        } else {
            return false;
        }
    }
}
