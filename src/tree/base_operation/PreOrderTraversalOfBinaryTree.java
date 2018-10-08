package tree.base_operation;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kewang on 22/9/18.
 */


public class PreOrderTraversalOfBinaryTree {
    public List<Integer> preOrder(TreeNode root) {
        // Write your solution here
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        preOrder(root,nodeValues);
        return nodeValues;
    }
    private void preOrder(TreeNode root,List<Integer> nodeValues){
        if(root == null){
            return;
        }
        nodeValues.add(root.key);
        preOrder(root.left, nodeValues);
        preOrder(root.right, nodeValues);
    }
}
