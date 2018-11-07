package tree;

/**
 * Created by kewang on 7/11/18.
 */
/*
* 以边的数量而不是以节点数量为结果的题目。
* 需要注意，如果只有一个节点，边是0个。
* 如果有两个节点，才是1条边。
* */
public class DiameterOfBinaryTree {
    private int diameterOfBinaryTree(TreeNode root, int[] diameter) {
        if( root == null ) {
            return 0;
        }

        int leftLongestPath = diameterOfBinaryTree(root.left, diameter);
        int rightLongestPath = diameterOfBinaryTree(root.right, diameter);

        int currentDiameter = leftLongestPath + rightLongestPath + 1;
        diameter[0] = Math.max(currentDiameter, diameter[0]);

        return Math.max(leftLongestPath, rightLongestPath) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0; //wrong here.
        }

        int[] diameter = new int[1];
        diameterOfBinaryTree(root, diameter);
        return diameter[0] - 1;
    }
}
