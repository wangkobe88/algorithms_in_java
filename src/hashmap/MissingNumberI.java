package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kewang on 30/9/18.
 */
public class MissingNumberI {
    public int missing(int[] array) {
        if (array== null|| array.length <= 0){
            return 1;
        }
        // Write your solution here
        Set<Integer> numbers = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++){
            numbers.add(array[i]);
        }

        for (int i = 1; i <= array.length + 1; i++){
            if (!numbers.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}
