package tree;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by kewang on 26/10/18.
 */

/*
* 错误1:保存的路径信息，在退出函数时，需要清除自己对其的改变。
* 不要清除子节点对其的改变，因为无法预知子节点的状况。
* */
public class BinaryTreePathSumToTargetlllV2 {

    private void isExist(TreeNode root, Set<Integer> pathSums, int currentSum, int target, boolean[] isExist) {
        if(root == null) {
            return;
        }
        currentSum += root.key;

        isExist[0] = pathSums.contains(currentSum - target) == true ? true : isExist[0];

        pathSums.add(currentSum);
        isExist(root.right, pathSums, currentSum, target, isExist);
        //pathSums.remove(currentSum + root.right);

        isExist(root.left, pathSums, currentSum, target, isExist);
        pathSums.remove(currentSum);
    }

    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        if(root == null) {
            return false;
        }

        boolean[] isExist = new boolean[1];
        Set<Integer> pathSums = new HashSet<Integer>();
        pathSums.add(0);
        isExist(root, pathSums, 0, target, isExist);
        return isExist[0];
    }
}
