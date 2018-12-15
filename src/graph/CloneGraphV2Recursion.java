package graph;
import java.util.*;

/**
 * Created by kewang on 10/11/18.
 */
/*
* BFS 方法，也可以用recursion的方法。
* Recursion的方法比较难想。
* 在这里:
* Base Case: 没有邻居，或者邻居都已经被拷贝过
* Recursion Rule: 依次拷贝每一个邻居，在某个邻居之前没有被拷贝的时候，Recursive调用。
* */

public class CloneGraphV2Recursion {
    /**
     * Definition for undirected graph.
     **/
    class UndirectedGraphNode {
          int label;
          List<UndirectedGraphNode> neighbors;
          UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    private UndirectedGraphNode cloneNode(UndirectedGraphNode node, Map<UndirectedGraphNode,UndirectedGraphNode> dedupMap) {
        if(!dedupMap.containsKey(node)) {
            dedupMap.put(node, new UndirectedGraphNode(node.label));
        }
        UndirectedGraphNode newNode = dedupMap.get(node);
        for(UndirectedGraphNode neighbor : node.neighbors) {
            if(!dedupMap.containsKey(neighbor)) {
                newNode.neighbors.add(cloneNode(neighbor, dedupMap));
            } else {
                newNode.neighbors.add(dedupMap.get(neighbor));
            }
        }
        return newNode;
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        Map<UndirectedGraphNode,UndirectedGraphNode> dedupMap = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        return cloneNode(node, dedupMap);

    }
}
