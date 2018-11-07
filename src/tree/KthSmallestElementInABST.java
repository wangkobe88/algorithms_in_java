package tree;
import java.util.*;
/**
 * Created by kewang on 7/11/18.
 */
public class KthSmallestElementInABST {
    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void inOrder(TreeNode root, int k, List<Integer> results) {
        if(results.size() == k) {
            return;
        }

        if(root == null) {
            return;
        }

        inOrder(root.left, k, results);
        results.add(root.val);
        inOrder(root.right, k, results);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <= 0) {
            //threw exception
        }

        List<Integer> results = new ArrayList<Integer>();
        inOrder(root, k, results);
        return results.get(k - 1);
    }
}
