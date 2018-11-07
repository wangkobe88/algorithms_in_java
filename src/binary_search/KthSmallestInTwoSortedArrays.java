package binary_search;

/**
 * Created by kewang on 2/11/18.
 */
public class KthSmallestInTwoSortedArrays {
    private int findKth(int[] nums1, int[] nums1Index, int[] nums2, int[] nums2Index, int k) {

        if(nums1Index[0] >= nums1.length) {
            return nums2[nums2Index[0] + k - 1];
        } else if (nums2Index[0] >= nums2.length ) {
            return nums1[nums1Index[0] + k - 1];
        } else if (k == 1) {
            return Math.min( nums1[nums1Index[0]], nums2[nums2Index[0]]);
        }

        if (nums1Index[0] + k/2 - 1 >= nums1.length || (nums2Index[0] + k/2 - 1 < nums2.length && nums1[nums1Index[0] + k/2 - 1] >= nums2[nums2Index[0] + k/2 - 1]) ) {
            nums2Index[0] += k/2;
            return findKth(nums1, nums1Index, nums2, nums2Index, k - k/2);
        } else {
            nums1Index[0] += k/2;
            return findKth(nums1, nums1Index, nums2, nums2Index, k - k/2);
        }
    }

    public int kth(int[] a, int[] b, int k) {
        // Write your solution here

        return findKth(a, new int[] {0}, b, new int[]{0}, k);
    }
}
