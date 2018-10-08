package tree.base_operation;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by kewang on 22/9/18.
 */


public class IterativeInOrderTraversalOfBinaryTree {
    public List<Integer> inOrder(TreeNode root) {
        // Write your solution here
        if(root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode>  st = new Stack<TreeNode>();
        TreeNode helper = root;
        while (!st.isEmpty() || helper != null) {
            if (helper != null){
                st.push(helper);
                helper = helper.left;
            } else {
                helper = st.pop();
                results.add(helper.key);
                helper = helper.right;
            }
        }

        return results;
    }

}
