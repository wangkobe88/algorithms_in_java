package tree.serialization;
import tree.TreeNode;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by kewang on 26/10/18.
 */
public class ReconstructBinaryTreeWithPreOrderAndInOrder {
    private TreeNode reconstruct(int[] inOrder, int[] preOrder, Map<Integer,Integer> posInOrder,int inOrderBegin, int inOrderEnd, int preOrderBegin,int preOrderEnd) {
        if (inOrderBegin > inOrderEnd || preOrderBegin > preOrderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preOrderBegin]);
        int pos = posInOrder.get(preOrder[preOrderBegin]);

        root.left = reconstruct(inOrder, preOrder, posInOrder,inOrderBegin, pos - 1, preOrderBegin + 1, preOrderBegin + (pos - inOrderBegin)); //3 = 0 + (3 - 0)
        root.right = reconstruct(inOrder, preOrder, posInOrder,pos + 1, inOrderEnd, preOrderBegin + (pos - inOrderBegin) + 1, preOrderEnd);
        return root;
    }

    //preOrder pos, inorder begin, end, preorder begin, end
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        // Write your solution here
        if(inOrder == null || preOrder == null) {
            return null;
        }
        Map<Integer,Integer> posInOrder = new HashMap<Integer, Integer>();
        for(int i = 0; i < inOrder.length; i++) {
            posInOrder.put(inOrder[i], i);
        }

        return reconstruct(inOrder, preOrder, posInOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
    }
}
