package sum;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by kewang on 29/10/18.
 */
public class Sum2 {
    public boolean existSum(int[] array, int target) {
        // Write your solution here
        if( array == null ) {
            return false;
        }

        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < array.length; i++) {
            if(set.contains(target - array[i])) {
                return true;
            }
            set.add( array[i] );
        }
        return false;
    }
}
