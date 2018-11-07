package array;
import java.util.*;

/**
 * Created by kewang on 3/11/18.
 */
public class MajorityNumberII {
    public List<Integer> majority(int[] array) {
        // Write your solution here
        if( array == null || array.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        if(array.length == 1) {
            result.add(array[0]);
            return result;
        } else if(array.length == 2) {
            result.add(array[0]);
            if(array[0] != array[1]) {
                result.add(array[1]);
            }
            return result;
        }

        int first = 0;
        int firstCount = 0;
        int second = 0;
        int secondCount = 0;
        boolean secondInit = false;
        for( int i = 0; i < array.length; i++){
            if(firstCount == 0) {
                first = array[i];
                firstCount += 1;
            } else if(secondCount == 0 && array[i] != first) {
                second = array[i];
                secondCount += 1;
            } else if (array[i] == first) {
                firstCount += 1;
                secondCount = (secondCount > 0) ?  secondCount - 1 : 0;
            } else if(array[i] == second) {
                secondCount += 1;
                firstCount -=1;
            }  else {
                firstCount -= 1;
                secondCount -= 1;
            }
        }

        int firstRealCount = 0;
        int secondRealCount = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] == first) {
                firstRealCount += 1;
            } else if(array[i] == second) {
                secondRealCount += 1;
            }
        }

        if(firstRealCount > array.length/3.0) {
            result.add(first);
        }
        if(secondRealCount > array.length/3.0) {
            result.add(second);
        }
        return result;
    }
}
