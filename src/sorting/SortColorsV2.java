package sorting;

/**
 * Created by kewang on 14/12/18.
 */
//3个挡板，一个浏览，一个从开始到其，一个从其到结尾。
//逻辑不太好想

public class SortColorsV2 {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int zeroPos = 0;
        int twoPos = nums.length - 1;
        int current = 0;
        while(current <= twoPos) {

            if(nums[current] == 0) {
                swap(nums, current, zeroPos);
                zeroPos++;
                current++;
            } else if(nums[current] == 2) {
                swap(nums, current, twoPos);
                twoPos--;
            } else {
                current++;
            }
        }
    }
}
