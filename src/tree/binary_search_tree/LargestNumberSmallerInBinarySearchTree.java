package tree.binary_search_tree;
import tree.TreeNode;

/**
 * Created by kewang on 24/10/18.
 */

/*
错误1； 一旦使用Integer.MAX_VALUE 或者 Integer.MIN_VALUE 要特别小心越界，尤其是需要与其进行操作后进行值的比较；
*/

public class LargestNumberSmallerInBinarySearchTree {
    public int largestSmaller(TreeNode root, int target) {
        // Write your solution here
        if (root == null) {
            return Integer.MIN_VALUE; // threw Exception
        }

        TreeNode current = root;
        boolean isFind = false;
        int largestSmallerValue = 0;

        while (current != null) {
            if (current.key < target && ((isFind == false) || (target - current.key) < (target - largestSmallerValue))) {
                largestSmallerValue = current.key;
                isFind = true;
            }

            if (current.key >= target) {
                current = current.left;
            } else if (current.key < target) {
                current = current.right;
            }
        }

        if (isFind == true) {
            return largestSmallerValue;
        } else {
            return Integer.MIN_VALUE;
        }
    }
}
