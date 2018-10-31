package sum;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by kewang on 29/10/18.
 */
public class Sum3WrongAnswer {
    // 1 2 3 4 5 6 7 8 -> 8
    private int[] dedup(int[] array){
        // 1223
        int slow = 0;
        int fast = 1;
        while(fast < array.length) {
            if(array[slow] != array[fast]) {
                array[++slow] = array[fast++];
            } else {
                fast++;
            }
        }
        int[] newArray = new int[slow + 1];
        for(int i = 0; i <= slow; i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(array);
        array = dedup(array);

        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            int k = array.length - 1;
            int newTarget = target - array[i];
            while(j < k) {
                int sum = array[j] + array[k];
                if( sum < newTarget){
                    j++;
                } else if(sum > newTarget) {
                    k--;
                } else {
                    List<Integer> result = new ArrayList<Integer>();
                    result.add(array[i]);
                    result.add(array[j]);
                    result.add(array[k]);
                    results.add(result);
                    j++;
                    k--;
                }
            }
        }
        return results;
    }
}
