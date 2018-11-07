package array;

/**
 * Created by kewang on 2/11/18.
 */
public class MedianOfTwoSortedArrays {
    public double median(int[] a, int[] b) {
        // Write your solution here
        if( a == null || b == null || a.length < 1 || b.length < 1) {
            //threw exception
        }
        // 1 2 3 4 6 -> 5/2 = 2
        // 1 2 3 4 -> 4/2 = 2 -> (1,2)
        int totalLength = a.length + b.length;
        int count = 0;
        int i = 0;
        int j = 0;
        int currentValue = 0;
        int previousValue = 0;
        while( count <= totalLength/2 ){
            if( j == b.length || (i < a.length && a[i] <= b[j]) ){
                previousValue = currentValue;
                currentValue = a[i];
                i++;
            } else {
                previousValue = currentValue;
                currentValue = b[j];
                j++;
            }
            count++;
        }

        if(totalLength%2 == 0) {
            return (previousValue + currentValue)/2.0;
        } else {
            return currentValue;
        }
    }
}
