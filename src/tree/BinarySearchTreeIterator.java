package tree;
import java.util.*;
/**
 * Created by kewang on 12/11/18.
 */
public class BinarySearchTreeIterator {
    /**
     * Definition for binary tree
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private TreeNode current = null;
    private boolean tracked = false;
    private Stack<TreeNode> track = null;
    public BinarySearchTreeIterator(TreeNode root) {
        this.current = root;
        track = new Stack<TreeNode>();
        //track.push(this.current);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null;
    }

    /** @return the next smallest number */
    public int next() {
        while(tracked == false && this.current.left != null) {
            track.push(this.current);
            this.current = this.current.left;
        }
        int value = this.current.val;
        if(this.current.right != null) {
            tracked = false;
            this.current = current.right;
        } else if(!track.isEmpty()) {
            tracked = true;
            this.current = track.pop();
        } else {
            this.current = null;
        }
        return value;
    }
}
