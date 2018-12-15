package binary_search;

/**
 * Created by kewang on 11/11/18.
 */
/*
* 用binarysearch的时候，找某一个特定值，在下一次迭代可以不包含中间节点。
* 而找最大最小值，或者接近值，往往需要包含中间节点，而且需要前后指针距离为1时就结束。
* */

public class SearchInRotatedSortedArray {
    private int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end ) {
            int mid = start + (end - start)/2;
            if(nums[mid] > target) {
                end = mid - 1;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        if(nums[start] < nums[end]) {
            return binarySearch(nums, start, end, target);
        }

        while (start < (end - 1)) {
            //System.out.println(String.valueOf(start) + String.valueOf(end));
            int mid = start + (end - start)/2;
            if(nums[start] > nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int minIndex = nums[start] < nums[end] ? start : end;
        //System.out.println(minIndex);
        if(target > nums[0]) {
            return binarySearch(nums,0,minIndex - 1,target);
        } else if(target < nums[0]) {
            return binarySearch(nums,minIndex,nums.length-1,target);
        } else {
            return 0;
        }
    }
}
