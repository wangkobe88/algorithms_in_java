package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kewang on 22/9/18.
 */
public class GetKeysInBinarySearchTreeInGivenRange {

    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> nodeValues = new ArrayList<Integer>();
        getRange(root, nodeValues, min, max);
        return nodeValues;
    }

    private void getRange(TreeNode root,List<Integer> nodeValues, int min, int max){
        if (root == null){
            return;
        }
        if (root.key > min) {
            getRange(root.left, nodeValues, min, max);
        }
        if (root.key >= min && root.key <= max ) {
            nodeValues.add(root.key);
        }
        if (root.key < max) {
            getRange(root.right, nodeValues, min, max);
        }
    }
}
