package heap;
import java.util.*;
/**
 * Created by kewang on 1/11/18.
 */
public class TrappingRainWaterll {
    class Element{
        int x;
        int y;
        int level;
        int height;
        boolean border;
        Element(int x, int y, int height,int level, boolean border) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.border = border;
            this.level = level;
        }
        public boolean equals(Object other) {
            Element otherPoint = (Element) other;
            return this.x == otherPoint.x && this.y == otherPoint.y;
        }
        public int hashCode(){
            return this.x * 917 + this.y;
        }
    }

    public int maxTrapped(int[][] matrix) {
        // Write your solution here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        PriorityQueue<Element> pq = new PriorityQueue<Element>( new Comparator<Element>(){
            public int compare(Element p1, Element p2){
                if(p1.height < p2.height) {
                    return -1;
                } else if(p1.height > p2.height) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        Set<Element> set = new HashSet<Element>();
        for( int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0 || i == matrix.length - 1|| j == matrix[0].length - 1){
                    Element element = new Element(i, j, matrix[i][j],matrix[i][j], true);
                    pq.offer(element);
                    set.add(element);
                }
            }
        }

        int totalWater = 0;
        while(!pq.isEmpty()) {
            Element current = pq.poll();
            int waterVolume = current.level - current.height;
            totalWater += waterVolume > 0 ? waterVolume : 0;
            //System.out.println("---x:" +String.valueOf(current.x ) + " y:" + String.valueOf(current.y) + " lowest:" + String.valueOf(current.height));
            if(current.x + 1 < matrix.length - 1) {
                Element element = new Element(current.x + 1, current.y, matrix[current.x + 1][current.y],Math.max(matrix[current.x + 1][current.y], current.level), false);
                if(!set.contains(element)){
                    pq.offer(element);
                    set.add(element);

                    System.out.println("x:" +String.valueOf(element.x ) + " y:" + String.valueOf(element.y) + " lowest:" + String.valueOf(current.height)  + " water:" + String.valueOf(element.height));
                }
            }

            if(current.x - 1 > 0) {
                //totalWater += waterVolume > 0 ? waterVolume : 0;
                Element element = new Element(current.x - 1, current.y, matrix[current.x - 1][current.y], Math.max(matrix[current.x - 1][current.y], current.level), false);
                if(!set.contains(element)){
                    pq.offer(element);
                    set.add(element);
                    //System.out.println("x:" +String.valueOf(element.x ) + " y:" + String.valueOf(element.y) + " lowest:" + String.valueOf(current.height)  + " water:" + String.valueOf(element.height));

                }
            }

            if(current.y + 1 < matrix[0].length - 1) {

                //totalWater += waterVolume > 0 ? waterVolume : 0;
                Element element = new Element(current.x, current.y + 1, matrix[current.x][current.y + 1], Math.max(matrix[current.x][current.y + 1], current.level), false);
                if(!set.contains(element)){
                    pq.offer(element);
                    set.add(element);
                    //System.out.println("x:" +String.valueOf(element.x ) + " y:" + String.valueOf(element.y) + " lowest:" + String.valueOf(current.height)  + " water:" + String.valueOf(element.height));

                }
            }

            if(current.y - 1 > 0) {
                //totalWater += waterVolume > 0 ? waterVolume : 0;
                Element element = new Element(current.x, current.y - 1, matrix[current.x][current.y - 1], Math.max(matrix[current.x][current.y - 1], current.level), false);
                if(!set.contains(element)){
                    pq.offer(element);
                    set.add(element);
                    //System.out.println("x:" +String.valueOf(element.x ) + " y:" + String.valueOf(element.y) +  " lowest:" + String.valueOf(current.height)  + " water:" + String.valueOf(element.height));

                }
            }
        }
        return totalWater;
    }
    public int trapRainWater(int[][] heightMap) {
        return maxTrapped(heightMap);
    }

    public static void main(String[] args) {
        TrappingRainWaterll tr = new  TrappingRainWaterll();
        System.out.println( tr.trapRainWater(new int[][] {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}) );

    }
}
