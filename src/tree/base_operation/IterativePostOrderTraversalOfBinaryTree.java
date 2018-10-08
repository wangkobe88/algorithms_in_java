package tree.base_operation;

import java.util.Stack;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kewang on 22/9/18.
 */
public class IterativePostOrderTraversalOfBinaryTree {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        if (root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()){
            root = stack.peek();

            if (prev == null || root == prev.left || root == prev.right){
                if(root.left != null) {
                    stack.push(root.left);
                } else if(root.right != null){
                    stack.push(root.right);
                } else {
                    results.add(root.key);
                    stack.pop();
                }
            } else if (prev == root.left){
                if(root.right != null){
                    stack.push(root.right);
                } else {
                    results.add(root.key);
                    stack.pop();
                }
            } else if (prev == root.right){
                results.add(root.key);
                stack.pop();
            }
            prev = root;
        }

        return results;
    }

    public static void main(String[] args){
        IterativePostOrderTraversalOfBinaryTree it = new IterativePostOrderTraversalOfBinaryTree();
        it.postOrder(new TreeNode(5));
    }
}
