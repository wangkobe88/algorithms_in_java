package array;

/**
 * Created by kewang on 20/10/18.
 */
public class ArrayDeduplicationIII {
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0){
            return array;
        }

        int slow = 0;
        int fast = 0;
        while( fast < array.length ) {
            int begin = fast;
            while(fast < array.length && array[fast] == array[begin] ){
                fast ++;
            }
            if(fast - begin == 1){
                array[slow++] = array[begin];
            }
        }

        int[] results = new int[slow];
        for(int i = 0; i < slow; i++){
            results[i] = array[i];
        }
        return results;
    }

}
