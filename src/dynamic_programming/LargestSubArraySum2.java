package dynamic_programming;

/**
 * Created by kewang on 14/10/18.
 */
public class LargestSubArraySum2 {
    public int[] largestSum(int[] array) {
        // Write your solution here
        if(array == null || array.length == 0){
            //return 0;
        }

        int[] results = new int[array.length];
        results[0] = array[0];
        int maxLength = results[0];
        int left = 0;
        int right = 0;
        int solution_left = 0;
        int solution_right = 0;
        for(int i = 1; i < array.length; i++){
            if(results[i-1] > 0) {
                right = i;
                results[i] = results[i-1] + array[i];
            } else {
                left = i;
                right = i;
                results[i] = array[i];
            }
            if(results[i] > maxLength){
                maxLength = results[i];
                solution_left = left;
                solution_right = right;
            }

        }
        return new int[]{maxLength, solution_left, solution_right};
    }
}
