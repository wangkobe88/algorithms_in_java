package tree.base_operation;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kewang on 22/9/18.
 */
public class PostOrderTraversalOfBinaryTree {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        postOrder(root,nodeValues);
        return nodeValues;
    }

    private void postOrder(TreeNode root,List<Integer> nodeValues){
        if(root == null){
            return;
        }
        postOrder(root.left, nodeValues);
        postOrder(root.right, nodeValues);
        nodeValues.add(root.key);
    }
}
