package tree.serialization;
import tree.TreeNode;
/**
 * Created by kewang on 26/10/18.
 */

/*
* 错误1；start不要跟0混淆，end不要跟数组最后一个元素混淆。
* 错误2：细节！
*
* */
public class ReconstructBinarySearchTreeWithPreOrderTraversal {
    private TreeNode reconstruct(int[] pre, int start, int end) {
        if(start > end) {
            return null;
        }

        TreeNode root = new TreeNode(pre[start]);
        int rightStart = end + 1;
        for(int i = start + 1; i <= end; i++){
            if(pre[i] > pre[start]){
                rightStart = i;
                break;
            }
        }

        root.left = reconstruct(pre, start + 1, rightStart - 1);
        root.right = reconstruct(pre, rightStart, end);
        return root;
    }
    public TreeNode reconstruct(int[] pre) {
        // Write your solution here
        if(pre == null) {
            return null;
        }

        return reconstruct(pre, 0, pre.length - 1);
    }

}
