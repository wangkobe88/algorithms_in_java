package array;
import java.util.*;
/**
 * Created by kewang on 3/11/18.
 */
/*
*  Set<Integer> set = new HashSet<Integer>(cands.keySet());
*  在对Map进行key 的迭代的时候，不能对其进行修改，只能将key的集合拷贝一份，然后进行处理。
* */
public class MajorityNumberIII {
    public List<Integer> majority(int[] array, int k) {
        // Write your solution here
        List<Integer> result = new ArrayList<Integer>();
        if( array == null || array.length == 0) {
            return result;
        }

        Map<Integer, Integer> cands = new HashMap<Integer,Integer>();

        for(int i = 0; i < array.length; i++) {
            if(cands.size() < k) {
                if( !cands.containsKey(array[i]) ) {
                    cands.put(array[i], 1);
                } else {
                    cands.put(array[i], cands.get(array[i]) + 1);
                }
            } else {
                Set<Integer> set = new HashSet<Integer>(cands.keySet());
                for( int key : set) {
                    if(key == array[i]) {
                        cands.put(key, cands.get(key) + 1);
                    } else {
                        if(cands.get(key) == 1){
                            cands.remove(key);
                        } else {
                            cands.put(key, cands.get(key) - 1);
                        }
                    }
                }
            }
        }
        Map<Integer, Integer> candCounts = new HashMap<Integer,Integer>();
        for(int key : cands.keySet() ) {
            candCounts.put(key,0);
        }

        for(int i = 0; i < array.length; i++) {
            if( candCounts.containsKey(array[i]) ) {
                candCounts.put(array[i], candCounts.get(array[i]) + 1);
            }
        }
        for(int key : candCounts.keySet()) {
            if(candCounts.get(key) > (array.length * 1.0)/k) {
                result.add(key);
            }
        }
        return result;
    }
}
