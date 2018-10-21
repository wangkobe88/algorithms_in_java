package tree.lowest_common_ancestor;

/**
 * Created by kewang on 21/10/18.
 */


class TreeNodeP {
    public int key;
    public TreeNodeP left;
    public TreeNodeP right;
    public TreeNodeP parent;
    public TreeNodeP(int key, TreeNodeP parent) {
      this.key = key;
      this.parent = parent;
    }
}

/* 忘记检查Conor case，如两个结点为空，或者并不存在于树中 */

public class LowestCommonAncestorII {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // Write your solution here.
        if(one == null || two == null){
            return null;
        }

        int oneHeight = 0;
        int twoHeight = 0;
        TreeNodeP oneCopy = one;
        TreeNodeP twoCopy = two;
        while(oneCopy.parent != null) {
            oneHeight += 1;
            oneCopy = oneCopy.parent;
        }

        while(twoCopy.parent != null) {
            twoHeight += 1;
            twoCopy = twoCopy.parent;
        }

        if(oneCopy != twoCopy){
            return null;
        }

        int heightDistance = oneHeight - twoHeight;

        while(heightDistance > 0){
            one = one.parent;
            heightDistance--;
        }

        while(heightDistance < 0){
            two = two.parent;
            heightDistance++;
        }

        while(one != null){
            if(two == one){
                return one;
            }
            one = one.parent;
            two = two.parent;
        }
        return null;
    }
}
