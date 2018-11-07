package graph;

import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Created by kewang on 31/10/18.
 */
public class ShortestPath {
    class Node{
        int row;
        int col;
        int distance;

        Node(int row, int col, int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
        public boolean equals(Object other) {
            Node otherNode = (Node)other;
            return this.row == otherNode.row && this.col == otherNode.col;
        }

        public int hashCode() {
            return 917 * this.row + this.col;
        }
    }

    public int[][] shortestDistance(int[][] grid) {
        // Write your solution here
        if (grid == null) {
            //return -1;
        }

        PriorityQueue<Node> heap = new PriorityQueue<Node>( new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                if(n1.distance < n2.distance) {
                    return -1;
                } else if (n1.distance > n2.distance) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int[][] results = new int[grid.length][grid[0].length];
        Set<Node> set = new HashSet<Node>();
        heap.offer(new Node(0,0,0));
        while(!heap.isEmpty()) {
            Node current = heap.poll();
            set.add(current);

            results[ current.row ][ current.col ] = current.distance;
            if(current.row + 1 < grid.length && grid[current.row + 1][current.col] == 0) {
                Node down = new Node(current.row + 1, current.col, current.distance + 1);
                if(!set.contains(down)) {
                    heap.offer(down);
                    set.add(down);
                }
            }

            if(current.row - 1 >= 0 && grid[current.row - 1][current.col] == 0) {
                Node up = new Node(current.row - 1, current.col, current.distance + 1);
                if(!set.contains(up)) {
                    heap.offer(up);
                    set.add(up);
                }
            }

            if(current.col + 1 < grid[0].length && grid[current.row][current.col + 1] == 0) {
                Node right = new Node(current.row, current.col + 1, current.distance + 1);
                if(!set.contains(right)) {
                    heap.offer(right);
                    set.add(right);
                }
            }

            if(current.col - 1 >= 0 && grid[current.row][current.col - 1] == 0) {
                Node left = new Node(current.row, current.col - 1, current.distance + 1);
                if(!set.contains(left)) {
                    heap.offer(left);
                    set.add(left);
                }
            }

        }
        return results;
    }

    public static void main(String[] args){
        ShortestPath s = new ShortestPath();
        int [][] grids = new int[][]{ {1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
        int[][] results = s.shortestDistance(grids);
        for(int i = 0; i < results.length; i++) {
            for(int j = 0; j < results[0].length; j++){
                System.out.print(results[i][j]);
            }
            System.out.println();
        }

    }
}
