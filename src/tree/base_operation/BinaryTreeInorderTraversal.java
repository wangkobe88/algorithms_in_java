package tree.base_operation;
import java.util.*;
/**
 * Created by kewang on 15/12/18.
 */
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        inorderTraversal(root, result);
        return result;
    }

    //没有解决方案输出的情况下写的中序遍历
    // 本质上是用迭代的方式，借用栈，模拟递归的过程
    // 左孩子节点入栈，到头后输出，有右孩子节点，则将当前节点换位右孩子，不然则出栈
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode current = root;
        boolean newStart = true;
        while(!stack.isEmpty()) {
            current = stack.pop();
            while(current.left != null && newStart) {
                stack.push(current);
                current = current.left;
            }
            result.add(current.val);
            if(current.right != null) {
                stack.push(current.right);
                newStart = true;
            } else {
                newStart = false;
            }
        }
        return result;
    }
    //逻辑简化版本
    // 通过helper跟栈一起控制停止条件
    // 通过当前节点是否为空进入不同逻辑
    public List<Integer> inorderTraversalV3(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }
}
