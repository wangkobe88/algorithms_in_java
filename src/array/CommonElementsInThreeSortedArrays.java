package array;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by kewang on 31/10/18.
 */
public class CommonElementsInThreeSortedArrays {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        // Write your solution here
        int aPointer  = 0;
        int bPointer = 0;
        int cPointer = 0;
        List<Integer> result = new ArrayList<Integer>();
        while(aPointer < a.length && bPointer < b.length && cPointer < c.length ) {
            if(a[aPointer] == b[bPointer] && b[bPointer] == c[cPointer]) {
                result.add(a[aPointer]);
                aPointer++;
                bPointer++;
                cPointer++;
                continue;
            }

            int minValue = Math.min( Math.min( a[aPointer], b[bPointer] ), c[cPointer] );
            if(minValue == a[aPointer]) {
                aPointer++;
            }
            if(minValue == b[bPointer]) {
                bPointer++;
            }
            if(minValue == c[cPointer]) {
                cPointer++;
            }
        }
        return result;
    }
}
