package graph;
import java.util.*;
/**
 * Created by kewang on 11/11/18.
 */
/*
* 既然是寻找一条最短路径，那么就应该考虑到使用最短路径算法。
*
* */
public class WordLadder {
    class GraphNode{
        int index;
        int length;
        List<GraphNode> neighbors;
        GraphNode (int index) {
            this.index = index;
            this.neighbors = new ArrayList<GraphNode>();
            this.length = 1;
        }
    }

    private boolean isValid(String s1, String s2) {
        int diff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                diff += 1;
            }
            if(diff > 1){
                break;
            }
        }
        return diff == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null) {
            return 0;
        }

        wordList.add(beginWord);
        GraphNode start = null;
        GraphNode target = null;
        Map<String,GraphNode> nodeMap = new HashMap<String,GraphNode>();
        for(int i = 0; i < wordList.size(); i++){
            String s1 = wordList.get(i);
            GraphNode newNode = new GraphNode(i);
            if(s1.equals(beginWord)) {
                start = newNode;
            } else if(s1.equals(endWord)) {
                target = newNode;
            }
            nodeMap.put(s1,newNode);
        }

        for(int i = 0; i < wordList.size(); i++){
            String s1 = wordList.get(i);
            for(int j = i+1; j < wordList.size(); j++) {
                String s2 = wordList.get(j);
                if(isValid(s1, s2)) {
                    nodeMap.get(s1).neighbors.add(nodeMap.get(s2));
                    nodeMap.get(s2).neighbors.add(nodeMap.get(s1));
                }
            }
        }

        PriorityQueue<GraphNode> queue = new PriorityQueue<GraphNode>(new Comparator<GraphNode>(){
            public int compare(GraphNode g1, GraphNode g2) {
                if(g1.length < g2.length) {
                    return -1;
                } else if(g1.length > g2.length) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        Set<GraphNode> dedupSet = new HashSet<GraphNode>();
        queue.offer(start);
        while(!queue.isEmpty()){
            GraphNode current = queue.poll();
            dedupSet.add(current);

            if(current == target) {
                //System.out.println(current.index);
                //System.out.println(target.index);
                return current.length;
            }

            for(GraphNode neighbor : current.neighbors) {
                //System.out.println(String.valueOf(current.index) + ":" + String.valueOf(neighbor.index));
                if(!dedupSet.contains(neighbor)){
                    neighbor.length = current.length + 1;
                    queue.offer(neighbor);
                    dedupSet.add(neighbor);
                }
            }
            //System.out.println("------------");
        }
        return 0;
    }
}
