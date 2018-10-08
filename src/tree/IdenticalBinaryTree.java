package tree;

/**
 * Created by kewang on 22/9/18.
 */
public class IdenticalBinaryTree {

    public boolean isIdentical(TreeNode one, TreeNode two) {
        // Write your solution here

        if (one == null && two == null){
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key){
            return false;
        }else{
            return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
        }
    }

}
