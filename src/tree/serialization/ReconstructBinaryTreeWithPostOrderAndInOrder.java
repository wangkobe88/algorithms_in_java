package tree.serialization;
import tree.TreeNode;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by kewang on 26/10/18.
 */

/*
* 错误1：对于边界条件，尤其是1与0之间选择，最好需要拿一个例子推演，不然容易出错。
* 0 1 2 3
* 3 左边3个元素，最大值Index为2，但0 + 3 = 3。 也就是begin index + size - 1 = end index
* */

public class ReconstructBinaryTreeWithPostOrderAndInOrder {

    private TreeNode reconstruct(int[] inOrder, int[] postOrder, Map<Integer,Integer> postionInOrder, int postOrderBegin, int postOrderEnd, int inOrderBegin, int inOrderEnd) {
        if(postOrderBegin > postOrderEnd || inOrderBegin > inOrderEnd) {
            return null;
        }

        int rootKey = postOrder[postOrderEnd];
        TreeNode root = new TreeNode(rootKey);
        int postionRoot = postionInOrder.get(rootKey);
        int leftSize = postionRoot - inOrderBegin;

        root.left = reconstruct(inOrder, postOrder, postionInOrder, postOrderBegin, postOrderBegin + leftSize - 1, inOrderBegin, postionRoot - 1);
        root.right = reconstruct(inOrder, postOrder, postionInOrder, postOrderBegin + leftSize, postOrderEnd - 1, postionRoot + 1, inOrderEnd);
        return root;
    }

    public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
        // Write your solution here
        if(inOrder == null || postOrder == null) {
            return null;
        }
        Map<Integer,Integer> postionInOrder = new HashMap<Integer, Integer>();
        for (int i = 0; i < inOrder.length; i++){
            postionInOrder.put(inOrder[i], i);
        }
        return reconstruct(inOrder, postOrder, postionInOrder, 0, inOrder.length - 1, 0, inOrder.length - 1);
    }

    public static void main(String[] args) {
        ReconstructBinaryTreeWithPostOrderAndInOrder r = new ReconstructBinaryTreeWithPostOrderAndInOrder();
        r.reconstruct(new int[] {1,6,5,7,4,10,9},new int[] {6,7,5,1,9,10,4});

    }

}
