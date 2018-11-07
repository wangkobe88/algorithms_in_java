package array;
import java.util.*;
/**
 * Created by kewang on 7/11/18.
 */
/*
* 两个数组需要出现的数量一致，所以必须用Map而不是Set；
* 写完代码后，需要逐行检查，没有编辑器问题有可能出在各个方面。
* */
public class IntersectionOfTwoArraysll {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Map<Integer,Integer> nums1Map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums1.length; i++) {
            if(!nums1Map.containsKey(nums1[i])) {
                nums1Map.put(nums1[i],1);
            } else {
                nums1Map.put(nums1[i], nums1Map.get(nums1[i]) + 1);
            }
        }

        int[] tempResult = new int[nums2.length];
        int count = 0;
        for(int i = 0; i < nums2.length; i++) {
            if(nums1Map.containsKey(nums2[i])) {
                tempResult[ count++ ] = nums2[i];
                if(nums1Map.get(nums2[i]) == 1) {
                    nums1Map.remove(nums2[i]);
                } else {
                    nums1Map.put(nums2[i], nums1Map.get(nums2[i]) - 1);
                }
            }
        }

        int[] result = new int[count];
        for(int i = 0; i < count; i++){
            result[i] = tempResult[i];
        }
        return result;
    }
}
