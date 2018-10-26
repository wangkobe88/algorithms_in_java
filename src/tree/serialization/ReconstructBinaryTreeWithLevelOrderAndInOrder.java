package tree.serialization;
import tree.TreeNode;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by kewang on 26/10/18.
 */
public class ReconstructBinaryTreeWithLevelOrderAndInOrder {

    private TreeNode reconstruct(int[] inOrder, int[] levelOrder, Map<Integer,Integer> positionInOrder, int inOrderStart, int inOrderEnd){
        if(levelOrder.length == 0) {
            return null;
        }

        int rootKey = levelOrder[0];
        TreeNode root = new TreeNode(rootKey);
        int rootPosition = positionInOrder.get(rootKey);
        Set<Integer> leftSet = new HashSet<Integer>();
        Set<Integer> rightSet = new HashSet<Integer>();
        for(int i = inOrderStart; i < rootPosition; i++) {
            leftSet.add(inOrder[i]);
        }

        for(int i = rootPosition + 1; i <= inOrderEnd; i++){
            rightSet.add(inOrder[i]);
        }

        int[] levelOrderLeft = new int[rootPosition - inOrderStart];
        int[] levelOrderRight = new int[inOrderEnd - rootPosition];
        int leftCount = 0;
        int rightCount = 0;
        for(int i = 1; i < levelOrder.length; i++){
            if( leftSet.contains(levelOrder[i]) ) {
                levelOrderLeft[ leftCount++ ] = levelOrder[i];
            } else {
                levelOrderRight[ rightCount++ ] = levelOrder[i];
            }
        }
        root.left = reconstruct(inOrder, levelOrderLeft, positionInOrder, inOrderStart, rootPosition-1);
        root.right = reconstruct(inOrder, levelOrderRight, positionInOrder, rootPosition + 1, inOrderEnd);
        return root;
    }


    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        // Write your solution here
        if(inOrder == null || levelOrder == null) {
            return null;
        }

        Map<Integer,Integer> inOrderPosition = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < inOrder.length; i++){
            inOrderPosition.put(inOrder[i],i);
        }
        return reconstruct(inOrder, levelOrder, inOrderPosition, 0, inOrder.length - 1);
    }

}
