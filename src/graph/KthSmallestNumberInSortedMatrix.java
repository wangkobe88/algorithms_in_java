package graph;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by kewang on 24/9/18.
 */
public class KthSmallestNumberInSortedMatrix {
    class Node implements Comparable<Node> {
        int row;
        int col;
        int value;

        Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value > o.value) {
                return 1;
            } else if (this.value < o.value) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private static int getIndex(int row,int col){
        return row*100000 + col;
    }

    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        int index = 0;
        Set<Integer> s = new HashSet<Integer>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(0, 0, matrix[0][0]));
        s.add(getIndex(0,0));
        int value = matrix[0][0];
        while(index < k){
            Node node = pq.poll();
            int row = node.row;
            int col = node.col;
            //System.out.println(col);
            value = node.value;
            if (!s.contains(getIndex(row + 1,col)) && (row + 1 <= matrix.length - 1 )) {
                pq.offer(new Node(node.row + 1, node.col, matrix[node.row + 1][node.col]));
                s.add(getIndex(row + 1,col));
            }
            if (!s.contains(getIndex(row,col + 1)) && (col + 1 <= matrix[0].length -1)) {
                s.add(getIndex(row,col + 1));
                pq.offer(new Node(node.row, node.col + 1, matrix[node.row][node.col + 1]));
            }
            index++;
        }
        return value;
    }

    public static void main(String[] args) {
        KthSmallestNumberInSortedMatrix kthSmallestNumberInSortedMatrix = new KthSmallestNumberInSortedMatrix();

        int result = kthSmallestNumberInSortedMatrix.kthSmallest(new int[][]{{1,2}}, 2);

        System.out.println(result);
    }
}
