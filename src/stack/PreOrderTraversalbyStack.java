package stack;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Deque;
/**
 * Created by kewang on 5/10/18.
 */

public class PreOrderTraversalbyStack {
    public List<Integer> preOrder(TreeNode root){
        if (root == null){
            return new ArrayList<Integer>();
        }

        List<Integer> results = new ArrayList<Integer>();

        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);

        while (st.size() > 0){
            TreeNode cur = st.pop();
            results.add(cur.key);
            if (cur.right != null){
                st.push(root.right);
            }
            if (cur.left != null) {
                st.push(root.left);
            }
        }
        return results;
    }

    public List<Integer> preOrderV2(TreeNode root){
        if(root == null){
            return new ArrayList<Integer>();
        }

        List<Integer> results = new ArrayList<Integer>();

        Deque<TreeNode> st = new LinkedList<TreeNode>();
        st.push(root);

        while(st.size() > 0){
            TreeNode cur = st.pop();
            results.add(cur.key);
            if(cur.right != null){
                st.push(root.right);
            }
            if(cur.left != null) {
                st.push(root.left);
            }
        }
        return results;
    }
}
