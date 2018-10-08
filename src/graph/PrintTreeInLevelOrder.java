package graph;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by kewang on 24/9/18.
 */
class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
        this.key = key;
    }
}
public class PrintTreeInLevelOrder {
    public List<Integer> bfs(TreeNode root) {
        // Write your solution here
        List results = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();
                results.add(node.key);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            count--;
        }
        return results;
    }
}
