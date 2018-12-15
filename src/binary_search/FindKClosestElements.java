package binary_search;
import java.util.*;
/**
 * Created by kewang on 8/11/18.
 */

/*
* 寻找到数组中最接近的数，实质上是找到一个比它大一个比它小的数，所以停止条件是备空间缩小到2；
* 并且，一个数比它大或者小，并不意味着它不是最优解，所以要将其包含在内；
* 从中间节点往前后遍历，如果两个节点有一个没到头就可以进入循环，需要注意如何判断，一般判断逻辑是:
* 一头合法&&(另一头不合法 || 比较条件判断)
* */
public class FindKClosestElements {
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
        result.add(arr[mid]);
        int smallerIndex = mid - 1;
        int biggerIndex = mid + 1;
        while( (smallerIndex >= 0 || biggerIndex < arr.length) && result.size() < k) {
            if(smallerIndex >= 0 && (biggerIndex == arr.length || Math.abs(arr[smallerIndex] - x) <= Math.abs(arr[biggerIndex] - x) )) {
                result.add(arr[smallerIndex]);
                smallerIndex--;
            } else {
                result.add(arr[biggerIndex]);
                biggerIndex++;
            }
        }
        Collections.sort(result);
        return result;
    }
}
