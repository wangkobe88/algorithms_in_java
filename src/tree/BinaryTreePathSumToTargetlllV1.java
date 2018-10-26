package tree;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by kewang on 26/10/18.
 */
public class BinaryTreePathSumToTargetlllV1 {
    private boolean judgeExist(List<TreeNode> pathNodes, int target) {
        int sum = 0;
        for(int i = pathNodes.size() - 1; i >=0; i--){
            sum += pathNodes.get(i).key;
            if(sum == target) {
                return true;
            }
        }
        return false;
    }

    private void isExist(TreeNode root, List<TreeNode> pathNodes, int target, boolean[] isExist) {
        if(root == null) {
            return;
        }
        pathNodes.add(root);
        isExist[0] = judgeExist(pathNodes, target) == true ? true : isExist[0];

        isExist(root.right, pathNodes, target, isExist);
        pathNodes.remove(root.right);
        isExist(root.left, pathNodes, target, isExist);
        pathNodes.remove(root.left);
    }
    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        if(root == null) {
            return false;
        }

        boolean[] isExist = new boolean[1];
        List<TreeNode> pathNodes = new ArrayList<TreeNode>();
        isExist(root, pathNodes, target, isExist);
        return isExist[0];
    }
}
