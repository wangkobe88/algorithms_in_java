package array;

/**
 * Created by kewang on 25/9/18.
 */
public class ArrayDeduplication1 {
    public int[] dedup(int[] array) {
        // Write your solution here
        if ( array==null || array.length == 0){
            return array;
        }
        int end = 0; // the end of the left duduplicated array
        for (int i = 1; i < array.length; i++){
            if(array[end] != array[i]){
                array[++end] = array[i];
            }
        }
        int[] results = new int[end+1];
        for (int i = 0; i < results.length; i++){
            results[i] = array[i];
        }
        return results;
    }
    public static void main(String[] args) {
        ArrayDeduplication1 arrayDeduplication1 = new ArrayDeduplication1();
        //kClosestInSortedArray.kClosest(new int[]{1,5}, 10, 1);
        arrayDeduplication1.dedup(new int[]{1,1,1});
    }

}
