package binary_search;
import java.util.*;
/**
 * Created by kewang on 14/11/18.
 */
/*
左右两指针一起动的情况，还是大循环在两个指针都满足条件的情况下进入更加简便，代码容易写。
并且需要明确两个指针的物理含义，是包含两个指针元素，还是不包含？
* */
public class FindKClosestElementsV2 {
    private int findClosetElement(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;

        while(start < (end - 1)) {
            int mid = start + (end - start)/2;
            if(arr[mid] > x) {
                end = mid;
            } else if(arr[mid] < x) {
                start = mid;
            } else {
                return mid;
            }
        }
        if(Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)) {
            return start;
        } else {
            return end;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        if(arr == null || k > arr.length) {
            return  result;
        }

        int mid = findClosetElement(arr,x);
        // 0 1 2

        int smallerIndex = mid - 1;
        int biggerIndex = mid + 1;
        while( smallerIndex >= 0 && biggerIndex < arr.length && (biggerIndex - smallerIndex - 1) < k) {
            if(Math.abs(arr[smallerIndex] - x) <= Math.abs(arr[biggerIndex] - x)) {
                smallerIndex--;
            } else {
                biggerIndex++;
            }
        }

        while(smallerIndex >= 0 && (biggerIndex - smallerIndex - 1) < k){
            smallerIndex --;
        }

        while(biggerIndex < arr.length && (biggerIndex - smallerIndex - 1) < k){
            biggerIndex ++;
        }

        for(int i = (smallerIndex + 1); i < biggerIndex; i++) {
            result.add(arr[i]);
        }
        //Collections.sort(result);
        return result;
    }
}
