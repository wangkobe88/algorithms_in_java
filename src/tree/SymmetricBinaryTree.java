package tree;

/**
 * Created by kewang on 22/9/18.
 */
public class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {
        // Write your solution here
        if (root == null){
            return true;
        }
        return isSymmetric( root.left, root.right );
    }

    public boolean isSymmetric(TreeNode one, TreeNode two){
        if (one == null && two == null){
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key){
            return false;
        }else{
            return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
        }
    }

}
