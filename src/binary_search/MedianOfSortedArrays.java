package binary_search;

/**
 * Created by kewang on 2/11/18.
 */
/*
* k 还是作为序号，从1开始更好想也更好处理。
* */
public class MedianOfSortedArrays {

    private double findMedian(int[] nums1, int[] nums1Index, int[] nums2, int[] nums2Index, int k) {
        //System.out.println("------------------");
        //System.out.println( String.valueOf(k) );
        //System.out.println(String.valueOf(nums1Index[0]) +String.valueOf(nums1.length));
        //System.out.println(String.valueOf(nums2Index[0]) +String.valueOf(nums2.length));

        if(nums1Index[0] >= nums1.length) {
            return nums2[nums2Index[0] + k - 1];
        } else if (nums2Index[0] >= nums2.length ) {
            return nums1[nums1Index[0] + k - 1];
        } else if (k == 1) {
            return Math.min( nums1[nums1Index[0]], nums2[nums2Index[0]]);
        }

        if (nums1Index[0] + k/2 - 1 >= nums1.length || (nums2Index[0] + k/2 - 1 < nums2.length && nums1[nums1Index[0] + k/2 - 1] >= nums2[nums2Index[0] + k/2 - 1]) ) {
            nums2Index[0] += k/2;
            return findMedian(nums1, nums1Index, nums2, nums2Index, k - k/2);
        } else {
            nums1Index[0] += k/2;
            return findMedian(nums1, nums1Index, nums2, nums2Index, k - k/2);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if(totalLength % 2 == 0){
            return (findMedian(nums1, new int[]{0}, nums2, new int[]{0}, totalLength/2 + 1)/2.0 + findMedian(nums1, new int[]{0}, nums2, new int[]{0}, totalLength/2)/2.0);
        } else {
            return findMedian(nums1, new int[]{0}, nums2, new int[]{0}, totalLength/2 + 1);
        }
    }
    public static void main(String[] args) {
        MedianOfSortedArrays m = new MedianOfSortedArrays();
        //m.findMedianSortedArrays(new int[]{1,3},new int[]{2});
        //m.findMedianSortedArrays(new int[]{1,2,3},new int[]{4});
        m.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
        m.findMedianSortedArrays(new int[]{2},new int[]{});
    }
}
