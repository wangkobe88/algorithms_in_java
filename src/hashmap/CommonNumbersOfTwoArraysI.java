package hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kewang on 30/9/18.
 */
public class CommonNumbersOfTwoArraysI {
    public List<Integer> common(List<Integer> a, List<Integer> b) {
        // Write your solution here
        Set<Integer> aSet = new HashSet<Integer>();
        aSet.addAll(a);

        Set<Integer> coommonSet = new HashSet<Integer>();

        for (Integer i : b) {
            if (aSet.contains(i)) {
                coommonSet.add(i);
            }
        }
        List<Integer> results = new ArrayList<Integer>();
        results.addAll(coommonSet);
        return results;
    }
}
