package graph;

/**
 * Created by kewang on 24/10/18.
 */

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/*
class GraphNode {
   public int key;
   public List<GraphNode> neighbors;
   public GraphNode(int key) {
     this.key = key;
     this.neighbors = new ArrayList<GraphNode>();
   }
}
*/

/*
* 设置HashMap不仅仅是防止重复拷贝，最重要的是，在图遍历中不去重会进入死循环。
* 所以在图的遍历中，HashMap应用可能更加广泛。
*
* */


public class DeepCopyUndirectedGraph {
    private GraphNode copy(GraphNode graphNode, Map<GraphNode, GraphNode> lookup) {
        if(graphNode == null) {
            return null;
        }
        if(!lookup.containsKey(graphNode)){
            lookup.put( graphNode, new GraphNode(graphNode.key) );
        }
        GraphNode newGraphNode = lookup.get(graphNode);

        for(GraphNode neighbor : graphNode.neighbors) {
            if (lookup.containsKey(neighbor)){
                newGraphNode.neighbors.add( lookup.get(neighbor) );
            } else {
                newGraphNode.neighbors.add( copy(neighbor, lookup) );
            }
        }
        return newGraphNode;
    }

    public List<GraphNode> copy(List<GraphNode> graph) {
        // Write your solution here.
        if(graph == null) {
            return null;
        }
        List<GraphNode> newGraph = new ArrayList<GraphNode>();
        for(GraphNode graphNode : graph){
            newGraph.add( copy( graphNode, new HashMap<GraphNode,GraphNode>() ) );
        }
        return newGraph;
    }
}
