package dynamic_programming;

/**
 * Created by kewang on 14/10/18.
 */
public class LongestConsecutive1s {
    public int longest(int[] array) {
        // Write your solution here
        if(array == null){
            //threw exception
        } else if (array.length == 0){
            return 0;
        }
        int[] results = new int[ array.length ];
        results[0] = array[0] == 1 ? 1:0;
        int maxLength = results[0];
        for(int i = 1; i < array.length; i++){
            if (array[i] == 1){
                results[i] = results[i - 1] + 1;
            } else {
                results[i] = 0;
            }
            maxLength = Math.max(maxLength, results[i]);
        }
        return maxLength;
    }
}
