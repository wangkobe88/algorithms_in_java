package array;

/**
 * Created by kewang on 3/11/18.
 */
public class MajorityNumberI {
    public int majority(int[] array) {
        // Write your solution here
        if(array == null || array.length == 0) {
            //threw exception
        }
        int major = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i] == major) {
                count += 1;
            } else {
                if(count == 0) {
                    major = array[i];
                    count = 1;
                } else {
                    count -= 1;
                }
            }
        }
        return major;
    }
}
