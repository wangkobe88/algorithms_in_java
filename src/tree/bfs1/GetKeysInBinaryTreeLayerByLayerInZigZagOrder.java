package tree.bfs1;
import java.util.ArrayDeque;
import java.util.List;
import tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
/**
 * Created by kewang on 21/10/18.
 */
public class GetKeysInBinaryTreeLayerByLayerInZigZagOrder {
    /*
           5
        3     8
     1     4    11
   2  3  5  7
  odd: get from queue tail, right to left, insert into queue top [3,8]
  even: get from queue top, left to right, insert into tail [1 , 4 , 11]
  cornor: null root
  */

    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here
        // Write your solution here
        List<Integer> result = new ArrayList<Integer>();
        if( root == null ) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offer(root);
        int level = 1;
        while (!deque.isEmpty()){
            int count = deque.size();
            while(count > 0){
                if(level % 2 == 1){
                    TreeNode treeNode = deque.pollLast();
                    result.add(treeNode.key);
                    if( treeNode.right != null ){
                        deque.addFirst(treeNode.right);
                    }

                    if( treeNode.left != null ) {
                        deque.addFirst(treeNode.left);
                    }
                } else {
                    TreeNode treeNode = deque.pollFirst();
                    result.add(treeNode.key);
                    if( treeNode.left != null ) {
                        deque.addLast(treeNode.left);
                    }

                    if( treeNode.right != null ) {
                        deque.addLast(treeNode.right);
                    }
                }
                count--;
            }
            level++;
        }
        return result;

    }
}
