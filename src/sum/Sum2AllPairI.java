package sum;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by kewang on 29/10/18.
 */
public class Sum2AllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here
        if( array == null ) {
            return null;
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();

        for (int i = 0; i < array.length; i++) {
            if( map.containsKey(target - array[i]) ){
                for(Integer pos : map.get(target - array[i])) {
                    List<Integer> result = new ArrayList<Integer>();
                    result.add(i);
                    result.add(pos);
                    results.add(result);
                }
            }
            if(!map.containsKey(array[i])) {
                Set<Integer> set = new HashSet<Integer>();
                set.add(i);
                map.put(array[i], set);
            } else {
                map.get(array[i]).add(i);
            }
        }
        return results;
    }
}
