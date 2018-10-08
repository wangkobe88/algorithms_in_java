package heap;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Math;
import java.util.Random;

/**
 * Created by kewang on 24/9/18.
 */

public class KSmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if (array == null && k <= 0){
            return new int[0];
        }
        PriorityQueue<Integer> PQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < array.length; i ++) {
            PQueue.add(array[i]);
        }
        int[] results = new int[k];
        int index = 0;
        while (index < k){
            results[index] = PQueue.poll();
            index ++;
        }
        return results;
    }

    public class IntegerComparator implements Comparator<Integer>
    {
        public int compare(Integer t1, Integer t2)
        {
            return t2 - t1;
        }
    }

    public int[] kSmallestSolution2(int[] array, int k) {
        // Write your solution here
        if (array == null || k <= 0){
            return new int[0];
        }
        PriorityQueue<Integer> PQueue;
        PQueue = new PriorityQueue<Integer>(k, new IntegerComparator());

        for (int i = 0; i < k; i++){
            PQueue.add(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            if (array[i] < PQueue.peek()){
                PQueue.poll();
                PQueue.add(array[i]);
            }
        }
        int[] results = new int[k];
        while (k > 0){
            results[k-1] = PQueue.poll();
            k--;
        }
        return results;
    }




    public static void main(String[] args) {
        KSmallestInUnsortedArray kSmallestInUnsortedArray = new KSmallestInUnsortedArray();
        //int[] results = kSmallestInUnsortedArray.kSmallest(new int[]{1}, 1);
        int[] results = kSmallestInUnsortedArray.kSmallest(new int[]{5,3,4,2,1,1,2,1,8,4,4,9,13,5,8}, 5);
        results = kSmallestInUnsortedArray.kSmallestSolution2(new int[]{}, 0);
        for (int i = 0; i < results.length; i++) {
            //System.out.println(results[i]);
        }

        results = kSmallestInUnsortedArray.kSmallestSolution2(new int[]{1}, 1);
        for (int i = 0; i < results.length; i++) {
            //System.out.println(results[i]);
        }

        results = kSmallestInUnsortedArray.kSmallestSolution2(new int[]{3,1,5,2,4}, 3);
        for (int i = 0; i < results.length; i++) {
            //System.out.println(results[i]);
        }

        results = kSmallestInUnsortedArray.kSmallestSolution2(new int[]{3,1,5,2,4}, 2);
        for (int i = 0; i < results.length; i++) {
            //System.out.println(results[i]);
        }

        results = kSmallestInUnsortedArray.kSmallestSolution2(new int[]{1,2,3,4}, 2);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
