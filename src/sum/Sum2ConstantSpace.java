package sum;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
/**
 * Created by kewang on 29/10/18.
 */
public class Sum2ConstantSpace {
    public int[] twoSum(int[] numbers, int target) {
        if( numbers == null ) {
            return new int[2];
        }
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(target > sum){
                i++;
            } else if(target < sum) {
                j--;
            } else {
                int[] result = new int[2];
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
        }
        return new int[2];
    }


    public boolean existSum(int[] array, int target) {
        // Write your solution here
        if( array == null ) {
            return false;
        }
        Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            int sum = array[i] + array[j];
            if(target > sum){
                i++;
            } else if(target < sum) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
