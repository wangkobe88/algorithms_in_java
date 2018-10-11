package dynamic_programming;

/**
 * Created by kewang on 11/10/18.
 */
public class LongestAscendingSubArray {
    public int longest(int[] array) {
        // Write your solution here
        if(array == null|| array.length == 0) {
            return 0;
        }

        int max_length = 1;
        int[] maxLengthWithCurrentEnding = new int[array.length];
        maxLengthWithCurrentEnding[0] = 1;
        for (int i = 1; i < array.length; i++){
            if(array[i] > array[i-1]){
                maxLengthWithCurrentEnding[i] = maxLengthWithCurrentEnding[i-1] + 1;
            } else {
                maxLengthWithCurrentEnding[i] = 1;
            }
            max_length = Math.max(max_length, maxLengthWithCurrentEnding[i]);
        }
        return max_length;
    }
}
