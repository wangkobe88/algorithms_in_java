package sorting;

/**
 * Created by kewang on 14/12/18.
 */
public class SortColors {
    private int sortColorsHelper(int[] nums, int start, int end, int preValue) {
        int i = start;
        int j = end;
        while(i <= j) {
            if(nums[i] == preValue) {
                i++;
            } else if(nums[j] != preValue) {
                j--;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int start = sortColorsHelper(nums, 0, nums.length - 1, 0);
        if(start < nums.length - 1) {
            sortColorsHelper(nums, start, nums.length - 1, 1);
        }
    }
}
