package tree.serialization;
import tree.TreeNode;
/**
 * Created by kewang on 26/10/18.
 */
public class ConvertBinaryTreeToDoublyLinkedListI {
    private TreeNode toDoubleLinkedList(TreeNode root, TreeNode previous, TreeNode[] newRoot){
        if(root == null) {
            return null;
        }
        TreeNode left = toDoubleLinkedList(root.left, previous, newRoot);
        if(left == null && newRoot[0] == null) {
            newRoot[0] = root;
        } else if (left != null){
            previous = left;
        }

        if(previous != null){
            previous.right = root;
            root.left = previous;
        }


        TreeNode right = toDoubleLinkedList(root.right, root, newRoot);
        if(right != null) {
            return right;
        } else {
            return root;
        }

    }
    public TreeNode toDoubleLinkedList(TreeNode root) {
        // Write your solution here.
        if( root == null){
            return null;
        }
        TreeNode[] newRoot = new TreeNode[1];
        toDoubleLinkedList(root, null, newRoot);
        return newRoot[0];
    }
}
