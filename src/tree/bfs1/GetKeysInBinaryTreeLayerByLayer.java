package tree.bfs1;
import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/**
 * Created by kewang on 21/10/18.
 */
public class GetKeysInBinaryTreeLayerByLayer {

    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(root == null) {
            return results;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> result = new ArrayList<Integer>();
            while (count > 0) {
                TreeNode treeNode = queue.poll();
                result.add(treeNode.key);

                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }

                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
                count --;
            }
            results.add(result);
        }
        return results;
    }
}
