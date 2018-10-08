package graph;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Created by kewang on 24/9/18.
 */
public class CheckIfBinaryTreeIsComplete {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here
        if (root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean isEmpty = false;
        while(!q.isEmpty()){
            TreeNode treeNode = q.poll();
            if (treeNode.key == -1){
                isEmpty = true;
            }
            if(treeNode.key != -1 && isEmpty == true){
                return false;
            }
            if (!(treeNode.left == null)) {
                q.offer(treeNode.left);
            } else if(isEmpty == false) {
                q.offer(new TreeNode(-1));
            }
            if (!(treeNode.right == null)) {
                q.offer(treeNode.right);
            } else if(isEmpty == false) {
                q.offer(new TreeNode(-1));
            }
        }
        return true;

    }
}
