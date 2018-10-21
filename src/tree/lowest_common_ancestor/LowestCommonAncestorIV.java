package tree.lowest_common_ancestor;
import tree.TreeNode;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
/**
 * Created by kewang on 21/10/18.
 */
public class LowestCommonAncestorIV {
    private TreeNode lowestCommonAncestor(TreeNode root, Set<TreeNode> nodesSet){
        if(root == null || nodesSet.contains(root)){
            return root;
        }
        TreeNode right = lowestCommonAncestor(root.right, nodesSet);
        TreeNode left = lowestCommonAncestor(root.left, nodesSet);
        if(right != null && left != null) {
            return root;
        } else if(right == null){
            return left;
        } else {
            return right;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // Write your solution here.
        if(root == null || nodes == null || nodes.size() == 0){
            return root;
        }

        Set<TreeNode> nodesSet = new HashSet<TreeNode>();
        for(TreeNode node : nodes){
            nodesSet.add(node);
        }
        return lowestCommonAncestor(root, nodesSet);
    }
}
