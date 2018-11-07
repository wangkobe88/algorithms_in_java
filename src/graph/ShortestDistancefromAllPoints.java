package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by kewang on 31/10/18.
 */
public class ShortestDistancefromAllPoints {

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

    public int[][] shortestDistance(int[][] grid,int row, int col) {
        // Write your solution here
        if (grid == null) {
            //return -1;
        }

        PriorityQueue<Node> heap = new PriorityQueue<Node>(new Comparator<Node>(){
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
        initResults(results);

        Set<Node> set = new HashSet<Node>();
        heap.offer(new Node(row, col, 0));
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

    private void combineResults(int[][] finalResults, int[][] tempResults) {
        for(int i = 0; i < finalResults.length; i++) {
            for (int j = 0; j < finalResults[0].length; j++) {
                if(tempResults[i][j] == -1 || finalResults[i][j] == -1) {
                    finalResults[i][j] = -1;
                } else {
                    finalResults[i][j] += tempResults[i][j];
                }
            }
        }
    }

    private void initResults(int[][] results) {
        for(int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[0].length; j++) {
                results[i][j] = -1;
            }
        }
    }

    public int shortestDistance(int[][] grid) {
        // Write your solution here
        int[][] finalResults = new int[grid.length][grid[0].length];
        //initResults(finalResults);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    int[][] tempResults = shortestDistance(grid, i, j);
                    combineResults(finalResults, tempResults);
                }
            }
        }

        int smallestDistance = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0 && finalResults[i][j] != -1 && smallestDistance > finalResults[i][j]) {
                    smallestDistance = finalResults[i][j];
                }
            }
        }

        return smallestDistance == Integer.MAX_VALUE ? -1 : smallestDistance;
    }

    public static void main(String[] args){
        ShortestDistancefromAllPoints s = new ShortestDistancefromAllPoints();
        int [][] grids = new int[][]{ {1,0}};
        // 0 2 1
        // 1 0 2
        // 0 1 0
        grids = new int[][]{ {0,2,1}, {1,0,2}, {0,1,0}};
        int results = s.shortestDistance(grids);
        System.out.println(results);
        /*
        for(int i = 0; i < results.length; i++) {

            for(int j = 0; j < results[0].length; j++){
                System.out.print(results[i][j]);
            }
            System.out.println();
        }
        */

    }
}
