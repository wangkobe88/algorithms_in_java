package tree.serialization;
import java.util.*;
/**
 * Created by kewang on 8/11/18.
 */
public class SerializeAndDeserializeBinaryTree {
    /**
     1
     2   3
     4 5
     1,2,NN,NN,3,4,NN,NN,5,NN,NN,

     * Definition for a binary tree node.
     */
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    public void serialize(TreeNode root, StringBuilder temp) {
        if(root == null) {
            temp.append("NN").append(",");
            return;
        } else {
            temp.append(root.val).append(",");
        }
        serialize(root.left, temp);
        serialize(root.right, temp);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder temp = new StringBuilder();
        serialize(root,temp);
        //System.out.println(temp);
        return temp.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new ArrayList();
        for(String node : data.split(",")){
            nodes.add(node);
        }
        return buildTree(nodes);
    }

    private TreeNode buildTree(List<String> nodes) {
        String val = nodes.remove(0);
        if (val.equals("NN")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
