package dynamic_programming;

/**
 * Created by kewang on 12/10/18.
 */
public class LargestSubArraySum {
    public int largestSum(int[] array) {
        // Write your solution here

        if(array == null || array.length == 0){
            return 0;
        }

        int[] results = new int[array.length];
        results[0] = array[0];
        int maxLength = results[0];
        for(int i = 1; i < array.length; i++){
            results[i] = results[i-1] > 0 ? results[i-1] + array[i] : array[i];
            maxLength = Math.max(results[i], maxLength);
        }
        return maxLength;
    }
}
