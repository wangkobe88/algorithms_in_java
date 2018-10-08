package graph;
import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.*;

/**
 * Created by kewang on 24/9/18.
 */

class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}

public class isBipartite {
    //input: {0->1,2;1->0,2;2->0,1}
    //output: true

    public boolean isBipartite(List<GraphNode> graph) {
        // write your solution here
        if ( graph == null ){
            return false;
        }

        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        GraphNode firstNode = graph.get(0);
        Map<Integer,Boolean> nodeGroupMap = new HashMap<Integer, Boolean>();
        nodeGroupMap.put(firstNode.key, true);
        queue.add(firstNode);
        Boolean group = true;

        while (!queue.isEmpty()){
            GraphNode node = queue.poll();
            group = nodeGroupMap.get(node.key);

            if(node.neighbors == null){
                continue;
            }

            for (GraphNode childNode : node.neighbors) {
                if (nodeGroupMap.containsKey(childNode.key)) {
                    if (nodeGroupMap.get(childNode.key).equals(group)) {
                        return false;
                    }
                } else {
                    queue.offer(childNode);
                    nodeGroupMap.put(childNode.key, !group);
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        isBipartite isB = new isBipartite();
        GraphNode gn1 = new GraphNode(1);
        GraphNode gn2 = new GraphNode(2);
        GraphNode gn3 = new GraphNode(3);
        gn1.neighbors.add(gn2);
        gn1.neighbors.add(gn3);
        gn2.neighbors.add(gn1);
        gn2.neighbors.add(gn3);
        gn3.neighbors.add(gn1);
        gn3.neighbors.add(gn2);
        List<GraphNode> graph = new ArrayList<GraphNode>();
        graph.add(gn1);
        graph.add(gn2);
        graph.add(gn3);
        System.out.println(isB.isBipartite(graph));

    }
}
