package array;
import java.util.*;
/**
 * Created by kewang on 7/11/18.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> nums1Set = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++) {
            nums1Set.add( nums1[i] );
        }

        Set<Integer> tempResult = new HashSet<Integer>();
        for(int i = 0; i < nums2.length; i++) {
            if(nums1Set.contains( nums2[i] )) {
                tempResult.add( nums2[i] );
            }
        }

        int[] result = new int[ tempResult.size() ];
        int count = 0;
        for(int value : tempResult){
            result[ count++ ] = value;
        }
        return result;
    }
}
