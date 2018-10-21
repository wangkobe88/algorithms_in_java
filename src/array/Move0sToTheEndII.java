package array;

/**
 * Created by kewang on 20/10/18.
 */
public class Move0sToTheEndII {
    public int[] moveZero(int[] array) {
        // Write your solution here
        if( array == null || array.length == 0) {
            return array;
        }

        int slow = 0;
        int fast = 0;
        while ( fast < array.length ) {
            if( array[fast] != 0 ) {
                array[slow++] = array[fast++];
            } else {
                fast++;
            }
        }

        for(int i = slow; i < array.length; i++){
            array[i] = 0;
        }

        return array;
    }
}
