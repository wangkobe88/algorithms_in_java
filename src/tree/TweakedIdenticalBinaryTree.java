package tree;

/**
 * Created by kewang on 22/9/18.
 */
public class TweakedIdenticalBinaryTree {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // Write your solution here
        if (one == null && two == null){
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key){
            return false;
        }else{
            return (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right))
                    || (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left));
        }
    }
}
