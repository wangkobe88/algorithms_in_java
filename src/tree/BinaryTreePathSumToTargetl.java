package tree;

/**
 * Created by kewang on 26/10/18.
 */
public class BinaryTreePathSumToTargetl {
    private void judgeIsExist(TreeNode root, int target, int currentSum, boolean[] isExist) {
        if(root == null) {
            return;
        }
        currentSum = (root.key + currentSum);
        if (root.left == null && root.right == null) {
            if (currentSum == target) {
                isExist[0] = true;
            }
        }

        judgeIsExist(root.left, target, currentSum, isExist);
        judgeIsExist(root.right, target, currentSum, isExist);
    }

    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        boolean[] isExist = new boolean[1];
        isExist[0] = false;
        judgeIsExist(root, target, 0, isExist);
        return isExist[0];
    }
}
