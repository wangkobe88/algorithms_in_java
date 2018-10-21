package array;

/**
 * Created by kewang on 20/10/18.
 */
public class ArrayDeduplicationII {
    public int[] dedup(int[] array) {
        // Write your solution here
        if(array == null || array.length <= 2){
            return array;
        }

        int slow = 2;
        int fast = 2;
        while(fast < array.length){
            if(array[fast] == array[slow - 2]){
                fast ++;
            } else {
                array[slow++] = array[fast++];
            }
        }

        int[] results = new int[slow];
        for (int i = 0; i < results.length; i++){
            results[i] = array[i];
        }
        return results;
    }
}
