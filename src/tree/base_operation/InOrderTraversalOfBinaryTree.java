package tree.base_operation;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by kewang on 22/9/18.
 */
public class InOrderTraversalOfBinaryTree {
    public List<Integer> inOrder(TreeNode root) {
        // Write your solution here
        List<Integer> nodeValues = new ArrayList<Integer>();
        inOrder(root, nodeValues);
        return nodeValues;
    }

    private void inOrder(TreeNode root,List<Integer> nodeValues){
        if(root == null){
            return;
        }
        inOrder(root.left, nodeValues);
        nodeValues.add(root.key);
        inOrder(root.right, nodeValues);
    }
}
