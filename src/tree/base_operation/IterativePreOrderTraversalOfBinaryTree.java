package tree.base_operation;

import tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by kewang on 22/9/18.
 */


public class IterativePreOrderTraversalOfBinaryTree {
    public List<Integer> preOrder(TreeNode root) {
        // Write your solution here
        if(root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode>  st = new Stack<TreeNode>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode treeNode = st.pop();
            results.add(treeNode.key);
            if (treeNode.right != null){
                st.push(treeNode.right);
            }
            if(treeNode.left != null){
                st.push(treeNode.left);
            }
        }
        return results;
    }

}
