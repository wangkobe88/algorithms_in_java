package graph;
import java.util.*;

/**
 * Created by kewang on 10/11/18.
 */
/*
* BFS 方法，也可以用recursion的方法。
* 使用DFS的时候:
* 去重复，需要用到Map存储被拷贝节点与拷贝后节点之间的关系；
* 拷贝的是neighbors，节点本身已经被拷贝。拷贝后才会放在堆里面。
* 每一次处理一个节点，就是拷贝其邻居然后构建之间的关系。
* */

public class CloneGraph {
    /**
     * Definition for undirected graph.
     **/
    class UndirectedGraphNode {
          int label;
          List<UndirectedGraphNode> neighbors;
          UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode,UndirectedGraphNode> dedupMap = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
        newRoot.neighbors = node.neighbors;
        queue.offer(newRoot);
        dedupMap.put(node, newRoot);

        while(!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            List<UndirectedGraphNode> newNeighbors = new ArrayList<UndirectedGraphNode>();
            for(UndirectedGraphNode neighbor : current.neighbors){
                if(!dedupMap.containsKey(neighbor)) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    newNode.neighbors = neighbor.neighbors;
                    newNeighbors.add(newNode);
                    queue.offer(newNode);
                    dedupMap.put(neighbor,newNode);
                } else {
                    UndirectedGraphNode newNode = dedupMap.get(neighbor);
                    newNeighbors.add(newNode);
                }
            }
            current.neighbors = newNeighbors;
        }
        return newRoot;

    }
}
