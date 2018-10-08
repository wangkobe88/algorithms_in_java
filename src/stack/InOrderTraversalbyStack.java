package stack;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Deque;

/**
 * Created by kewang on 5/10/18.
 */
public class InOrderTraversalbyStack {
    public List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode cur = st.peek();
            if(cur.left != null){
                st.push(cur.left);
            }else{
                results.add(cur.key);
                st.pop();
                st.push(cur.right);
            }
        }
        return results;
    }

    public List<Integer> inOrderV2(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode cur = root;
        while(!st.isEmpty() || cur != null){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            }else{
                cur = st.pop();
                results.add(cur.key);
                cur = cur.right;
            }
        }
        return results;
    }
}
