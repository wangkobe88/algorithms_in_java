package dynamic_programming;

/**
 * Created by kewang on 5/11/18.
 */

/*
* 用1维DP，那么临时解代表什么？
* 采用包含或者不包含当前元素的临时解，才能让解从上面一个或者所有的已有解继承下来？
* 如何继承下来？
* */
public class LongestAscendingSubsequece {
    // xx1xx2xx327x56
    public int longest(int[] array) {
        // Write your solution here
        if( array == null ) {
            //threw exception
        }

        int[] result = new int[array.length];
        int globalMaxLength = 0;
        for(int i = 0; i < array.length; i++) {
            if(i == 0) {
                result[i] = 1;
            } else {
                int maxLength = 1;
                for(int j = i - 1; j >= 0; j--) {
                    if(array[i] > array[j]) {
                        maxLength = Math.max(maxLength, result[j] + 1);
                    }
                }
                result[i] = maxLength;
            }
            globalMaxLength = Math.max(globalMaxLength, result[i]);
        }
        return globalMaxLength;
    }
}
