package sum;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by kewang on 29/10/18.
 */
/*
*  结果去重的方法。
*  2Sum中，需要注意可能不止一个解。
* */
public class Sum3 {
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(array);
        Set<String> dedupSet = new HashSet<String>();
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
                    String resultString = String.valueOf(array[j]) + String.valueOf(array[k]);
                    if(dedupSet.contains(resultString)) {
                        j++;
                        k--;
                        continue;
                    } else {
                        dedupSet.add(resultString);
                    }

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
