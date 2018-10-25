package heap;
import java.util.PriorityQueue;
/**
 * Created by kewang on 24/10/18.
 */

/*
* 错误1，Comparable 需要加入<类型>，不然比较函数需要改变对象的类型为Object
* 错误2，Comparable里面实现的函数是compareTo
* 错误3，compareTo必须是public
*
* 错误4，PriorityQueue函数为offer，poll，peak
*
* 错误5，在类中定义类，不用加权限控制
* */

public class MergeKSortedArray {

    class Element implements Comparable<Element> {
        int value;
        int indexOfArray;
        int indexInArray;

        Element(int value, int indexOfArray, int indexInArray) {
            this.value = value;
            this.indexOfArray = indexOfArray;
            this.indexInArray = indexInArray;
        }

        public int compareTo(Element other) {
            if(this.value > other.value) {
                return 1;
            } else if(this.value < other.value) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    public int[] merge(int[][] arrayOfArrays) {
        // Write your solution here
        if (arrayOfArrays == null){
            return null;
        }

        PriorityQueue<Element> pq = new PriorityQueue<Element>();

        for(int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i].length > 0){
                pq.offer( new Element(arrayOfArrays[i][0], i, 0) );
            }
        }

        int total = 0;
        for(int i = 0; i < arrayOfArrays.length; i++) {
            total += arrayOfArrays[i].length;
        }

        int[] results = new int[total];
        int count = 0;
        while(!pq.isEmpty()) {
            Element element = pq.poll();
            results[ count++ ] = element.value;
            if(element.indexInArray < arrayOfArrays[element.indexOfArray].length - 1){
                pq.offer(new Element(arrayOfArrays[element.indexOfArray][element.indexInArray + 1], element.indexOfArray, element.indexInArray + 1));
            }
        }
        return results;
    }
}
