package sum;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by kewang on 29/10/18.
 */
public class Sum4 {
    public boolean exist(int[] array, int target) {
        // Write your solution here
        if(array == null) {
            return false;
        }

        Arrays.sort(array);
        Map<Integer,List<Integer>> previous2Sum = new HashMap<Integer,List<Integer>>();

        for(int j = 1; j < array.length; j++) {
            for (int i = 0; i < j; i++) {
                int sum = array[i] + array[j];
                if(previous2Sum.containsKey(target - sum) && previous2Sum.get(target - sum).get(1) < i) {
                    return true;
                } else if(!previous2Sum.containsKey(sum)) {
                    List<Integer> pair = new ArrayList<Integer>();
                    pair.add(i);
                    pair.add(j);
                    previous2Sum.put(sum, pair);
                }
            }
        }
        return false;
    }
}
